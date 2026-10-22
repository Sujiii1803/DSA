package Tree.Trie;


import java.util.HashMap;
import java.util.Map;

class MapSum {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int sum;
    }

    private final TrieNode root = new TrieNode();
    private final Map<String, Integer> values = new HashMap<>();

    public MapSum() {
    }

    public void insert(String key, int val) {
        int oldValue = values.getOrDefault(key, 0);
        int difference = val - oldValue;

        values.put(key, val);

        TrieNode current = root;

        for (char ch : key.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
            current.sum += difference;
        }
    }

    public int sum(String prefix) {
        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                return 0;
            }

            current = current.children[index];
        }

        return current.sum;
    }
}

public class  MapSumPairs{
    public static void main(String[] args) {

        MapSum obj = new MapSum();

        obj.insert("apple", 3);
        System.out.println(obj.sum("ap"));  // 3

        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));  // 5

        obj.insert("apple", 5);
        System.out.println(obj.sum("ap"));  // 7

        System.out.println(obj.sum("app")); // 7
        System.out.println(obj.sum("bat")); // 0
    }
}

