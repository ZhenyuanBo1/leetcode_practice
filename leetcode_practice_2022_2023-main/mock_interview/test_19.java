class Solution {
    public int[] shuffle(int[] nums, int n) {
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        int index = n / 2;

        for(int i=0; i<index; i++){
            xList.add(nums[i]);
        }

        for(int i=index; i<nums.length; i++){
            yList.add(nums[i]);
        }

        int[] res = new int[n];

        int j = 0, k = 0;
        for(int i=0; i<res.length; i++){
            if(i % 2 == 0){
                res[i] = xList.get(j++);
            }else{
                res[i] = yList.get(k++);
            }
        }

        return res;

    }
}