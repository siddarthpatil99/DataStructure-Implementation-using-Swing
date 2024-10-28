package linkedlistImp;

public class LinkedListStructure {
	class Node {
		private Node prevNode;
		private Node nextNode;
		private int data;
	}
	
	Node head = null;
	
	public void insertFirst(int element) {
		Node newNode = new Node();
		newNode.prevNode = null;
		newNode.data = element;
		newNode.nextNode = null;
		if (head == null) {
			head = newNode;
		} else {
			newNode.nextNode = head;
			head = newNode;
		}
	}
	
	public void insertLast(int element) {
		Node newNode = new Node();
		newNode.prevNode = null;
		newNode.data = element;
		newNode.nextNode = null;
		if (head == null) {
			head = newNode;
		} else if (head.nextNode == null) {
			newNode.prevNode = head;
			head.nextNode = newNode;
		} else {
			Node temp = head;
			while (temp.nextNode != null) {
				temp = temp.nextNode;
			}
			temp.nextNode = newNode;
			newNode.prevNode = temp;
		}
	}
	
	public String deleteFirst() {
		String str = "";
		if (head == null) {
			str = "List is empty.";
		} else if (head.nextNode == null) {
			head = null;
			str = "Element deleted from first.";
		} else {
			head = head.nextNode;
			head.prevNode = null;
			str = "Element deleted from first.";
		}
		return str;
	}
	
	public String deleteLast() {
		String str = "";
		if (head == null) {
			str = "List is empty.";
		} else if (head.nextNode == null) {
			head = null;
			str = "Element deleted from last.";
		} else {
			Node temp = head;
			while (temp.nextNode.nextNode != null) {
				temp = temp.nextNode;
			}
			temp.nextNode = null;
			str = "Element deleted from last.";
		}
		return str;
	}
	
	public String display() {
		Node temp = head;
		String str = "";
		while (temp != null) {
//			outputField.setText(temp.data + " ");
//			System.out.println(temp.data + " ");
			str += temp.data + " ";
			temp = temp.nextNode;
		}
		
		if (str == "") {
			return "List is empty.";
		}
		return str;
	}
}
