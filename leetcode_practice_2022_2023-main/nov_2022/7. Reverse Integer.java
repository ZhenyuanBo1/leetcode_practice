class Solution {
    public int reverse(int x) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        boolean isPositive = x > 0;

        List<Integer> digits = new ArrayList<>();

        while(x!=0){
            int digit = x % 10;
            digits.add(digit);
            x = x/10;
        }

        int val = 0;

        int size = digits.size();

        int i=0;
        while(size > 0){
            int digit = digits.get(i);
            val += digit*Math.pow(10, size-1);
            if(!isPositive && val<=min) return 0;
            if(isPositive && val>=max) return 0;
            size-=1;
            i++;
        }
        
        return val;
    }
}