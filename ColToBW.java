
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ColToBW {
	
	//сорса на снимката
	private static File file = new File("C:\\programming\\eclipse\\java\\colTogray\\Tulips.png");

	public static void main(String[] args){
		try {
			if (file.isFile())
				convert(ImageIO.read(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// преобразуване от цветно към чено-бяло
	private static void convert(BufferedImage colImg){
		Color c;
		int sum;
		for (int x = 0; x < colImg.getWidth(); x++) {
			for (int y = 0; y < colImg.getHeight(); y++) {
				c = new Color(colImg.getRGB(x, y));
				sum = (int) ((c.getRed() * 0.299) + (c.getGreen() * 0.587) + (c.getBlue() * 0.114));
				colImg.setRGB(x, y, new Color(sum, sum, sum).getRGB());
			}
		}
		saveToFile(colImg);
	}
	// записване към файл
	private static void saveToFile(BufferedImage image){
		try {
			ImageIO.write(image, "png", new File("C:\\programming\\eclipse\\java\\colTogray\\grayTulips.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
