一年前，笔者刚刚接触RPC框架，从单体式应用向分布式应用的变革无疑是让人兴奋的，
同时也对RPC背后到底做了哪些工作产生了兴趣，
但其底层的设计对新手而言并不是很友好，其涉及的一些常用技术点都有一定的门槛。
如传输层常常使用的netty，之前完全没听过，想要学习它，需要掌握前置知识点nio；协议层，包括了很多自定义的协议，
而每个RPC框架的实现都有差异；代理层的动态代理技术，如jdk动态代理，虽然实战经验不多，
但至少还算会用，而cglib则又有一个盲区；序列化层倒还算是众多层次中相对简单的一环，
但RPC为了追求可扩展性，性能等诸多因素，通常会支持多种序列化方式以供使用者插拔使用，
一些常用的序列化方案hessian，kryo，Protobuf又得熟知…

这个系列打算就RPC框架涉及到的一些知识点进行探讨，本篇先从序列化层的一种选择–kryo开始进行介绍。