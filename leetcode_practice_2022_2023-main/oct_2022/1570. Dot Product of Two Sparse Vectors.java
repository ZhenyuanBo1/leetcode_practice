class SparseVector {
    Map<Integer, Integer> map = new HashMap<>();
    
    SparseVector(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0) map.put(i, map.getOrDefault(i, 1) * nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Map<Integer, Integer> targetMap = vec.map;
        int sum = 0;
        for(Integer key: map.keySet()){
            if(targetMap.containsKey(key)){
                sum += map.get(key) * targetMap.get(key);
            }
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);