class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

        List<Integer> arrList = new ArrayList<>();
        List<Integer> arrList2 = new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<arr1.length; i++){
            arrList.add(arr1[i]);
        }


        for(int j=0; j<arr2.length; j++){
            if(arrList.contains(arr2[j])){
                arrList2.add(arr2[j]);
            }
        }


        for(int k=0; k<arr3.length; k++){
            if(arrList2.contains(arr3[k])){
                ans.add(arr3[k]);
            }
        }

        return ans;
    }
}