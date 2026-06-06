class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int result = 0;

        int leftMax = 0;
        int rightMax = n-1;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] >= arr[leftMax]) {
                    leftMax = left;
                } else {

                    result += arr[leftMax] - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= arr[rightMax]) {
                    rightMax = right;
                } else {

                    result += arr[rightMax] - arr[right];
                }
                right--;
            }
        }

        return result;
    }
}