class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        for(int i=0; i<arr.length; i++){
            arr[i] = reverseStr(arr[i]);
        }

        String res = "";

        for(String item: arr){
            res += item + " ";
        }

        res = res.substring(0, res.length()-1);

        return res;
    }
    private String reverseStr(String curr){
        char[] arr = curr.toCharArray();

        int left = 0, right = arr.length-1;

        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}