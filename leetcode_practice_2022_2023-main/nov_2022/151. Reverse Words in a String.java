class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        String[] arr = s.split(" ");

        String res = "";

        for(int i=arr.length-1; i>=0; i--){
            String curr = arr[i];
            if(curr.length() == 0) continue;
            res += curr + " ";
        }

        res = res.trim();

        return res;
    }
}