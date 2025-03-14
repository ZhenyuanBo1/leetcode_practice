class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];

        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            int dest = indices[i];
            arr[dest] = curr;
        }

        String newStr = "";

        for(int i=0; i<arr.length; i++){
            newStr += arr[i];
        }

        return newStr;
    }
}