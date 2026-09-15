class Solution {
	public int countOccurence(int[] arr, int k) {
	    
	    int count = 0;
	    
	    int x = arr.length/k;
	    
	    Map<Integer, Integer> mp = new HashMap<>();
	    
	    
	    for(int i = 0; i<arr.length;i++){
	        mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
	    }
	    
	    for(Map.Entry<Integer,Integer> st : mp.entrySet()){
	        if(st.getValue() > x){
	            count++;
	        }
	    }
		
		return count;
	}
}
