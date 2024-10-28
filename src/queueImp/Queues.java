package queueImp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Queues extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sizeField;
	private JTextField elementField;
	private JTextField outputField;
	private int[] queArr;
	private int size;
	private int element;
	private int front = -1;
	private int rear = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queues frame = new Queues();
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
	public Queues() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 601);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 226, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Queue Implementation");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(255, 54, 294, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterSize = new JLabel("Enter size");
		lblEnterSize.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterSize.setBounds(63, 138, 118, 50);
		contentPane.add(lblEnterSize);
		
		JLabel lblEnterElement = new JLabel("Enter element");
		lblEnterElement.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterElement.setBounds(63, 235, 156, 50);
		contentPane.add(lblEnterElement);
		
		sizeField = new JTextField();
		sizeField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sizeField.setBounds(255, 138, 173, 50);
		contentPane.add(sizeField);
		sizeField.setColumns(10);
		
		elementField = new JTextField();
		elementField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		elementField.setEditable(false);
		elementField.setColumns(10);
		elementField.setBounds(255, 235, 173, 50);
		contentPane.add(elementField);
		
		outputField = new JTextField();
		outputField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		outputField.setEditable(false);
		outputField.setColumns(10);
		outputField.setBounds(255, 339, 393, 50);
		contentPane.add(outputField);
		
		JButton btnAddSize = new JButton("Add size");
		btnAddSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				size = Integer.parseInt(sizeField.getText());
				if (size <= 0 ) {
					outputField.setText("Enter valid size.");
					sizeField.setText("");
				} else {
					queArr = new int[size];
					outputField.setText("Queue of size " + size + " created.");
				}
				sizeField.setEditable(false);
				elementField.setEditable(true);
			}
		});
		btnAddSize.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddSize.setBounds(513, 133, 135, 55);
		contentPane.add(btnAddSize);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sizeField.setText("");
				sizeField.setEditable(true);
				elementField.setText("");
				elementField.setEditable(false);
				outputField.setText("");
				queArr = null;
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(513, 233, 135, 55);
		contentPane.add(btnReset);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				element = Integer.parseInt(elementField.getText());
				if (rear == size - 1) {
					outputField.setText("Queue is full.");
					elementField.setText("");
				} else {
					rear++;
					queArr[rear] = element;
					elementField.setText("");
					outputField.setText("Element " + element + " is inserted into the queue.");
				}
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsert.setBounds(255, 440, 135, 55);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((front == -1 && rear == -1) || front == size - 1) {
					outputField.setText("Queue is empty.");
				} else {
					front++;
					outputField.setText("Element " + queArr[front] + " is deleted from the queue.");
					queArr[front] = 0;
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(426, 440, 135, 55);
		contentPane.add(btnDelete);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((front == -1 && rear == -1) || (front == size - 1)) {
					outputField.setText("Queue is empty.");
				} else {
					String str = "";
					for (int i = front + 1; i <= rear; i++) {
						str += queArr[i] + " ";
					}
					outputField.setText(str);
				}
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplay.setBounds(596, 440, 135, 55);
		contentPane.add(btnDisplay);
	}

}
