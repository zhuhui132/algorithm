//package com.design;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Set;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.function.BiConsumer;
//import java.util.function.BiFunction;
//import java.util.function.Function;
//
///**
// * 实现一个 LRU 缓存，当缓存数据达到 N 之后需要淘汰掉最近最少使用的数据。
// * N 小时之内没有被访问的数据也需要淘汰掉。
// */
//public class LRUCache  extends   java.util.AbstractMap{
//    private final static Logger LOGGER = LoggerFactory.getLogger(LRUCache.class);
//
//
//    /**
//     * 检查是否超期线程
//     */
//    private ExecutorService checkTimePool ;
//    /**
//     * map 最大size
//     */
//    private final static int MAX_SIZE = 1024 ;
//    private final static ArrayBlockingQueue<Node> QUEUE = new ArrayBlockingQueue<>(MAX_SIZE) ;
//    /**
//     * 默认大小
//     */
//    private final static int DEFAULT_ARRAY_SIZE =1024 ;
//    /**
//     * 数组长度
//     */
//    private int arraySize ;
//    /**
//     * 数组
//     */
//    private Object[] arrays ;
//    /**
//     * 判断是否停止 flag
//     */
//    private volatile boolean flag = true ;
//    /**
//     * 超时时间
//     */
//    private final static Long EXPIRE_TIME = 60 * 60 * 1000L ;
//    /**
//     * 整个 Map 的大小
//     */
//    private volatile AtomicInteger size  ;
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    @Override
//    public Set<Entry> entrySet() {
//        return null;
//    }
//
//    @Override
//    public Object getOrDefault(Object key, Object defaultValue) {
//        return null;
//    }
//
//    @Override
//    public void forEach(BiConsumer action) {
//
//    }
//
//    @Override
//    public void replaceAll(BiFunction function) {
//
//    }
//
//    @Override
//    public Object putIfAbsent(Object key, Object value) {
//        return null;
//    }
//
//    @Override
//    public boolean remove(Object key, Object value) {
//        return false;
//    }
//
//    @Override
//    public boolean replace(Object key, Object oldValue, Object newValue) {
//        return false;
//    }
//
//    @Override
//    public Object replace(Object key, Object value) {
//        return null;
//    }
//
//    @Override
//    public Object computeIfAbsent(Object key, Function mappingFunction) {
//        return null;
//    }
//
//    @Override
//    public Object computeIfPresent(Object key, BiFunction remappingFunction) {
//        return null;
//    }
//
//    @Override
//    public Object compute(Object key, BiFunction remappingFunction) {
//        return null;
//    }
//
//    @Override
//    public Object merge(Object key, Object value, BiFunction remappingFunction) {
//        return null;
//    }
//
//    public LRUCache(){
//        arraySize = DEFAULT_ARRAY_SIZE;
//        arrays = new Object[arraySize] ;
//        //开启一个线程检查最先放入队列的值是否超期
//        executeCheckTime();
//    }
//    private void executeCheckTime() {
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
//                .setNameFormat("check-thread-%d")
//                .setDaemon(true)
//                .build();
//        checkTimePool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<>(1),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
//        checkTimePool.execute(new CheckTimeThread()) ;
//    }
//
//
//
//    /**
//     * 链表
//     */
//    private class Node{
//        private Node next ;
//        private Node pre ;
//        private Object key ;
//        private Object val ;
//        private Long updateTime ;
//        public Node(Node pre,Node next, Object key, Object val) {
//            this.pre = pre ;
//            this.next = next;
//            this.key = key;
//            this.val = val;
//            this.updateTime = System.currentTimeMillis() ;
//        }
//        public void setUpdateTime(Long updateTime) {
//            this.updateTime = updateTime;
//        }
//        public Long getUpdateTime() {
//            return updateTime;
//        }
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "key=" + key +
//                    ", val=" + val +
//                    '}';
//        }
//    }
//}