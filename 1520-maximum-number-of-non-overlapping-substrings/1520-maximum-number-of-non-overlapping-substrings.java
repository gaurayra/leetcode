class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1)  first[c] = i;
            last[c] = i;
        }
        List<String> ans = new ArrayList<>();
        int prevEnd = -1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] != i) continue;
            int end = last[c];
            boolean valid = true;
            for (int j = i; j <= end; j++) {
                int x = s.charAt(j) - 'a';
                if (first[x] < i) {
                    valid = false;
                    break;
                } end = Math.max(end, last[x]);
            } if (!valid) continue;
            if (i > prevEnd) {
                ans.add(s.substring(i, end + 1));
                prevEnd = end;
            } else {
                ans.set(ans.size() - 1, s.substring(i, end + 1));
                prevEnd = end;
            }
        } return ans;
    }
}