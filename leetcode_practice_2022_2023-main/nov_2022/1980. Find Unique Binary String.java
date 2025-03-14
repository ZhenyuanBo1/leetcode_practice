class Solution {
    public String findDifferentBinaryString(String[] nums) {
        char[] binary = new char[]{'0', '1'};

        int len = nums[0].length();

        List<String> numsList = new ArrayList<>();

        for(String num: nums){
            numsList.add(num);
        }
        
        return backtrack(len, "", binary, numsList);

    }

    private String backtrack(int len, String curr, char[] binary, List<String> numsList){
        if(len == 0){
            if(!numsList.contains(curr)) return curr;
            return "";
        }
        
        for(int i=0; i<binary.length; i++){
            String ans = backtrack(len-1, curr + binary[i], binary, numsList);
            if(ans != "") return ans;
        }
        
        return "";
    }
}