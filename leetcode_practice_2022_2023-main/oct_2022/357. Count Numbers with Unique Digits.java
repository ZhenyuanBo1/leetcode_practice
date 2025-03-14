class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int limit = (int)Math.pow(10, n);
        boolean[] visited = new boolean[10];
        int[] digits = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8,9 };
        List<Integer> res = new ArrayList<>();
        helper(digits, limit, 0, res, visited);
        return res.size();
    }
    private void helper(int[] digits, int limit, int curr, List<Integer> res, boolean[] visited){
        if(curr < limit){
            res.add(curr);
        }else{
            return;
        }

        for(int i=0; i<digits.length; i++){
            //we only count value less than limit
            if(curr*10 + digits[i] < limit){
                if(curr == 0 && i == 0 || visited[i]) continue;
                visited[i] = true;
                helper(digits, limit, curr * 10 + digits[i], res, visited);
                visited[i] = false;
            }
        }
    }
}