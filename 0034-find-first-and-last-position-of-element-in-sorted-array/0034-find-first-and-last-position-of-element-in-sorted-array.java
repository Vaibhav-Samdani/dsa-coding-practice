class Solution {
    public int[] searchRange(int[] nums, int target) {
     int[] arr = { -1, -1 };
        arr[0] = firstSearch(nums, target);
        arr[1] = lastSearch(nums, target);
        return arr;
    }

    private static int firstSearch(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        int idx = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] >= target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }

    private static int lastSearch(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        int idx = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] <= target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }
}