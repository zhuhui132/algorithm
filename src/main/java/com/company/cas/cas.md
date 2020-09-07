在Java并发中，我们最初接触的应该就是synchronized关键字了，
但是synchronized属于重量级锁，很多时候会引起性能问题，volatile也是个不错的选择，
但是volatile不能保证原子性，只能在某些场合下使用。
像synchronized这种独占锁属于悲观锁，
它是在假设一定会发生冲突的，那么加锁恰好有用，除此之外，
还有乐观锁，乐观锁的含义就是假设没有发生冲突，那么我正好可以进行某项操作，
如果要是发生冲突呢，那我就重试直到成功，乐观锁最常见的就是CAS。
我们在读Concurrent包下的类的源码时，
发现无论是ReenterLock内部的AQS，还是各种Atomic开头的原子类，内部都应用到了CAS，
最常见的就是我们在并发编程时遇到的i++这种情况。传统的方法肯定是在方法上加上synchronized关键字:
者获得授权，非商业转载请注明出处。