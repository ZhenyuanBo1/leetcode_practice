class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int[] arrCopy = new int[arr.length];
        for(int i=0; i<arrCopy.length; i++){
            arrCopy[i] = arr[i];
        }

        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();

        int rank = 1;
        for(int i=1; i<=arr.length; i++){
            if(!map.containsKey(arr[i-1])){
                map.put(arr[i-1], rank);
                rank++;
            }
        }

        int[] res = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            res[i] = map.get(arrCopy[i]);
        }

        return res;
    }

}