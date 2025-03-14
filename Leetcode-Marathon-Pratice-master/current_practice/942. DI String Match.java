class Solution {
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length()+1];

        int left = 0, right=res.length-1;

        int j=0;
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(curr == 'I'){
                res[j] = left;
                res[j+1] = right;
                left++;
                j+=1;
            }else if(curr == 'D'){
                res[j] = right;
                res[j+1] = left;
                right--;
                j+=1;
            }
        }

        return res;
    }
}