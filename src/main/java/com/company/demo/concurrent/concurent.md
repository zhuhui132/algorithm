# 熟悉concurent 包


1：阻塞队列 BlockingQueue
  java.util.concurrent 包里的 BlockingQueue 接口表示一个线程安放入和提取实例的队列。
  本小节我将给你演示如何使用这个 BlockingQueue。
  本节不会讨论如何在 Java 中实现一个你自己的 BlockingQueue。
  如果你对那个感兴趣，参考《Java 并发指南》
  JDK中自带ArrayBlockingQueue、ListBlockingQueue等阻塞的队列。我们也可以认为自己实现一个。