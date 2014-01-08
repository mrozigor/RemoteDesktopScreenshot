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
import javax.swing.SwingConstants;

public class RemoteDesktopClient extends JFrame {

	private JPanel mainFrame;
	private ClientPreferences preferences = new ClientPreferences();
	private boolean startStopChooser = true;

	/**
	 * Launch the application.
	 * @author Igor
	 * @author Marcel
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoteDesktopClient frame = new RemoteDesktopClient();
					frame.setVisible(true);
					//TODO Path - path and file name pattern; Format - picture format; Interval - screenshot requests interval;
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
					preferences.setPath(savepath.getSelectedFile().getAbsolutePath());
					System.out.println(preferences.getPath());
					
				} catch(HeadlessException err) {
					// Todo okienko MessageBox
				}
				
			}
		});
		
		JButton connectionButton = new JButton("Connection");
		connectionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO
			}
		});
		menuBar.add(connectionButton);
		menuBar.add(pathButton);
		
		JButton intervalButton = new JButton("Interval");
		intervalButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO
			}
		});
		menuBar.add(intervalButton);
		
		final JLabel statusLabel = new JLabel("   Status: Stoped");
		final JLabel currentDateLabel = new JLabel("   Current picture date");
		
		final JButton startButton = new JButton("Start");
		startButton.setHorizontalAlignment(SwingConstants.RIGHT);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(preferences.getInterval() != 0) {
					if(startStopChooser == true) {
						startButton.setText("Stop");
						statusLabel.setText("   Status: Started");
						startStopChooser = false;
					} else {
						startButton.setText("Start");
						statusLabel.setText("   Status: Stoped");
						startStopChooser = true;
					}
				}
				new ProcessRequest(preferences);
			}
		});
		startButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		menuBar.add(startButton);
		
		menuBar.add(statusLabel);
		menuBar.add(currentDateLabel);
		
		mainFrame = new JPanel();
		mainFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainFrame.setLayout(new BorderLayout(0, 0));
		setContentPane(mainFrame);
		
	}
	

}
