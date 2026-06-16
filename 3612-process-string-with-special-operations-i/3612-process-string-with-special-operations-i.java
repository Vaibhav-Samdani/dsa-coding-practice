class Solution {
    public String processStr(String s) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '#'){
                if(ans.length() != 0) ans.append(ans);
            }else if(ch == '*'){
                if(ans.length() != 0) ans.delete(ans.length()-1,ans.length());
            }else if(ch == '%'){
                if(ans.length() != 0) ans.reverse();
            }else{
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}