package edu.issilab.zadanie56;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.ButtonGroup;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntervalBox extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	ClientPreferences preferences;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntervalBox frame = new IntervalBox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IntervalBox() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSelectInterval = new JLabel("Select Interval [s] : ");
		contentPane.add(lblSelectInterval, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton rdbtns = new JRadioButton("10");
		buttonGroup.add(rdbtns);
		panel.add(rdbtns);
		
		JRadioButton rdbtns_1 = new JRadioButton("15");
		buttonGroup.add(rdbtns_1);
		panel.add(rdbtns_1);
		
		JRadioButton rdbtns_2 = new JRadioButton("30");
		buttonGroup.add(rdbtns_2);
		panel.add(rdbtns_2);
		
		JRadioButton radioButton = new JRadioButton("60");
		buttonGroup.add(radioButton);
		panel.add(radioButton);
		
		JButton btnSetValue = new JButton("Set value");
		btnSetValue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		contentPane.add(btnSetValue, BorderLayout.SOUTH);
	}
	
	public IntervalBox(ClientPreferences preferences) {
		this();
		this.preferences = preferences;
	}

}
