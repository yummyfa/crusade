import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.*;


/**
 * @Author: wangliang
 * @Date: 2022/2/17 11:07
 */
@SpringBootTest
public class WebPageTest {

    private static void getNews(){
        try {
            Document doc = Jsoup.connect("https://www.csdn.net/").get();
            Elements elementsByClass = doc.getElementsByClass("headswiper-item");
            Elements strong = elementsByClass.get(1).getElementsByTag("strong");
            String s = strong.toString();
            int strong1 = s.indexOf("strong");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebPageTest webPageTest = new WebPageTest();
    }


    private ExecutorService fixedExecutorService = Executors.newFixedThreadPool(5);

    private ExecutorService singleThreadExecutor  = Executors.newSingleThreadExecutor();

    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public ExecutorService customerExecutorService = new ThreadPoolExecutor(3, 5, 10, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());


    public  void method1(){
        for (int i = 0; i < 10; i++) {
            if (!(fixedExecutorService.isShutdown())){
                fixedExecutorService.execute(new testRunnable());
            }
            fixedExecutorService.shutdown();
        }
    }

    public void method2(){
        for (int i = 0; i < 100; i++) {
            customerExecutorService.execute(new testRunnable());
        }
    }


    private class testRunnable implements Runnable{

        @Override
        public void run() {
            try{
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                System.out.println("please sit down");
            }
        }
    }

}
