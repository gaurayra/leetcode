class Solution {
    public char findTheDifference(String s, String t) {
        int r=0;
        for(int i=0; i<t.length(); i++){
            r+=t.charAt(i);
        }
        for(int i=0; i<s.length(); i++){
            r-=s.charAt(i);
        }
        return (char)r;
    }
}