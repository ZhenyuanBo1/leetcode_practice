class Solution {
    public String reverseWords(String s) {
        String modifiedS = s.trim();

        String[] arr = modifiedS.split(" ");
        System.out.println(arr.length);

        String res = "";

        for(int i=arr.length-1; i>=0; i--){
            while(arr[i].equals("")) i--;
            res += arr[i].trim() + " ";
        }

        return res.trim();

    }
}