class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;

        List<Integer> list = new ArrayList<>();

        while(x!=0){
            int rem = x%10;
            list.add(0, rem);
            x = x/10;
        }

        int left = 0, right =list.size()-1;

        while(left < right){
            if(list.get(left) != list.get(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }

        return true;
    }
}