class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0; i<image.length; i++){
            int[] currRow = image[i];
            int left = 0, right = currRow.length-1;
            while(left < right){
                int temp = currRow[left];
                currRow[left] = currRow[right];
                currRow[right] = temp;
                left++;
                right--;
            }
            for(int j=0; j<currRow.length; j++){
                currRow[j] = currRow[j] == 1 ? 0 : 1;
            }
        }
        return image;
    }
}