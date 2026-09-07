class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result= new ArrayList<Integer>();
        for(int i=left; i<=right;i++){
            int temp=i;
            boolean is_self=true;
            while(temp>0){
                int digit=temp%10;
                if(digit==0 || i%digit!=0) {is_self=false;
                break;} 
                temp=temp/10;
            }if(is_self) result.add(i);
        } return result;
    }
}