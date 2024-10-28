package stackImp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Stacks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sizeField;
	private JTextField elementField;
	private JTextField outputField;
	int[] stackArr;
	int top = -1;
	int size;
	int element;
	
	public void displayStack() {
		if (stackArr == null) {
			outputField.setText("Stack is empty.");
			return;
		}
		
		String str = "";
		for (int i = 0; i <= top; i++) {
			str += stackArr[i] + " ";
		}
		outputField.setText(str);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stacks frame = new Stacks();
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
	public Stacks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 226, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stack Implementation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(195, 34, 270, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterSize = new JLabel("Enter size");
		lblEnterSize.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterSize.setBounds(31, 130, 114, 50);
		contentPane.add(lblEnterSize);
		
		sizeField = new JTextField();
		sizeField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sizeField.setBounds(195, 137, 149, 44);
		contentPane.add(sizeField);
		sizeField.setColumns(10);
		
		JLabel lblEnterElement = new JLabel("Enter element");
		lblEnterElement.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterElement.setBounds(31, 226, 133, 50);
		contentPane.add(lblEnterElement);
		
		elementField = new JTextField();
		elementField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		elementField.setEditable(false);
		elementField.setColumns(10);
		elementField.setBounds(195, 233, 149, 44);
		contentPane.add(elementField);
		
		JButton btnAddSize = new JButton("Add size");
		btnAddSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				size = Integer.parseInt(sizeField.getText());
				if (size > 0) {
					stackArr = new int[size];
					outputField.setText("Stack created of size " + size + ".");
					elementField.setEditable(true);
					sizeField.setEditable(false);
				} else {
					outputField.setText("Please enter valid size.");
				}
			}
		});
		btnAddSize.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddSize.setBounds(441, 134, 133, 43);
		contentPane.add(btnAddSize);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sizeField.setText("");
				sizeField.setEditable(true);
				elementField.setText("");
				elementField.setEditable(false);
				outputField.setText("");
				stackArr = null;
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(441, 228, 133, 48);
		contentPane.add(btnReset);
		
		outputField = new JTextField();
		outputField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		outputField.setEditable(false);
		outputField.setColumns(10);
		outputField.setBounds(195, 325, 379, 50);
		contentPane.add(outputField);
		
		JButton btnPush = new JButton("Push");
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				element = Integer.parseInt(elementField.getText());
				top++;
				if (top > size - 1) {
					outputField.setText("Stack is full.");
					elementField.setText("");
					top--;
				} else {
					stackArr[top] = element;
					elementField.setText("");
					outputField.setText("Element " + element + " pushed into the stack.");
				}
			}
		});
		btnPush.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPush.setBounds(195, 417, 133, 50);
		contentPane.add(btnPush);
		
		JButton btnPop = new JButton("Pop");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (top == -1) {
					outputField.setText("Stack is empty.");
					stackArr = null;
				} else {
					top--;
					displayStack();
				}
			}
		});
		btnPop.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPop.setBounds(362, 417, 133, 50);
		contentPane.add(btnPop);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayStack();
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplay.setBounds(526, 417, 133, 50);
		contentPane.add(btnDisplay);
	}
}
