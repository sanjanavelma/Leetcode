class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[10]; // Each node has 10 possible children (digits 0-9)
    }

    // Insert a number (as a string) into the Trie
    private void insert(TrieNode root, String numStr) {
        TrieNode node = root;
        for (char c : numStr.toCharArray()) {
            int idx = c - '0';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
    }

    // Find the longest common prefix between numStr and the Trie
    private int findLongestPrefix(TrieNode root, String numStr) {
        TrieNode node = root;
        int prefixLength = 0;
        for (char c : numStr.toCharArray()) {
            int idx = c - '0';
            if (node.children[idx] != null) {
                prefixLength++;
                node = node.children[idx];
            } else {
                break;
            }
        }
        return prefixLength;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // Step 1: Build Trie from arr1
        TrieNode root = new TrieNode();
        for (int num : arr1) {
            insert(root, String.valueOf(num));
        }

        // Step 2: Find the longest common prefix for each element in arr2
        int maxLength = 0;
        for (int num : arr2) {
            maxLength = Math.max(maxLength, findLongestPrefix(root, String.valueOf(num)));
        }

        return maxLength;
    }
}

