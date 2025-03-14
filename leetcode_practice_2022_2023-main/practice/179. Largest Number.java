class Solution {
    public String largestNumber(int[] nums) {
        //using string concatenation to check which one is greater
        PriorityQueue<Integer> pq = new PriorityQueue<>((num1, num2)->{
            String numstr1 = num1 + "";
            String numstr2 = num2 + "";
            String order1 = numstr1 + numstr2;
            String order2 = numstr2 + numstr1;
            return order2.compareTo(order1);
        });

        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }

        String res = "";

        while(!pq.isEmpty()){
            res += pq.poll();
        }
        
        if(res.charAt(0) == '0') return "0";
        
        return res;
    }

}