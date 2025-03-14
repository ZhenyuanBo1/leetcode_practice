class Solution {
    public String defangIPaddr(String address) {
        String[] arr = address.split("\\.");

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<arr.length; i++){
            if(i != arr.length-1){
                sb.append(arr[i]).append("[.]");
            }else{
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}