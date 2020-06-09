package utilities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class BufferedImageUtil {
	private BufferedImageUtil(){}
	
	public static BufferedImage copyBufferedImage(BufferedImage toCopy){
		BufferedImage target = new BufferedImage(toCopy.getWidth(), toCopy.getHeight(), toCopy.getType());
		Graphics targetGraphics = target.getGraphics();
		targetGraphics.drawImage(toCopy, 0, 0, null);
		targetGraphics.dispose();
		
		return target;
	}
	public static BufferedImage setBufferedImageType(BufferedImage image, int type){
		if(image.getType() == type)
			return image;
		
		BufferedImage target = new BufferedImage(image.getWidth(), image.getHeight(), type);
		Graphics targetGraphics = target.getGraphics();
		targetGraphics.drawImage(image, 0, 0, null);
		targetGraphics.dispose();	
		
		image = null;
		
		return target;
	}
	public static BufferedImage imageToBufferedImage(Image toConvert){
		BufferedImage returnImage = new BufferedImage(toConvert.getWidth(null), toConvert.getHeight(null), BufferedImage.TYPE_3BYTE_BGR);
		Graphics returnImageGraphics = returnImage.getGraphics();
		returnImageGraphics.drawImage(toConvert, 0, 0, null);
		returnImageGraphics.dispose();	
		
		toConvert = null;
		
		return returnImage;
	}
	
	public static BufferedImage resizeBufferedImage(BufferedImage image, int width, int height, int scaleType){
		Image scaled = image.getScaledInstance(width, height, scaleType);
		image = null;
		
		return imageToBufferedImage(scaled);
	}
}
