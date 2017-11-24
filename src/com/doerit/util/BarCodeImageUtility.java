package com.doerit.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import com.itextpdf.text.pdf.Barcode128;

public class BarCodeImageUtility {

	public static BufferedImage createBarCode(String text, float height) {
		Barcode128 barCode = new Barcode128();
		barCode.setCode(text);
		barCode.setBarHeight(height); //default 60f
		barCode.setX(5f);
		
		Image image = barCode.createAwtImage(Color.BLACK, Color.WHITE);
		return toBufferedImage(image);	
	}
	
	public static BufferedImage toBufferedImage(Image image) {
	    if (image instanceof BufferedImage){
	        return (BufferedImage) image;
	    }

	    BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);

	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(image, 0, 0, null);
	    bGr.dispose();

	    return bimage;
	}
	
}
