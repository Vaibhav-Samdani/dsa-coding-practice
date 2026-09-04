class minHeap {
	ArrayList<Integer> arr;
	int size = 0;
	// Constructor
	public minHeap() {
		// Initialize your data members-
		arr = new ArrayList<>();
		arr.add(-1);
	}
	
	public void push(int x) {
		// Insert x into the heap
		arr.add(x);
		
		size++;
		
		int childIdx = size;
		int parentIdx = size/2;
		
		while (parentIdx > 0 && arr.get(parentIdx) > arr.get(childIdx)) {
			int temp = arr.get(parentIdx);
			arr.set(parentIdx, arr.get(childIdx));
			arr.set(childIdx, temp);
			
			childIdx = parentIdx;
			parentIdx = parentIdx/2;
		}
	}
	
	public void pop() {
		if (size == 0)
			return;
		
		int temp = arr.get(size);
		arr.set(size, arr.get(1));
		arr.set(1, temp);
		
		arr.remove(size);
		
		size--;
		
		int parentIdx = 1;
		while (true) {
			int left = parentIdx * 2;
			int right = parentIdx * 2 + 1;
			int smallest = parentIdx;
			
			if (left <= size && arr.get(left) < arr.get(smallest)) {
				smallest = left;
			}
			
			if (right <= size && arr.get(right) < arr.get(smallest)) {
				smallest = right;
			}
			
			if (parentIdx == smallest) {
				break;
			}
			
			temp = arr.get(parentIdx);
			arr.set(parentIdx, arr.get(smallest));
			arr.set(smallest, temp);
			
			
			parentIdx = smallest;
		}
		
	}
	
	public int peek() {
		// Return the top element or -1 if empty
		
		if(size == 0 ) return -1;
		
		return arr.get(1);
	}
	
	public int size() {
		// Return the number of elements in the heap
		return size;
	}
}
