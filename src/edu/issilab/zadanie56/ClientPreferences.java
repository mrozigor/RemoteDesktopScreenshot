/**
 * 
 */
package edu.issilab.zadanie56;

/**
 * @author Igor
 *
 */

public class ClientPreferences {
	
	private String path = "";
	private String nameFormat = "DD-MM-YYYY hh:mm";
	private String pictureFormat = "png";
	private int interval = 5000; //ms
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getNameFormat() {
		return nameFormat;
	}
	public void setNameFormat(String nameFormat) {
		this.nameFormat = nameFormat;
	}
	public String getPictureFormat() {
		return pictureFormat;
	}
	public void setPictureFormat(String pictureFormat) {
		this.pictureFormat = pictureFormat;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}

}
