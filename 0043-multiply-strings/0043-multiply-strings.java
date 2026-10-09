class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int[] num3 = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1; i>=0; i--){
            for(int j=num2.length()-1; j>=0; j--){
                int a=num1.charAt(i)-'0';
                int b=num2.charAt(j)-'0';
                int product=a*b;
                int sum=product+num3[i+j+1];
                num3[i+j+1]=sum%10;
                num3[i+j]+=sum/10;      
            }
        } String result="";
        for(int x:num3){
            if(!(result.isEmpty() && x==0)) result+=x;
        } return result;
    }
}