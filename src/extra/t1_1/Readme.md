# 生产者消费者模型

Java实现同步的方法

- Object的wait()、notify()
- Lock和Condition 的await() singal()
- BlockingQueue的阻塞队列方法
- PipedInputStream / PipedOutputStream

## 使用Object() 的 wait() notify()

wait() 和 notify() 方法是Object方法，wait() 执行后需要需要被其他线程执行notify()/notifyAll()唤起。

Thread.sleep() 方法是Thread方法，定时结束后自动唤醒。

[代码](./Main.java)

## Lock和Condition

JDK5.0 以后提供的 Condition接口的await()、signal() 方法， 基本功能和 Object的wait()、notify() 相同。 可与Lock配合使用。

[代码](./Main2.java)

## blockingQueue

JDK1.5以后新增`java.util.concurrent`包新增接口BlockingQueue，并提供一下实现。

- ArrayBlockingQueue
- LinkedBlockingQueue
- SynchronousQueue
- PriorityBlockingQueue

- put() : 容量到达上限时自动阻塞
- take() : 容量为0时自动阻塞

[代码](./Main3.java)
