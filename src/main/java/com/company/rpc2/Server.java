package com.company.rpc2;

import java.io.IOException;


//服务中心代码实现，代码如下：
public interface Server { public void stop();

    public void start() throws IOException;

    public void register(Class serviceInterface, Class impl);

    public boolean isRunning();

    public int getPort();
}