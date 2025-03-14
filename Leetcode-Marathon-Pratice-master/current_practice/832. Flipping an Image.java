class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] ans = new int[image.length][image[0].length];
        for(int i=0; i<image.length; i++){
            int k=0;
            for(int j=image[i].length-1; j>=0; j--){
                ans[i][k] = image[i][j];
                k++;
            }
            for(int l=0; l<ans[i].length; l++){
                if(ans[i][l]==0){
                    ans[i][l] = 1;
                }else{
                    ans[i][l] = 0;
                }
            }
        }
        return ans;
    }
}