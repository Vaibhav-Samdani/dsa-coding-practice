class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = arr.length -1 ; i >= 0; i--){
            
            while(!st.isEmpty() && arr[i] >= st.peek()){
                st.pop();
            }
            
            
            if(!st.isEmpty() && arr[i] <= st.peek()){
                list.add(0,st.peek());
            }else{
                list.add(0,-1);
            }
            
            
            st.push(arr[i]);
        }
        
        return list;
    }
}