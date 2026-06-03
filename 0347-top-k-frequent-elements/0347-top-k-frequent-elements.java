class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Method 1 : HashMap + Sorting;

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int el : nums) {
            mp.put(el, mp.getOrDefault(el, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(mp.keySet());

        Collections.sort(list, (a, b) -> mp.get(b) - mp.get(a));

        int arr[] = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}