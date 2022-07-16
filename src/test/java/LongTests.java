import sun.misc.Contended;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class LongTests {

    private static final long COUNT = 10000000L;

//    @Contended
    private static class T {
//        private long m1, m2, m3, m4, m5, m6, m7;
        long x = 0L;
//        private long n1, n2, n3, n4, n5, n6, n7;
    }

    private static T[] arr = new T[2];

    //
    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        List<Long> longs = new ArrayList<>();
        List<Long> longs1 = new ArrayList<>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (long i = 0; i < COUNT; i++) {
                    arr[0].x = i;
                }
                countDownLatch.countDown();
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (long i = 0; i < COUNT; i++) {
                    arr[1].x = i;
                }
                countDownLatch.countDown();
            }
        });
        final long start = System.nanoTime();
        long l = System.currentTimeMillis();
        thread.start();
        thread1.start();
        countDownLatch.await();
        long end = System.nanoTime();
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
        System.out.println(end-start);

    }
}
