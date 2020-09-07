//package com.easy;
//
//import org.apache.commons.lang3.time.StopWatch;
//
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//public class Demo {
//    private final static ThreadPoolExecutor POOL_EXECUTOR =
//            new ThreadPoolExecutor(AVALIABLE_PROCESSORS, AVALIABLE_PROCESSORS * 2,
//                    1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(5),
//                    new ThreadPoolExecutor.CallerRunsPolicy());
//
//    /**
//     * 投递任务，不获取返回值
//     */
//    @Test
//    public void threadPoolAsyncRunnable() {
//        StopWatch watch = new StopWatch();
//        watch.start("ThreadPoolAsyncTask");
//        POOL_EXECUTOR.execute(() -> doSomeThing("task1"));
//        doSomeThing("task2");
//        watch.stop();
//        log.info("total time :{} millisecond", watch.getTotalTimeMillis());
//    }
//
//    /**
//     * 投递任务，同步获取
//     */
//    @Test
//    public void threadPoolAsyncSubmit() throws ExecutionException, InterruptedException {
//        StopWatch watch = new StopWatch();
//        watch.start("ThreadPoolAsyncTask");
//        Future<String> resultFuture = POOL_EXECUTOR.submit(() -> doSomeThing("task1"));
//        doSomeThing("task2");
//        //同步等待结果
//        String result = resultFuture.get();
//        watch.stop();
//        log.info("total time :{} millisecond", watch.getTotalTimeMillis());
//    }
//}