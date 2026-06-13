class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String s = new String();
        for(String word : words){
            int sum = 0;
            for(char ch : word.toCharArray()){
                sum += weights[ch - 'a'];
            }

            sum %= 26;
            s = s + (char)(26 - sum + 'a' - 1);
        }

        return s;
    }
}