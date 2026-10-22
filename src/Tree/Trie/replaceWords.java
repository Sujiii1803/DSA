
package Tree.Trie;

import java.util.*;


class Solution {
    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String word : dictionary) {
            insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }

            result.append(replaceWord(word));
        }

        return result.toString();
    }

    private void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    public String replaceWord(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (current.children[index] == null) {
                return word;
            }

            current = current.children[index];

            if (current.isEndOfWord) {
                return word.substring(0, i + 1);
            }
        }

        return word;
    }
}

public class replaceWords {
    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> dictionary = Arrays.asList(
                "cat", "bat", "rat"
        );

        String sentence = "the cattle was rattled by the battery";

        String result = solution.replaceWords(dictionary, sentence);

        System.out.println("Output: " + result);
    }
}
