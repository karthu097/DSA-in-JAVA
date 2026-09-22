class Solution {
    private static class Node {
        int[] remain = new int[5];
        int prod = 1;
    }

    private int n, k;
    private Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        this.tree = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            tree[i] = new Node();
        }

        // Reduce initial nums modulo k
        for (int i = 0; i < n; i++) {
            nums[i] %= k;
        }

        build(nums, 0, 0, n - 1);

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int idx = queries[i][0];
            int val = queries[i][1] % k;
            int start = queries[i][2];
            int x = queries[i][3];

            update(0, 0, n - 1, idx, val);
            Node res = query(0, 0, n - 1, start, n - 1);
            ans[i] = res.remain[x];
        }

        return ans;
    }

    private Node merge(Node left, Node right) {
        Node node = new Node();
        node.prod = (left.prod * right.prod) % k;
        for (int i = 0; i < k; ++i) {
            node.remain[i] = left.remain[i];
        }
        for (int i = 0; i < k; ++i) {
            node.remain[(i * left.prod) % k] += right.remain[i];
        }
        return node;
    }

    private void build(int[] nums, int cur, int left, int right) {
        if (left == right) {
            tree[cur].remain[nums[left]] = 1;
            tree[cur].prod = nums[left];
            return;
        }
        int mid = (left + right) / 2;
        build(nums, 2 * cur + 1, left, mid);
        build(nums, 2 * cur + 2, mid + 1, right);
        tree[cur] = merge(tree[2 * cur + 1], tree[2 * cur + 2]);
    }

    private void update(int treeIndex, int lo, int hi, int i, int val) {
        if (lo == hi) {
            for (int j = 0; j < k; ++j) {
                tree[treeIndex].remain[j] = 0;
            }
            tree[treeIndex].remain[val] = 1;
            tree[treeIndex].prod = val;
            return;
        }
        int mid = (lo + hi) / 2;
        if (i <= mid) {
            update(2 * treeIndex + 1, lo, mid, i, val);
        } else {
            update(2 * treeIndex + 2, mid + 1, hi, i, val);
        }
        tree[treeIndex] = merge(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    private Node query(int treeIndex, int lo, int hi, int i, int j) {
        if (i <= lo && hi <= j) {
            return tree[treeIndex];
        }
        int mid = (lo + hi) / 2;
        if (j <= mid) {
            return query(2 * treeIndex + 1, lo, mid, i, j);
        } else if (i > mid) {
            return query(2 * treeIndex + 2, mid + 1, hi, i, j);
        } else {
            return merge(query(2 * treeIndex + 1, lo, mid, i, mid),
                         query(2 * treeIndex + 2, mid + 1, hi, mid + 1, j));
        }
    } //
}