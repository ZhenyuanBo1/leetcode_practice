class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for(int i=1; i<=9; i++){
            helper(i, res, n-1, k);
        }

        int[] ans = new int[res.size()];

        for(int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;

    }

    private void helper(int num, List<Integer> res, int numDigits, int k){
        if(numDigits == 0){
            res.add(num);
            return;
        }

        int digit = num % 10;
        if(digit - k >= 0){
            helper(num*10 + digit, res, numDigits-1, k);
        }

        if(digit + k <= 9 && digit-k != digit + k){
            helper(num*10+(digit+k), res, numDigits-1, k);
        }
    }
}