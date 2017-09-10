package Oving4;

public class CircularList{

	private Node start;
	private Node end;
	int size;
	
	public CircularList(){
		start = null;
		end = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return start == null;
	}
	
	public int getSize(){
		return size;
	}
	
	public void insertAtStart(double value){
		Node temp = new Node(value, null);
		temp.setNextNode(start);
		if (start == null){
			start = temp;
			temp.setNextNode(temp);
			end = temp;
		} else {
			end.setNextNode(temp);
			start = temp;
		}
		size++;
	}
	
	public void insertAtEnd(double value){
		Node temp = new Node(value, null);
		temp.setNextNode(start);
		if (start == null){
			start = temp;
			temp.setNextNode(start);
			end = start;
		} else {
			end.setNextNode(temp);
			end = temp;
		}
		size++;
	}
	
	public void insertAtPosition(double value, int position){
		if (position < 0 || position > size) throw new IllegalArgumentException();
		if (start == null) insertAtStart(value);
		Node nexttemp = new Node(value, null);
		Node prevtemp = start;
		//position = position - 1;
		for (int i = 1; i < size; i++){
			if (i == position){
				Node temp = prevtemp.getNextNode();
				prevtemp.setNextNode(nexttemp);
				nexttemp.setNextNode(temp);
				break;
			}
			prevtemp = prevtemp.getNextNode();
		}
		size++;
	}
	
	public void removeNodeAtPosition(int position){
		if (position < 0 || position > size) throw new IllegalArgumentException();
		if (size == 1 && position == 1){
			start = null;
			end = null;
			size = 0;
		}
		if (position == 1){
			start = start.getNextNode();
			end.setNextNode(start);
			size--;
		}
		if (position == size){
			Node a = start;
			Node b = start;
			while (a != end){
				b = a;
				a = a.getNextNode();
			}
			end = b;
			end.setNextNode(start);
			size--;
		}
		Node temp = start;
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
	
	public void displayList(){
		Node temp = start;
		if (size == 0) System.out.println("List is empty");
		if (start.getNextNode() == start) System.out.println(start.getElement()+" -> "+temp.getElement());
		System.out.print(start.getElement()+" -> ");
		temp = start.getNextNode();
		while(temp.getNextNode() != start){
			System.out.print(temp.getElement()+" -> ");
			temp = temp.getNextNode();
		}
		System.out.print(temp.getElement()+" -> ");
		temp = temp.getNextNode();
		System.out.print(temp.getElement()+"\n");
	}
	
	public void displayJosephus(){
		Node temp = start;
		if (size == 0) System.out.println("List is empty");
		if (start.getNextNode() == start) System.out.println(start.getElement()+" -> "+temp.getElement());
		System.out.print(start.getElement()+" ");
		temp = start.getNextNode();
		while(temp.getNextNode() != start){
			System.out.print(temp.getElement()+" ");
			temp = temp.getNextNode();
		}
	}
}
