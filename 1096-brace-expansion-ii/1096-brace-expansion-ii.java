class Solution {
    private int pos;
    private String s;
    public List<String> braceExpansionII(String expression) {
      this.s = expression;
      this.pos = 0;
      Set<String> result = parseExpr();
      List<String> ans = new ArrayList<>(result);
      Collections.sort(ans);
      return ans;   
    }
    private Set<String> parseExpr() {
        Set<String> result = new HashSet<>(parseTerm());
        while (pos < s.length() && s.charAt(pos) == ',') {
            pos++; // skip ','
            result.addAll(parseTerm());
        } return result;
    }
    private Set<String> parseTerm() {
        List<Set<String>> factors = new ArrayList<>();
        while (pos < s.length() && s.charAt(pos) != ',' && s.charAt(pos) != '}') {
            factors.add(parseFactor());
        }
         Set<String> result = new HashSet<>();
        result.add("");
        for (Set<String> factor : factors) {
            Set<String> newResult = new HashSet<>();
            for (String prefix : result) {
                for (String suffix : factor) {
                    newResult.add(prefix + suffix);
                }
            } result = newResult;
        } return result;
    }
    private Set<String> parseFactor() {
        if (s.charAt(pos) == '{') {
            pos++; // skip '{'
            Set<String> result = parseExpr();
            pos++; // skip '}'
            return result;
        } else {
            Set<String> result = new HashSet<>();
            result.add(String.valueOf(s.charAt(pos)));
            pos++;
            return result;
        }
    }
}