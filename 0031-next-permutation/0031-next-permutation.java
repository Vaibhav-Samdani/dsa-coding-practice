class Solution {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = n - 2;

        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }

        if(pivot == -1){
            reverse(nums,pivot+1,n-1);
            return;
        }

        int j = n - 1;
        while (nums[j] <= nums[pivot]) {
            j--;
        }

        swap(nums, j, pivot);
        reverse(nums, pivot + 1, n - 1);
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
