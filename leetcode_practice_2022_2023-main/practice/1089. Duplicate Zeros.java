class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i=0; i<arr.length;){
            if(arr[i] == 0 && i+1 < arr.length){
                modifyArr(arr, i+1);
                arr[i+1] = arr[i];
                i+=2;
            }else{
                i++;
            }
        }
    }
    private void modifyArr(int[] arr, int end){
        for(int i=arr.length-1; i>end; i--){
            arr[i] = arr[i-1]; 
        }
    }
    
}