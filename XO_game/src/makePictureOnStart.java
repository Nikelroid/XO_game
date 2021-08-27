import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
public class makePictureOnStart {

    public String make() throws IOException {
        int width = 240;
        int height = 240;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.black);
        g2d.drawLine(0, 80, 240, 80);
        g2d.drawLine(0, 160, 240, 160);
        g2d.drawLine(80, 0, 80, 240);
        g2d.drawLine(160, 0, 160, 240);
        g2d.setColor(Color.orange);
        g2d.setFont(g2d.getFont().deriveFont(80f));
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g2d.drawString(count+"", 12+(80*j), 70+(80*i));
                count++;
            }
        }
        g2d.dispose();
        File file = new File("start.png");
        ImageIO.write(bufferedImage, "png", file);

                byte[] fileContent = new byte[0];
        String encodedString = null;

            try {
                fileContent = FileUtils.readFileToByteArray(file);
                encodedString = Base64.getEncoder().encodeToString(fileContent);
            } catch (IOException ioException) {
                encodedString = "";
            }
        return encodedString;
    }
}
