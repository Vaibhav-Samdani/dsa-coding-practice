class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        Set<Integer> st = new TreeSet<>();

        
        for(int i = 0;i<a.length;i++){
            st.add(a[i]);
        }
        for(int i = 0;i<b.length;i++){
            st.add(b[i]);
        }
        
        for(int val : st){
            ans.add(val);
        }
        
        return ans;
    }
}