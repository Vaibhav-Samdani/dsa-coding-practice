class Solution {
    public double findMedian(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        
        return n % 2 == 1? arr[n/2]: (arr[n/2] + arr[(n/2)-1])/2.0;
    }
}
