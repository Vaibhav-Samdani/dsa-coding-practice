class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0) return ans;

        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String st = strs[i];
            String sortedSt = sortedString(st);
            if (mp.containsKey(sortedSt)) {
                ans.get(mp.get(sortedSt)).add(st);
            } else {
                ArrayList<String> group = new ArrayList<>();
                group.add(st);
                ans.add(group);
                mp.put(sortedSt, ans.size()-1);
            }
        }

        return ans;
    }

    String sortedString(String st) {
        char[] arr = st.toCharArray();

        Arrays.sort(arr);
        String sorted = new String(arr);
        return sorted;
    }
}
