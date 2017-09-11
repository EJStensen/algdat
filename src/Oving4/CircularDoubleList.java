package Oving4;

public class CircularDoubleList {

	private Node start;
	private Node end;
	int size;
	
	public CircularDoubleList() {
		start = null;
		end = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return start == null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertAtStart(int value) {
		Node temp = new Node(value, null, null);
		if (start == null){
			temp.setNextNode(temp);
			temp.setPreviousNode(temp);
			start = temp;
			end = temp;
		} else {
			temp.setPreviousNode(end);
			end.setNextNode(temp);
			start.setPreviousNode(temp);
			temp.setNextNode(start);
			start = temp;
		}
		size++;
	}
	
	public void insertAtEnd(int value) {
		Node temp = new Node(value, null, null);
		if (start == null){
			temp.setNextNode(temp);
			temp.setPreviousNode(temp);
			start = temp;
			end = temp;
		} else {
			temp.setPreviousNode(end);
			end.setNextNode(temp);
			start.setPreviousNode(temp);
			temp.setNextNode(start);
			end = temp;
		}
		size++;
	}
	
	public void insertAtPosition(int value, int position){
		if (position > size || position < 0) throw new IndexOutOfBoundsException();
		Node a = new Node(value, null, null);
		if (position == 1) insertAtStart(value);
		if (position == size) insertAtEnd(value);
		Node b = start;
		for (int i = 2; i < size; i++){
			if (i == position){
				Node temp = b.getNextNode();
				b.setNextNode(a);
				a.setPreviousNode(b);
				a.setNextNode(temp);
				temp.setPreviousNode(a);
			}
			b = b.getNextNode();
		}
		size++;
	}
	
	public void removeNodeAtPosition(int position){
		if (position > size || position < 0) throw new IndexOutOfBoundsException();
		if (position == 1){
			if (size == 1){
				start = null;
				end = null;
				size = 0;
			}
			start = start.getNextNode();
			start.setPreviousNode(end);
			end.setNextNode(start);
			size--;
		}
		if (position == size){
			end = end.getPreviousNode();
			end.setNextNode(start);
			start.setPreviousNode(end);
			size--;
		}
		Node temp = start.getNextNode();
		for (int i = 2; i < size; i++){
			if (i == position){
				Node prev = temp.getPreviousNode();
				Node next = temp.getNextNode();
				prev.setNextNode(next);
				next.setPreviousNode(prev);
				size--;
			}
			temp = temp.getNextNode();
		}
	}
	
	public void execute(int interval){

	}
	
	public void displayList(){
		Node temp = start;
		if (size == 0) System.out.println("List is empty");
		if (start.getNextNode() == start) System.out.println(start.getElement()+" <-> "+temp.getElement());
		System.out.print(start.getElement()+" <-> ");
		temp = start.getNextNode();
		while(temp.getNextNode() != start){
			System.out.print(temp.getElement()+" <-> ");
			temp = temp.getNextNode();
		}
		System.out.print(temp.getElement()+" <-> ");
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
		System.out.print(temp.getElement());
	}
}