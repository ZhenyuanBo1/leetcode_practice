class Solution {
    public int calPoints(String[] ops) {
        List<Integer> nums = new ArrayList<>();

        for(int i=0; i<ops.length; i++){
            if(ops[i].equals("C")){
                nums.remove(nums.size()-1);
            }else if(ops[i].equals("D")){
                int prevVal = nums.get(nums.size()-1);
                int newVal = prevVal * 2;
                nums.add(newVal);
            }else if(ops[i].equals("+")){
                int sum = nums.get(nums.size()-1) + nums.get(nums.size()-2);
                nums.add(sum);
            }else{
                nums.add(Integer.parseInt(ops[i]));
            }
        }

        int ans = 0;

        for(int i=0; i<nums.size(); i++){
            ans += nums.get(i);
        }

        return ans;


    }
}