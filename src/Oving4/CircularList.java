package Oving4;

public class CircularList{

	private Node head;
	int size;
	
	public CircularList(){
		head = null;
		size = 0;
	}

	public boolean isEmpty(){
		return head == null;
	}
	
	public int getSize(){
		return size;
	}
	
	public Node getHead(){
		return head;
	}
	
	public void insertAtHead(int value){
		head = new Node(value, head);
		size++;
	}
	
	public void insertAtTail(int value){
		if (head != null){
			Node temp = head;
			while (temp.getNextNode() != null) temp = temp.getNextNode();
		} else {
			head = new Node(value, null);
		}
		size++;
	}
	
	public void insertAtPosition(int value, int position){
		if (position < 0 || position > size) throw new IllegalArgumentException();
		if (head == null) insertAtHead(value);
		if (position == size) insertAtTail(value);
	}
	
	public void removeNode(Node n){
		if (head.getNextNode() == head){

		}
	}
	
	/*
	public void removeNodeAtPosition(int position){
		if (position < 0 || position > size) throw new IllegalArgumentException();
		if (size == 1 && position == 1){
			head = null;
			tail = null;
			size = 0;
		}
		if (position == 1){
			head = head.getNextNode();
			tail.setNextNode(head);
			size--;
		}
		if (position == size){
			Node a = head;
			Node b = head;
			while (a != tail){
				b = a;
				a = a.getNextNode();
			}
			tail = b;
			tail.setNextNode(head);
			size--;
		}
		Node temp = head;
		position = position - 1;
		for (int i = 1; i < size; i++){
			if (i == position){
				Node n = temp.getNextNode();
				n = n.getNextNode();
				temp.setNextNode(n);
				break;
			}
			temp = temp.getNextNode();
		}
		size--;
	}
	*/

	public void execute(int interval){
		Node temp = head;
		int data;
		displayList();
		System.out.println("\n");
		//displayJosephus();
		 
	}
	
	public void displayList(){
		Node temp = head;
		if (size == 0) System.out.println("List is empty");
		if (head.getNextNode() == head) System.out.println(head.getElement()+" -> "+temp.getElement());
		System.out.print(head.getElement()+" -> ");
		temp = head.getNextNode();
		while(temp.getNextNode() != head){
			System.out.print(temp.getElement()+" -> ");
			temp = temp.getNextNode();
		}
		System.out.print(temp.getElement()+" -> ");
		temp = temp.getNextNode();
		System.out.print(temp.getElement()+"\n");
	}
	/*
	public void displayJosephus(){
		Node temp = head;
		if (size == 0) System.out.println("List is empty");
		if (head.getNextNode() == head) System.out.println(head.getElement()+" -> "+temp.getElement());
		System.out.print(head.getElement()+" ");
		temp = head.getNextNode();
		while(temp.getNextNode() != head){
			System.out.print(temp.getElement()+" ");
			temp = temp.getNextNode();
		}
		System.out.print(temp.getElement());
	}
	*/
}
