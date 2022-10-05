import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

/**
 * @author wangliang
 * @date 2022/9/10 15:52
 */
public class FrameTest {
    @Test
    public void frame() {
        MianFrame mianFrame = new MianFrame();
        mianFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Frame frame = new Frame("java windows test");
        frame.setBackground(Color.green);
        frame.setSize(800, 800);
        frame.setLocation(200, 200);
        frame.setVisible(true);
    }

    public class MianFrame extends JFrame {
        public MianFrame() {
            this.setTitle("主窗体");
            this.setSize(500, 400);
            this.setLocation(200, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageIcon icon = new ImageIcon("C:\\Users\\888\\Desktop\\Snipaste_2022-09-10_16-00-33.png");
            this.setIconImage(icon.getImage());
            this.setResizable(false);

        }
    }
}
