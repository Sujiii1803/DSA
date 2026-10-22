
package Tree.Trie;

import java.util.ArrayList;
import java.util.List;

class WordSearch2Solution {

    private class WordSearchTrieNode {
        WordSearchTrieNode[] children = new WordSearchTrieNode[26];
        String word;
    }

    private WordSearchTrieNode root;
    private List<String> result;
    private int rows;
    private int cols;

    public List<String> findWords(char[][] board, String[] words) {
        root = new WordSearchTrieNode();
        result = new ArrayList<>();

        if (board == null || board.length == 0 || board[0].length == 0) {
            return result;
        }

        rows = board.length;
        cols = board[0].length;

        for (String word : words) {
            insert(word);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root);
            }
        }

        return result;
    }

    private void insert(String word) {
        WordSearchTrieNode current = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (current.children[idx] == null) {
                current.children[idx] = new WordSearchTrieNode();
            }

            current = current.children[idx];
        }

        current.word = word;
    }

    private void dfs(char[][] board, int r, int c,
                     WordSearchTrieNode parent) {

        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return;
        }

        char ch = board[r][c];

        if (ch == '#') {
            return;
        }

        int idx = ch - 'a';

        if (parent.children[idx] == null) {
            return;
        }

        WordSearchTrieNode node = parent.children[idx];

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, node);
        dfs(board, r - 1, c, node);
        dfs(board, r, c + 1, node);
        dfs(board, r, c - 1, node);

        board[r][c] = ch;
    }
}

public class WordSearch2 {
    public static void main(String[] args) {

        WordSearch2Solution solution = new WordSearch2Solution();

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {
                "oath", "pea", "eat", "rain"
        };

        List<String> result = solution.findWords(board, words);

        System.out.println("Words found: " + result);
    }
}
