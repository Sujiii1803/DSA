package Tree.Trie;


class Trie {

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for( int i = 0; i < word.length(); i++ ){
            char ch = word.charAt(i);
            int index = ch - 'a';

            if( current.children[index] == null ){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for( char ch : word.toCharArray() ){
            int index = ch - 'a';
            if( current.children[index] == null ){
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for( char ch : prefix.toCharArray() ){
            int index = ch - 'a';
            if( current.children[index] == null ){
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
}
public class Implementation {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("cat");
        trie.insert("car");

        System.out.println(trie.search("cat"));
        System.out.println(trie.search("ca"));
        System.out.println(trie.startsWith("ca"));
        System.out.println(trie.startsWith("cb"));
    }

}
