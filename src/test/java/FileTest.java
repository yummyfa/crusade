import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
            FileChannel readChannel = FileChannel.open(Paths.get("D:\\05.xmind\\xmind\\xmind-8-update7-windows.exe"), StandardOpenOption.READ);
            FileChannel writeChannel = FileChannel.open(Paths.get("C:\\Users\\888\\Desktop\\xmind-8-update7-windows.exe"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
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
}
