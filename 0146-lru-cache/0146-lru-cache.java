class LRUCache {
    Map<Integer, Integer> mp;
    int capacity;

    public LRUCache(int capacity) {
        mp = new LinkedHashMap<>(16, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return mp.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        mp.put(key, value);
        if (mp.size() > capacity) {
            int firstVal = mp.keySet().iterator().next();
            mp.remove(firstVal);
        }

    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
