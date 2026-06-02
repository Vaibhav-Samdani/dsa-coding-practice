class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    int[] mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return new int[] { nums[start] };
        }
        int mid = start + (end - start) / 2;

        int[] left = mergeSort(nums, start, mid);
        int[] right = mergeSort(nums, mid + 1, end);

        return merge(left, right);
    }

    int[] merge(int[] left, int[] right) {
        int n1 = left.length;
        int n2 = right.length;
        int i = 0;
        int j = 0;
        int k =0;
        int[] ans = new int[n1 + n2];

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                ans[k] = left[i];
                i++;
                k++;
            } else {
                ans[k] = right[j];
                j++;
                k++;

            }
        }

        while (i < n1) {
            ans[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            ans[k] = right[j];
            j++;
            k++;
        }

        return ans;
    }
}