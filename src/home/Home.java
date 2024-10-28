package home;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arrayImp.Arrays;
import circularQueImp.CircularQueues;
import linkedlistImp.LinkedLists;
import queueImp.Queues;
import stackImp.Stacks;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1408, 882);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose DataStructure");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 123, 393, 60);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Stack");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame stackFrame = new Stacks();
				stackFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				stackFrame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(221, 211, 154, 53);
		contentPane.add(btnNewButton);
		
		JButton btnArray = new JButton("Array");
		btnArray.setForeground(new Color(0, 0, 0));
		btnArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Arrays arr = new Arrays();
//				arr.main(null);
				JFrame arrayFrame = new Arrays();
				arrayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				arrayFrame.setVisible(true);
			}
		});
		btnArray.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnArray.setBounds(21, 211, 154, 53);
		contentPane.add(btnArray);
		
		JButton btnQueue = new JButton("Queue");
		btnQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame queueFrame = new Queues();
				queueFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				queueFrame.setVisible(true);
			}
		});
		btnQueue.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQueue.setBounds(221, 300, 154, 53);
		contentPane.add(btnQueue);
		
		JButton btnLinkedlist = new JButton("LinkedList");
		btnLinkedlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame listFrame = new LinkedLists();
				listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				listFrame.setVisible(true);
			}
		});
		btnLinkedlist.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLinkedlist.setBounds(21, 300, 154, 53);
		contentPane.add(btnLinkedlist);
		
		JButton btnCircularQueue = new JButton("Circular Queue");
		btnCircularQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame cirQueFrame = new CircularQueues();
				cirQueFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				cirQueFrame.setVisible(true);
			}
		});
		btnCircularQueue.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCircularQueue.setBounds(100, 397, 212, 53);
		contentPane.add(btnCircularQueue);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Java\\DS_Imp_WindowBuilder\\img\\chooseDS.jpg"));
		lblNewLabel_1.setBounds(0, -136, 1417, 1055);
		contentPane.add(lblNewLabel_1);
	}
}
