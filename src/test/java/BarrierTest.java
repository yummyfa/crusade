import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangliang
 * @date 2022/7/16 16:25
 */
public class BarrierTest {

    private int x ,y;
    private int a ,b;

    @Test
    void test() throws InterruptedException {

        int i = 0;
        while (true){
            x = 0;
            y=0;
            a=0;
            b= 0;
            CountDownLatch countDownLatch = new CountDownLatch(2);
            i++;
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                    countDownLatch.countDown();
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                    countDownLatch.countDown();
                }
            });
            thread1.start();
            thread2.start();
            countDownLatch.await();
            if (x == 0 && y ==0) {
                System.out.println("第" + i +"次， x和y的值都为0");
                break;
            }
        }
    }
}
