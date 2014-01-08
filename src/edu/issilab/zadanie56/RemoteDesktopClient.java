package edu.issilab.zadanie56;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RemoteDesktopClient extends JFrame {

	private JPanel mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoteDesktopClient frame = new RemoteDesktopClient();
					frame.setVisible(true);
					//TODO
					//Path - path and file name pattern; Format - picture format; Interval - screenshoot requests interval;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RemoteDesktopClient() {
		setTitle("Remote Desktop Screenshot Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton pathButton = new JButton("Path");
		pathButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser savepath = new JFileChooser();
				try {
					savepath.showSaveDialog(null);
				} catch(HeadlessException err) {
					// Todo okienko MessageBox
				}
				
			}
		});
		menuBar.add(pathButton);
		
		JButton formatButton = new JButton("Format");
		formatButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO
			}
		});
		menuBar.add(formatButton);
		
		JButton intervalButton = new JButton("Interval");
		intervalButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO
			}
		});
		menuBar.add(intervalButton);
		
		JButton startButton = new JButton("Start");
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO 
			}
		});
		startButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		menuBar.add(startButton);
		
		JLabel lblCurrentPictureDate = new JLabel("   Current picture date");
		menuBar.add(lblCurrentPictureDate);
		mainFrame = new JPanel();
		mainFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainFrame.setLayout(new BorderLayout(0, 0));
		setContentPane(mainFrame);
		
	}
	

}
