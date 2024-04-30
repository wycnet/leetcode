package extra.t1_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main2 {

    private static final int maxSize = 10;

    private final Lock lock = new ReentrantLock();
    private final Condition fullCondition = lock.newCondition();
    private final Condition emptyCondition = lock.newCondition();

    private final Queue<Integer> queue = new LinkedList<>();

    private int start = 0;

    /**
     * 生产者
     */
    public void producer() {
        while (true) {
            lock.lock();
            while (queue.size() == maxSize) {
                try {
                    System.out.println(Thread.currentThread() + "缓存区已满，让出线程！");
                    fullCondition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread() + "生产值：" + start);
            queue.offer(start++);

            fullCondition.signalAll();
            emptyCondition.signalAll();

            lock.unlock();

            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费者
     */
    public void consumer() {
        while (true) {
            lock.lock();
            while (queue.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread() + "混存区已满");
                    emptyCondition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int x = queue.poll();
            System.out.println(Thread.currentThread() + "消费：" + x);

            fullCondition.signalAll();
            emptyCondition.signalAll();
            lock.unlock();

            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Main2 consumerProducer = new Main2();
        for (int i = 0; i < 5; i++) {
            new Thread(consumerProducer::consumer).start();
            new Thread(consumerProducer::producer).start();
        }
    }
}
