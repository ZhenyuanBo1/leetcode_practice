class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int[] arr = new int[101];
        for(int i=0; i<arrays.length; i++){
            for(int j=0; j<arrays[i].length; j++){
                arr[arrays[i][j]]++;
            }
        }

        List<Integer> res = new ArrayList<>();

        int len = arrays.length;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == len){
                res.add(i);
            }
        }

        return res;
    }
}