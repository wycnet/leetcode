package extra.t1_1;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Main3 {

    private static final int maxSize = 5;
    private LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(maxSize);
    private int start = 0;

    /**
     * 生产者
     */
    public void producer() {
        while (true) {
            try {
                System.out.println(Thread.currentThread() + "生产者，生产：" + start);
                queue.put(start++);
                Thread.sleep(new Random().nextInt(2000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void consumer() {
        while (true) {
            try {
                int x = queue.take();
                System.out.println(Thread.currentThread() + "消费:" + x);
                Thread.sleep(new Random().nextInt(2000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Main3 producerConsumer = new Main3();
        for (int i = 0; i < 10; i++) {
            new Thread(producerConsumer::consumer);
            new Thread(producerConsumer::producer);
        }
    }
}
