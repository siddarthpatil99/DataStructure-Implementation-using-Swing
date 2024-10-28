package linkedlistImp;

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

public class LinkedLists extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField elementField;
	private JTextField outputField;
	LinkedListStructure listStructure = new LinkedListStructure();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinkedLists frame = new LinkedLists();
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
	public LinkedLists() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 226, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LinkedList Implmentation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(267, 38, 332, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterElement = new JLabel("Enter element");
		lblEnterElement.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterElement.setBounds(65, 123, 145, 39);
		contentPane.add(lblEnterElement);
		
		elementField = new JTextField();
		elementField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		elementField.setBounds(267, 126, 205, 39);
		contentPane.add(elementField);
		elementField.setColumns(10);
		
		JButton btnInsertFirst = new JButton("Insert First");
		btnInsertFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int element = Integer.parseInt(elementField.getText());
				listStructure.insertFirst(element);
				elementField.setText("");
				outputField.setText("Element " + element + " is inserted at first.");
			}
		});
		btnInsertFirst.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsertFirst.setBounds(267, 266, 152, 48);
		contentPane.add(btnInsertFirst);
		
		JButton btnInsertLast = new JButton("Insert Last");
		btnInsertLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int element = Integer.parseInt(elementField.getText());
				listStructure.insertLast(element);
				elementField.setText("");
				outputField.setText("Element " + element + " is inserted at last.");
			}
		});
		btnInsertLast.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsertLast.setBounds(473, 266, 152, 48);
		contentPane.add(btnInsertLast);
		
		JButton btnDeleteFirst = new JButton("Delete First");
		btnDeleteFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputField.setText(listStructure.deleteFirst());
			}
		});
		btnDeleteFirst.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeleteFirst.setBounds(267, 348, 152, 48);
		contentPane.add(btnDeleteFirst);
		
		JButton btnDeleteLast = new JButton("Delete Last");
		btnDeleteLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputField.setText(listStructure.deleteLast());
			}
		});
		btnDeleteLast.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeleteLast.setBounds(473, 348, 152, 48);
		contentPane.add(btnDeleteLast);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputField.setText(listStructure.display());
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplay.setBounds(376, 422, 152, 48);
		contentPane.add(btnDisplay);
		
		outputField = new JTextField();
		outputField.setEditable(false);
		outputField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		outputField.setColumns(10);
		outputField.setBounds(267, 199, 358, 39);
		contentPane.add(outputField);
	}

}
