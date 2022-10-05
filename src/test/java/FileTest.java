import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author wangliang
 * @date 2022/8/13 19:13
 */
public class FileTest {

    @Test
    public void getFile() throws FileNotFoundException {
        try {
            FileOutputStream stream = new FileOutputStream("C:\\Users\\888\\Desktop\\111.txt");
            OutputStreamWriter outputStream = new OutputStreamWriter(stream, StandardCharsets.UTF_8);
            outputStream.write("fafa",1,3);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileOutPutTest() throws FileNotFoundException {
        try {
            FileOutputStream stream = new FileOutputStream("C:\\Users\\888\\Desktop\\111.txt");
            OutputStreamWriter outputStream = new OutputStreamWriter(stream, StandardCharsets.UTF_8);
            outputStream.write("fafa",1,3);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  测试FileChannel 类
     */
    @Test
    public void fileOutput() {
        try {
            // 获取文件
            FileChannel readChannel = FileChannel.open(Paths.get("C:\\Users\\888\\Desktop\\Snipaste_2022-08-26_22-53-35.png"), StandardOpenOption.READ);
            MappedByteBuffer data = readChannel.map(FileChannel.MapMode.READ_ONLY, 0, readChannel.size());
            FileChannel writeChannel = FileChannel.open(Paths.get("C:\\Users\\888\\Desktop\\222.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            //数据传输
            writeChannel.write(data);
            readChannel.close();
            writeChannel.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 测试sendfile
     *  ? 使用到了零拷贝
     */
    @Test
    public void sendFile() {
        try {
            long l = System.currentTimeMillis();
            FileChannel readChannel = FileChannel.open(Paths.get("C:\\software\\jdk-8u241-windows-x64.exe"), StandardOpenOption.READ);
            FileChannel writeChannel = FileChannel.open(Paths.get("C:\\software\\history\\jdk-8u241-windows-x64.exe"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            long size = readChannel.size();
            long position = readChannel.position();
            readChannel.transferTo(position,size, writeChannel);
            readChannel.close();
            writeChannel.close();
            long l1 = System.currentTimeMillis();
            System.out.println(l1-l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @Test
    public void sendFile1() throws IOException {
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            long l = System.currentTimeMillis();
            fis =new FileInputStream("C:\\software\\jdk-8u241-windows-x64.exe");
            fos=new FileOutputStream("C:\\software\\history\\jdk-8u241-windows-x64.exe");
            byte[] bytes = new byte[1024 * 1024];//1MB
            int readCount=0;
            while((readCount=fis.read(bytes))!=-1){
                fos.write(bytes,0,readCount);
            }
            fos.flush();
            long l1 = System.currentTimeMillis();
            System.out.println(l1-l);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            fis.close();
            fos.close();
        }
    }
}
