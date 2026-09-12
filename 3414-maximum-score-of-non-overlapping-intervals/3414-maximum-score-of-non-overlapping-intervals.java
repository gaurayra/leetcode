class Solution {
    static class State {
        long score;
        List<Integer> list;
        State(long score, List<Integer> list) {
            this.score = score;
            this.list = list;
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] a = new int[n][4];
        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }
        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));
        State[][] dp = new State[n + 1][5];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new State(0, new ArrayList<>());
        }
        for (int k = 1; k <= 4; k++) {
            dp[n][k] = new State(0, new ArrayList<>());
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {
                State skip = dp[i + 1][k];
                int next = findNext(a, i);
                State after = dp[next][k - 1];
                List<Integer> takeList =new ArrayList<>(after.list);
                takeList.add(a[i][3]);
                Collections.sort(takeList);
                long takeScore =a[i][2] + after.score;
                State take =new State(takeScore, takeList);
                if (take.score > skip.score) dp[i][k] = take;
                else if (take.score < skip.score) dp[i][k] = skip;
                else dp[i][k] = smaller(take, skip);
            }
        }
        List<Integer> answer = dp[0][4].list;
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    private int findNext(int[][] a, int i) {
        int left = i + 1;
        int right = a.length;
        int end = a[i][1];
        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid][0] > end) right = mid;
            else left = mid + 1;
        } return left;
    }
    private State smaller(State a, State b) {
        for (int i = 0; i < a.list.size(); i++) {
            if (!a.list.get(i).equals(b.list.get(i))) {
                if (a.list.get(i) < b.list.get(i))  return a;
                else return b;
            }
        } return a;
    }
}