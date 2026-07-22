class Solution {

    public String encode(String arr[]) {
        // write your logic to encode the strings
        StringBuilder ans = new StringBuilder();
        
        for(String st : arr){
            int len = st.length();
            ans.append(len);
            ans.append("/:");
            ans.append(st);
        }
        
        return ans.toString();
        
    }

    public ArrayList<String> decode(String s) {
        ArrayList<String> ans = new ArrayList<>();
        int i = 0;
        
        while(i < s.length()){
            int len = 0;
            StringBuilder st = new StringBuilder();
            while(!(s.charAt(i) == '/' && s.charAt(i+1) == ':')){
                len = len * 10 + (s.charAt(i) - '0');
                i++;
            }
            
            i += 2;
            
            int j = i;
            
            for(;i < j+len;i++){
                st.append(s.charAt(i));
            }
            ans.add(st.toString());
    
        }
        
        return ans;
        
    }
}