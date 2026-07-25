class TimeMap {

    class Pair {
        int time;
        String val;

        Pair(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }

    HashMap<String, ArrayList<Pair>> mp;

    public TimeMap() {
        mp = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (mp.get(key) == null) {
            mp.put(key, new ArrayList<>());
        }
        mp.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!mp.containsKey(key)) return "";
        ArrayList<Pair> arr = mp.get(key);
        int i = 0, j = arr.size() - 1;
        int ans = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            Pair data = arr.get(mid);
            if (data.time <= timestamp) {
                ans = mid;
                i = mid+1;
            } else {
                j = mid - 1;
            }
        }

        return ans != -1 ? arr.get(ans).val: "";
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
