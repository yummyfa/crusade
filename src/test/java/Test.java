import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wangliang
 * @Date: 2022/2/16 10:32
 */
class Test {

    @org.junit.jupiter.api.Test
    private void test1(){
        System.out.println("hello world");
    }

    @org.junit.jupiter.api.Test
    public void calculate(){
        int i = 1 << 32;
        System.out.println(i);
        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<String, String>();

    }


    @org.junit.jupiter.api.Test
    Integer ji(int n ){
        int c;
        for (c =0; c<n; c++){
            n &= (n-1);
//            n = n & (n-1);
        }
        return c;
    }

    @org.junit.jupiter.api.Test
    void test2 (){
        int n = 19;
        Integer ji = ji(n);
        System.out.println(ji);
    }

    Integer ji2(int c){
        return 1;
    }
}
