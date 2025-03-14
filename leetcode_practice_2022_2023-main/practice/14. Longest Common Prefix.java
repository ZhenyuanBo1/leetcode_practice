class Solution {
    public String longestCommonPrefix(String[] strs) {

        String ref = strs[0];

        String ans = "";

        for(int i=0; i<ref.length();i++){
            char target = ref.charAt(i);
            int count=0;
            for(int j = 1; j<strs.length; j++){
                String curr = strs[j];
                if(i<curr.length() && curr.charAt(i) == target){
                    count++;
                }
            }
            if(count < strs.length-1){
                break;
            }else{
                ans += target;
            }
        }

        return ans;
    }
}