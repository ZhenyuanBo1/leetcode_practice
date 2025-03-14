class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {
        //using binary search by value
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int left=0, right=nums.length;

        while(left < right){
            int f = right-(right-left)/2;
            if(countFreqGreaterOrEqual(f)>=k){
                left = f;
            }else{
                right = f-1;
            }
        }

        int f = left;

        List<Integer> res = new ArrayList<>();

        for(Integer key: map.keySet()){
            if(map.get(key)>=f){
                res.add(key);
            }
        }

        int[] ans = new int[res.size()];

        for(int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
    private int countFreqGreaterOrEqual(int f){
        int count = 0;
        for(Integer key: map.keySet()){
            if(map.get(key) >= f){
                count += 1;
            }
        }

        return count;
    }
}

class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {
        //using quick select method
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        //create a list that contains the frequency value
        int[] fArr = new int[map.values().size()];

        int index = 0;
        for(Integer freq: map.values()){
            fArr[index++] = freq;
        }

        int f = quickSelect(fArr, 0, fArr.length-1, k);

        List<Integer> res = new ArrayList<>();
        for(Integer key: map.keySet()){
            if(map.get(key) >= f){
                res.add(key);
            }
        }

        int[] ans = new int[res.size()];

        for(int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;


    }

    private int quickSelect(int[] fArr, int start, int end, int k){
        //similar to quick sort
        int pivot = fArr[(start+end)/2];
        int i = start, j = end, t = i;
        while(t<=j){
            if(fArr[t]<pivot){
                int temp = fArr[t];
                fArr[t] = pivot;
                fArr[i] = temp;
                i++;
                t++;
            }else if(fArr[t]>pivot){
                int temp = fArr[j];
                fArr[j] = fArr[t];
                fArr[t] = temp;
                j--;
            }else{
                t++;
            }
        }
        if(end-j>=k) return quickSelect(fArr, j+1, end, k);
        else if(end-i+1>=k) return pivot;
        else return quickSelect(fArr, start, i-1, k-(end-i+1));
    }

}