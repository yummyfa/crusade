import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wangliang
 * @date 2022/7/2 19:50
 */
public class MaTest {

    private static class T {
        public  long p1, p2, p3, p4, p5, p6, p7;
        public  long x = 0L;
        public  long p8, p9, p10, p11, p12, p13, p14;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(()->{
            for (long i = 0; i < 1000_0000L; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(()->{
            for (long i = 0; i < 1000_0000L; i++) {
                arr[1].x = i;
            }
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start)/1000000);
    }
}
