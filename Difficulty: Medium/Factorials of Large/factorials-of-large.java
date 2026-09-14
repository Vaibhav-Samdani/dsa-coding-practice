class Solution {
    public ArrayList<Integer> factorial(int n) {
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        
        for(int i = 1; i <= n;i++){
            int carry = 0;
            
            for(int j = 0; j < res.size(); j++){
                int val = res.get(j) * i + carry;
                
                carry = val / 10;
                res.set(j,val%10);
            }
            
            while(carry > 0){
                res.add(carry % 10);
                carry /= 10;
            }
            
        }
        
        Collections.reverse(res);
        
        return res;
        
    }
}