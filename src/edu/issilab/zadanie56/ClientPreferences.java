/**
 * 
 */
package edu.issilab.zadanie56;

/**
 * @author Igor
 * @author Marcel
 * 
 */

public class ClientPreferences {

	private String path = "";
	private String nameFormat = "DD-MM-YYYY hh:mm";
	private int interval = 5000; // ms
	private String host = "localhost";
	private int port = 4000;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

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

	public int getInterval() {
		return interval;
	}

	public void setInterval(int ms) {
		this.interval = ms;
	}

}
