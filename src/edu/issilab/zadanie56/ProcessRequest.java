package edu.issilab.zadanie56;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Igor
 *
 */
public class ProcessRequest {
	String host;
	int port;
	ClientPreferences preferences;
	
	public ProcessRequest(ClientPreferences preferences) {
		this.preferences = preferences;
	}
	
	public ProcessRequest(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public void process(String fromUser, DataInputStream stdIn) {
		try {
			Socket socket = new Socket(host, port);
			BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
			PrintStream out = new PrintStream(socket.getOutputStream());
			System.out.println("Command: ");
			socket.close();	
			out.close();
			in.close();
		} catch (UnknownHostException e) {
			System.err.println("Nie znalaz³em hosta");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Nie mogê znaleŸæ po³¹czenia z hostem");
			System.exit(1);
		}	
	}
		
	
}
