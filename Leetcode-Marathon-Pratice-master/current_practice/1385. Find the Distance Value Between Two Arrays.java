class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for(int i=0; i<arr1.length; i++){
            int j=0;
            while(j<arr2.length && Math.abs(arr1[i] - arr2[j])>d){
                j++;
            }
            // System.out.println("j val: " + j);
            if(j == arr2.length) count+=1;
        }

        return count;
    }
}