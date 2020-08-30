package com.company.rpc2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ServiceCenter implements Server {


    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    //使用线程池
   // private static ExecutorService executor = new ThreadPoolExecutor(0,0,0,null,Runtime.getRuntime().availableProcessors());

    private static final HashMap<String,Class> serviceRegistry = new HashMap <String, Class>();
    private static boolean isRunning = false;
    private  int port;


    public ServiceCenter(int port){
        this.port = port;
    }

    @Override
    public void stop() {
        isRunning = false;
        executor.shutdown();

    }

    @Override
    public void start() throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(port));
        System.out.println("start server");
        try {
            while (true){
                // 1.监听客户端的TCP连接，接到TCP连接后将其封装成task，由线程池执行
                executor.execute(new ServiceTask(server.accept()));

            }
        }
        finally {
            server.close();
        }


    }

    @Override
    public void register(Class serviceInterface, Class impl) {
        serviceRegistry.put(serviceInterface.getName(),impl );
        System.out.println(serviceInterface.getName()+impl.getName());

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPort() {
        return port;
    }



    private static class ServiceTask implements Runnable{
        Socket clent = null;
        public ServiceTask(Socket client) {
            this.clent = client;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            ObjectInputStream inputStream = null;
            ObjectOutputStream outputStream =null;

            try {
                // 2.将客户端发送的码流反序列化成对象，反射调用服务实现者，获取执行结果
                inputStream = new ObjectInputStream(clent.getInputStream());
                String serviceName = inputStream.readUTF();
                String methodName = inputStream.readUTF();

                Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();
                Object[] arguments = (Object[]) inputStream.readObject();
                Class serviceClass = serviceRegistry.get(serviceName);

                if (serviceClass == null){
                    throw  new ClassNotFoundException(serviceName+" not found ");
                }

                Method  method = serviceClass.getMethod(methodName,parameterTypes);
                Object result = method.invoke(serviceClass.newInstance(),arguments);
                // 3.将执行结果反序列化，通过socket发送给客户端
                outputStream = new ObjectOutputStream(clent.getOutputStream());
                outputStream.writeObject(result);


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (clent != null) {
                    try {
                        clent.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}