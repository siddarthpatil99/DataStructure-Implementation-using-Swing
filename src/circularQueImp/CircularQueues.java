package circularQueImp;

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

public class CircularQueues extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sizeField;
	private JTextField elementField;
	private JTextField outputField;
	private int[] cirQueArr;
	private int size;
	private int front = -1;
	private int rear = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircularQueues frame = new CircularQueues();
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
	public CircularQueues() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 226, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Circular Queue Implementation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(258, 38, 395, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter size");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(93, 133, 113, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter element");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(93, 207, 143, 40);
		contentPane.add(lblNewLabel_1_1);
		
		sizeField = new JTextField();
		sizeField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sizeField.setBounds(291, 133, 143, 40);
		contentPane.add(sizeField);
		sizeField.setColumns(10);
		
		elementField = new JTextField();
		elementField.setEditable(false);
		elementField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		elementField.setColumns(10);
		elementField.setBounds(291, 207, 143, 40);
		contentPane.add(elementField);
		
		JButton btnAddSize = new JButton("Add size");
		btnAddSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				size = Integer.parseInt(sizeField.getText());
				cirQueArr = new int[size];
				outputField.setText("Circular queue of size " + size + " is created.");
				sizeField.setEditable(false);
				elementField.setEditable(true);
			}
		});
		btnAddSize.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddSize.setBounds(537, 133, 116, 40);
		contentPane.add(btnAddSize);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sizeField.setText("");
				sizeField.setEditable(true);
				elementField.setText("");
				elementField.setEditable(false);
				outputField.setText("");
				cirQueArr = null;
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(537, 207, 116, 40);
		contentPane.add(btnReset);
		
		outputField = new JTextField();
		outputField.setEditable(false);
		outputField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		outputField.setColumns(10);
		outputField.setBounds(291, 281, 332, 40);
		contentPane.add(outputField);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int element = Integer.parseInt(elementField.getText());
				insert(element);
				elementField.setText("");
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsert.setBounds(291, 352, 116, 40);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(438, 352, 116, 40);
		contentPane.add(btnDelete);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display();
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplay.setBounds(586, 352, 116, 40);
		contentPane.add(btnDisplay);
		
	}
	
	public void insert(int element) {
        if ((rear + 1) % size == front) {
            outputField.setText("Circular Queue is full.");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size; 
            cirQueArr[rear] = element;
            outputField.setText("Element " + element + " inserted into the Circular Queue.");
        }
    }
	
	public void delete() {
        if (front == -1) {
            outputField.setText("Circular Queue is empty.");
        } else {
        	outputField.setText("Element " + cirQueArr[front] + " got deleted");
            cirQueArr[front] = 0; 
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size; 
            }
        }
    }
	
	public void display() {
        if (front == -1) {
        	outputField.setText("Circular Queue is empty.");
        } else {
        	String str = "";
			int i = front;
			while (i != rear) {
				str += cirQueArr[i] + " ";
				i = (i + 1) % size;
			}
			str += cirQueArr[rear];
			outputField.setText(str);
        }
    }

}
