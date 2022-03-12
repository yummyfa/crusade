/**
 * @Author: wangliang
 * @Date: 2022/2/18 15:12
 */
public class Test2 {
    static int a;
    static int b;
    static int y;
    static int x;
    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        while (true) {
            a = 0;
            b = 0;
            y = 0;
            x = 0;
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            count++;
            if (x == 0 && y == 0) {
                System.out.println("第"+count+"次");
                break;
            }
        }
    }
}
