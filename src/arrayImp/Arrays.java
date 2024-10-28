package arrayImp;

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

public class Arrays extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sizeField;
	private JTextField elementField;
	private JTextField indexField;
	private JTextField outputField;
	private int[] arr;
	private int size;
	private int element;
	private int index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arrays frame = new Arrays();
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
	public Arrays() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 226, 222));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Array Implementation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(283, 20, 269, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterSize = new JLabel("Enter size");
		lblEnterSize.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterSize.setBounds(107, 115, 118, 51);
		contentPane.add(lblEnterSize);
		
		JLabel lblEnterElement = new JLabel("Enter element");
		lblEnterElement.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterElement.setBounds(107, 189, 140, 51);
		contentPane.add(lblEnterElement);
		
		JLabel lblEnterIndex = new JLabel("Enter index");
		lblEnterIndex.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterIndex.setBounds(107, 264, 118, 51);
		contentPane.add(lblEnterIndex);
		
		sizeField = new JTextField();
		sizeField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sizeField.setBounds(283, 123, 140, 41);
		contentPane.add(sizeField);
		sizeField.setColumns(10);
		
		elementField = new JTextField();
		elementField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		elementField.setEditable(false);
		elementField.setColumns(10);
		elementField.setBounds(283, 189, 140, 41);
		contentPane.add(elementField);
		
		indexField = new JTextField();
		indexField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		indexField.setEditable(false);
		indexField.setColumns(10);
		indexField.setBounds(283, 264, 140, 41);
		contentPane.add(indexField);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				element = Integer.parseInt(elementField.getText());
				index = Integer.parseInt(indexField.getText());
				if (index >= 0 && index < size) {
					outputField.setText("Element " + element + " inserted at index " + index + ".");
					arr[index] = element;
					elementField.setText("");
					indexField.setText("");
				} else {
					outputField.setText("Please enter valid index.");
				}
			}
		});
		btnInsert.setBounds(283, 416, 118, 51);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = Integer.parseInt(indexField.getText());
				if (index >= 0 && index < size) {
					if (arr[index] == 0) {
						outputField.setText("No value found at index " + index + ".");
					} else {
						outputField.setText("Element " + arr[index] + " deleted.");
						arr[index] = 0;
						indexField.setText("");
					}
				} else {
					outputField.setText("Please enter valid index.");
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(424, 416, 118, 51);
		contentPane.add(btnDelete);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (arr == null) {
					outputField.setText("Array doesn't exist.");
					return;
				}
				outputField.setText(java.util.Arrays.toString(arr));
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplay.setBounds(570, 416, 118, 51);
		contentPane.add(btnDisplay);
		
		JButton btnAddSize = new JButton("Add size");
		btnAddSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				size = Integer.parseInt(sizeField.getText());
				if (size > 0) {
					arr = new int[size];
					outputField.setText("Array of size " + size + " created.");
					sizeField.setEditable(false);
					elementField.setEditable(true);
					indexField.setEditable(true);
				} else {
					outputField.setText("Please enter valid size.");
				}
			}
		});
		btnAddSize.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddSize.setBounds(502, 115, 118, 51);
		contentPane.add(btnAddSize);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sizeField.setText("");
				sizeField.setEditable(true);
				indexField.setText("");
				indexField.setEditable(false);
				elementField.setText("");
				elementField.setEditable(false);
				outputField.setText("");
				arr = null;
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(502, 189, 118, 51);
		contentPane.add(btnReset);
		
		outputField = new JTextField();
		outputField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		outputField.setEditable(false);
		outputField.setBounds(283, 342, 289, 41);
		contentPane.add(outputField);
		outputField.setColumns(10);
	}
}
