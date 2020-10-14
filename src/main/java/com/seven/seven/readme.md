# 众所周知，HashMap是非线程安全的。
# 而HashMap的线程不安全主要体现在resize时的死循环及使用迭代器时的fast-fail上。