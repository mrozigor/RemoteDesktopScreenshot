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
	
	public ProcessRequest() {
		
	}
	
	public ProcessRequest(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public void process(String fromUser, DataInputStream stdIn) {
		try {
			Socket socket = new Socket(host, port);
			RemoteDesktopProtocol protocol = new RemoteDesktopProtocol();
			BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
			PrintStream out = new PrintStream(socket.getOutputStream());
			protocol.processRequest(in, out, fromUser, stdIn);
			System.out.println("Command: ");
			socket.close();	
			out.close();
			in.close();
		} catch (UnknownHostException e) {
			System.err.println("Nie znalaz�em hosta");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Nie mog� znale�� po��czenia z hostem");
			System.exit(1);
		}	
	}
		
	
}
