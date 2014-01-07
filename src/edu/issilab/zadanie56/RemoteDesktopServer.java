/**
 * 
 */
package edu.issilab.zadanie56;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

/**
 * Remote desktop server class. Server works asynchronously and starts threads
 * implemented as instances of statically nested class. Screenshots in form of
 * JPG documents are served to the client.
 * 
 * @author Andrzej Marciniak
 * @author Igor Mróz
 */
public class RemoteDesktopServer {

	/**
	 * Class providing service of remote desktop for a single TCP request.
	 * 
	 */
	private static class ServiceThread extends Thread {
		private Socket client;

		public ServiceThread(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {
			DataInputStream in;
			String fromClient;
			try {
				in = new DataInputStream(new BufferedInputStream(
						client.getInputStream()));
				BufferedOutputStream out = new BufferedOutputStream(client.getOutputStream());
				while ((fromClient = in.readLine()) != null) {
					ByteArrayOutputStream memBuffer = new ByteArrayOutputStream();// buffer
																					// in
																					// memory
					Robot robot = new Robot();
					BufferedImage screenShot = robot.createScreenCapture(new Rectangle(
							Toolkit.getDefaultToolkit().getScreenSize()));// creating
																			// screenshot
					ImageIO.write(screenShot, fromClient, memBuffer);// writing to buffer in
																// memory
					byte buffer[] = memBuffer.toByteArray();
					out.write(buffer); // sending data to requester
					System.out.println("Screenshot of " + buffer.length
							+ " bytes sent to: " + client.getInetAddress());
					out.close();
				}
				in.close();
				client.close();
			} catch (IOException e) {
				System.err.println("Streaming problem to " + client.getInetAddress().toString());
			} catch (AWTException e) {
				System.err.println("Problem with image capturing.");
			}
		}

	}

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		boolean listening = true; // needed for if condition (unreacheable code
									// otherwise)

		try {
			serverSocket = new ServerSocket(4000);
		} catch (IOException e) {
			System.err.println("Unavailable listening port: 4000.");
			System.exit(1);
		}
		try {
			while (listening) {
				clientSocket = serverSocket.accept();
				new ServiceThread(clientSocket).start();
			}
			serverSocket.close();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}

	}

}
