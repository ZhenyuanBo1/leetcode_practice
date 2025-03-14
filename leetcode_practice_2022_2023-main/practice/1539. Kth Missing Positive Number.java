class Solution {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            list.add(arr[i]);
        }

        while(true){
            int i = 1;
            int j = 0;
            if(!list.contains(i)){
                j++;
                if(j == k) return i;
            }
            i++;
        }
    }
}