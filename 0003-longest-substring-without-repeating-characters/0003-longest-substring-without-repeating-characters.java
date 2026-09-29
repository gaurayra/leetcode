class Solution {
    public int lengthOfLongestSubstring(String s) {
       int m=0;
       for(int i=0; i<s.length();i++){
        String n="";
        for(int j=i ;j<s.length();j++){
            String o=""+s.charAt(j);
            if(n.contains(o)) break;
            n+=o;
        }if(m<n.length()) m=n.length();
       } return m;
    }
}