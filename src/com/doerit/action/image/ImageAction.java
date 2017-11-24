package com.doerit.action.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.doerit.util.BarCodeImageUtility;
import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private byte[] imageInByte = null;
	private String q;

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String execute() {
		return SUCCESS;
	}
	
	public byte[] getCustomImageInBytes() {

		BufferedImage originalImage;
		try {
			
			originalImage = BarCodeImageUtility.createBarCode(this.q, 60f);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "png", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return imageInByte;
	}

	public String getCustomContentType() {
		return "image/png";
	}

	public String getCustomContentDisposition() {
		return "anyname.jpg";
	}

}
