
public class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord=false;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int i= c-'a';
            if(cur.children[i] == null){ cur.children[i] = new TrieNode(); }
            cur = cur.children[i];
        }
        cur.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int i = c-'a';
            if(cur.children[i] == null){ return false; }
            cur = cur.children[i];
        }
        return cur.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            int i = c-'a';
            if(cur.children[i] == null){ return false;}
            cur = cur.children[i];
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