package Tree.Trie;


class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for( char ch : word.toCharArray() ){
            int index = ch - 'a';
            if( current.children[index] == null ){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search( root, word, 0 );
    }
    public boolean search( TrieNode root, String word, int pos ){
        TrieNode current = root;
        if( pos == word.length() ){
            return current.isEndOfWord;
        }
        char ch = word.charAt(pos);
        if( ch == '.' ){
            for( TrieNode child : current.children ){
                if( child != null && search( child, word, pos + 1)){
                    return true;
                }
            }
            return false;
        }
        int index = ch - 'a';
        if( current.children[index] == null ){
            return false;
        }
        return search( current.children[index], word, pos + 1);
    }
}
public class DesignAddAndSearch {
    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();

        dictionary.addWord("bad");
        dictionary.addWord("bat");
        dictionary.addWord("dog");

        System.out.println(dictionary.search("bad"));
        System.out.println(dictionary.search("b.."));
        System.out.println(dictionary.search("d.g"));
        System.out.println(dictionary.search(".."));
        System.out.println(dictionary.search("pad"));
    }
}
