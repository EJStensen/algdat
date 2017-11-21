package Oving13boka;

public class Heap {
	int len;
	int node[];
	
	public Heap(int lenght) {
		node = new int[lenght];
		len = 0;
	}
	
	private int over(int i) { return (i - 1) >> 1;}
	private int left(int i) { return (i << 1) + 1;}
	private int right(int i) { return (i + 1) << 1;}
	
	
	/**
	 * Small fix to make the heap min-priority instead of max
	 * 
	 * @param index
	 */
	public void fix_heap(int index) {
		int m = left(index);
		if (m  < len) {
			int h = m + 1;
			if (h < len && node[h] > node[m]) m = h;
			if (node[m] > node[index]) {
				changePosition(node, index, m);
				fix_heap(m);
			}
		}
	}
	
	public void heapsort() {
		make_heap();
		int l = len;
		while (len > 1) {
			int m = get_min();
			node[len] = m;
		}
		len = l;
	}
	
	public int get_min() {
		int max = node[0];
		node[0] = node[--len];
		fix_heap(0);
		return max;
	}
	
	public void make_heap() {
		int i = len / 2;
		while (i-->0) fix_heap(i);
	}
	
	public void priority_down(int i, int p) {
		node[i] -= p;
		fix_heap(i);
	}
	
	public void priority_up(int i, int p) {
		int f;
		node[i] += p;
		while (i > 0 && node[i] > node[f=over(i)]) {
			changePosition(node, i, f);
			i = f;
		}
	}
	
	public void set_in(int a) {
		int i = len++;
		node[i] = a;
		priority_up(i, 0);
	}
	
	private void changePosition(int[] t, int i, int j) {
		int k = t[j];
		t[j] = t[i];
		t[i] = k;
	}
}
