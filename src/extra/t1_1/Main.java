package extra.t1_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {

    private Queue<Integer> queue = new LinkedList<>();
    private static final int maxSize = 5;
    int start = 0;

    /**
     * 生产者
     */
    public void producer() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println(Thread.currentThread() + "缓存区已满，让出线程！");
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + "生产者，生产出：" + start);
                queue.offer(start++);
                queue.notifyAll();
                try {
                    Thread.sleep(new Random(System.currentTimeMillis()).nextInt(2000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 消费者
     */
    public void consumer() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println(Thread.currentThread() + "缓存区空，让出线程");
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                int x = queue.poll();
                System.out.println(Thread.currentThread() + "消费：" + x);
                queue.notifyAll();
                try {
                    Thread.sleep(new Random(System.currentTimeMillis()).nextInt(2000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        Main main = new Main();

        // 生产者
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    main.consumer();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    main.producer();
                }
            }).start();

        }
    }

}
