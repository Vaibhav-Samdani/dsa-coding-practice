class Trie {
    boolean isEnd;
    Trie children[];
    char val;

    public Trie() {
        children = new Trie[26];
    }

    public void insert(String word) {
        Trie obj = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            obj.val = ch;
            if (obj.children[ch - 'a'] == null) {
                obj.children[ch - 'a'] = new Trie();
            }
            obj.children[ch - 'a'].val = ch;
            obj = obj.children[ch - 'a'];
        }
        obj.isEnd = true;
    }

    public boolean search(String word) {
        Trie obj = this;

        for(int i = 0; i<word.length();i++){
            char ch = word.charAt(i);
            if(obj.children[ch-'a'] == null) return false;

            obj = obj.children[ch-'a'];

            
        }
        return obj.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie obj = this;

        for(int i = 0; i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(obj.children[ch-'a'] == null) return false;

            obj = obj.children[ch-'a'];
        }

        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
