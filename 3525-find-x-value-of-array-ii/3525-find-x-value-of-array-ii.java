class Solution {
    int k;
    int[][] count;
    int[] product;
    public int[] resultArray(int[] nums, int k, int[][] queries) {
      this.k = k;

        int n = nums.length;

        count = new int[4 * n][k];
        product = new int[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // update nums[index]
            update(1, 0, n - 1, index, value);

            // get information from start to n-1
            int[] result = query(1, 0, n - 1, start, n - 1);

            ans[i] = result[x];
        }

        return ans;
    }

    void build(int node, int l, int r, int[] nums) {

        if (l == r) {

            product[node] = nums[l] % k;

            count[node][product[node]] = 1;

            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        merge(node, node * 2, node * 2 + 1);
    }

    void update(int node, int l, int r, int index, int value) {

        if (l == r) {

            for (int i = 0; i < k; i++) {
                count[node][i] = 0;
            }

            product[node] = value % k;

            count[node][product[node]] = 1;

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        merge(node, node * 2, node * 2 + 1);
    }

    void merge(int node, int left, int right) {

        product[node] =
            (product[left] * product[right]) % k;

        for (int i = 0; i < k; i++) {

            count[node][i] = count[left][i];

            for (int j = 0; j < k; j++) {

                int rem =
                    (product[left] * j) % k;

                if (rem == i) {
                    count[node][i] += count[right][j];
                }
            }
        }
    }

    int[] query(int node, int l, int r, int ql, int qr) {

        // completely inside range
        if (ql <= l && r <= qr) {

            return count[node].clone();
        }

        int mid = (l + r) / 2;

        // only left side
        if (qr <= mid) {

            return query(
                node * 2,
                l,
                mid,
                ql,
                qr
            );
        }

        // only right side
        if (ql > mid) {

            return query(
                node * 2 + 1,
                mid + 1,
                r,
                ql,
                qr
            );
        }

        // range crosses both sides
        int[] left =
            query(node * 2, l, mid, ql, qr);

        int[] right =
            query(node * 2 + 1, mid + 1, r, ql, qr);

        int[] result = new int[k];

        /*
         * We also need the product of the
         * left part.
         */
        int leftProduct = getProduct(
            node * 2,
            l,
            mid,
            ql,
            qr
        );

        for (int i = 0; i < k; i++) {

            result[i] += left[i];

            for (int j = 0; j < k; j++) {

                int rem =
                    (leftProduct * j) % k;

                if (rem == i) {
                    result[i] += right[j];
                }
            }
        }

        return result;
    }

    int getProduct(
        int node,
        int l,
        int r,
        int ql,
        int qr
    ) {

        if (ql <= l && r <= qr) {
            return product[node];
        }

        int mid = (l + r) / 2;

        if (qr <= mid) {
            return getProduct(
                node * 2,
                l,
                mid,
                ql,
                qr
            );
        }

        if (ql > mid) {
            return getProduct(
                node * 2 + 1,
                mid + 1,
                r,
                ql,
                qr
            );
        }

        int left =
            getProduct(
                node * 2,
                l,
                mid,
                ql,
                qr
            );

        int right =
            getProduct(
                node * 2 + 1,
                mid + 1,
                r,
                ql,
                qr
            );

        return (left * right) % k;  
    }
}