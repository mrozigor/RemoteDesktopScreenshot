package edu.issilab.zadanie56;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Igor
 * @author Marcel
 * 
 */
public class RemoteDesktopProtocol {
	public void processRequest(BufferedInputStream in, PrintStream out, String fromUser,
			DataInputStream stdIn) throws IOException {
		int b;
		String format;
		if ((format = getFormat(fromUser)) != null) {
			out.println(format);
			out.flush();
			System.out.println("Where save the file? (Ex. C:\\shot.jpg):");
			FileOutputStream file = new FileOutputStream(stdIn.readLine());
			while ((b = in.read())  != -1) {
				file.write(b);
			}
			System.out.println("Finish!\n");
			file.close();
		}
	}

	private String getFormat(String fromClient) {
		if (fromClient.equalsIgnoreCase("exit")) {
			System.exit(0);
			return null;
		} else if (fromClient.equalsIgnoreCase("shot jpg")) {
			return "JPG";
		} else if (fromClient.equalsIgnoreCase("shot jpeg")) {
			return "JPEG";
		} else if (fromClient.equalsIgnoreCase("shot bmp")) {
			return "BMP";
		} else if (fromClient.equalsIgnoreCase("shot wbmp")) {
			return "WBMP";
		} else if (fromClient.equalsIgnoreCase("shot png")) {
			return "PNG";
		} else if (fromClient.equalsIgnoreCase("shot gif")) {
			return "GIF";
		} else {
			System.out
					.println("Invalid command. Correct commands: shot [jpg, jpeg, bmp, wbmp, png, gif], exit.");
			return null;
		}
	}
}
