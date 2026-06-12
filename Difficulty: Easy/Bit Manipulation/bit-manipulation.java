// User function Template for Java

class Solution {
    static void bitManipulation(int num, int i) {
        // code here
        int pos = 1<<(i-1);
        
        int get = num & (pos);
        
        get = get >> (i-1);
        
        int set = num | pos;
        
        
        int clear = num & (~pos);
        
        System.out.print(get + " " + set + " " + clear);
    }
}
