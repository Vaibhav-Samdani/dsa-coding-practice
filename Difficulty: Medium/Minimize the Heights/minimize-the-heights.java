class Solution {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        int minVal = arr[0] + k;
        int maxVal = arr[n - 1] - k;
        int ans = arr[n - 1] - arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0)
                continue;

            minVal = Math.min(arr[i] - k, arr[0] + k);
            maxVal = Math.max(arr[i - 1] + k, arr[n - 1] - k);

            ans = Math.min(ans, maxVal - minVal);
        }

        return ans;
    }
}