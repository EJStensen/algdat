package Oving8;

public class Heap {
	private int length;
	private int maxsize;
	private Node node[];
	
	/*
	int over(int position) {
		return (position - 1) >> 1;
	}
	
	int left(int position) {
		return (position << 1) + 1;
	}
	
	int right(int position) {
		return (position + 1) << 1;
	}
	*/
	
	public Heap(Node[] n) {
		node = n;
		maxsize = n.length;
		length = 0;
	}
	
	public void insert()
	/*
	public void fix_heap(int position) {
		int m = left(position);
		if (m < length){
			int h = m + 1;
			if (h < length && node[h] > node[m]) m = h;
			if (node[m] > node[position]){
				swap(position, m);
				fix_heap(m);
			}
		}
	}
	
	private void swap(int i, int j){
		Object temp = node[i];
		node[i] = node[j];
		node[j] = (int) temp;
	}
	
	public void make_heap(){
		int i = length / 2;
		while (i --> 0) fix_heap(i);
	}
	
	public int get_max(){
		int max = node[0];
		node[0] = node[--length];
		fix_heap(0);
		return max;
	}
	
	public void priority_up(int position, int value){
		int parentnode;
		node[position] += value;
		while (position > 0 && node[position] > node[parentnode=over(position)]){
			swap(position, parentnode);
			position = parentnode;
		}
	}
	
	public void set_in(int newnode){
		int i = length++;
		node[i] = newnode;
		priority_up(i, 0);
	}
	
	public void heapsort(){
		make_heap();
		int l = length;
		while(length > 1){
			int x = get_max();
			node[length] = x;
		}
		length = l;
	}
	*/
}
