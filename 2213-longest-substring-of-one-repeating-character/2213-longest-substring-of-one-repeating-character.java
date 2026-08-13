class Solution {
    private int[] maxLen;
    private int[] prefLen;
    private int[] suffLen;
    private char[] prefChar;
    private char[] suffChar;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;
        char[] arr = s.toCharArray();

        // 4 * n space for segment tree
        maxLen = new int[4 * n];
        prefLen = new int[4 * n];
        suffLen = new int[4 * n];
        prefChar = new char[4 * n];
        suffChar = new char[4 * n];

        build(1, 0, n - 1, arr);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            update(1, 0, n - 1, idx, ch);
            ans[i] = maxLen[1];
        }

        return ans;
    }

    private void merge(int node, int left, int right, int mid) {
        int lChild = 2 * node;
        int rChild = 2 * node + 1;
        int leftLen = mid - left + 1;
        int rightLen = right - mid;

        maxLen[node] = Math.max(maxLen[lChild], maxLen[rChild]);
        if (suffChar[lChild] == prefChar[rChild]) {
            maxLen[node] = Math.max(maxLen[node], suffLen[lChild] + prefLen[rChild]);
        }

        prefChar[node] = prefChar[lChild];
        prefLen[node] = prefLen[lChild];
        if (prefLen[lChild] == leftLen && prefChar[lChild] == prefChar[rChild]) {
            prefLen[node] += prefLen[rChild];
        }

        suffChar[node] = suffChar[rChild];
        suffLen[node] = suffLen[rChild];
        if (suffLen[rChild] == rightLen && suffChar[rChild] == suffChar[lChild]) {
            suffLen[node] += suffLen[lChild];
        }
    }

    private void build(int node, int left, int right, char[] arr) {
        if (left == right) {
            maxLen[node] = 1;
            prefLen[node] = 1;
            suffLen[node] = 1;
            prefChar[node] = arr[left];
            suffChar[node] = arr[left];
            return;
        }
        int mid = left + (right - left) / 2;
        build(2 * node, left, mid, arr);
        build(2 * node + 1, mid + 1, right, arr);
        merge(node, left, right, mid);
    }

    private void update(int node, int left, int right, int idx, char ch) {
        if (left == right) {
            prefChar[node] = ch;
            suffChar[node] = ch;
            return;
        }
        int mid = left + (right - left) / 2;
        if (idx <= mid) {
            update(2 * node, left, mid, idx, ch);
        } else {
            update(2 * node + 1, mid + 1, right, idx, ch);
        }
        merge(node, left, right, mid);
    }
}