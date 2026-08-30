class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        for(int i=0; i<s.length(); i++){
            String sub="";
            for(int j=i; j<s.length(); j++){
                String ch=""+s.charAt(j);
                if(sub.contains(ch)) break;
                sub+=ch;
            }if(sub.length()>max) max=sub.length();
        } return max;
    } 
}