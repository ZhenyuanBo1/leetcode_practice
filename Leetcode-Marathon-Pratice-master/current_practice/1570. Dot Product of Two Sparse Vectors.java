class SparseVector {
    public List<Integer> list;

    SparseVector(int[] nums) {
        this.list = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            this.list.add(nums[i]);
        }

    }

	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        List<Integer> list2 = vec.list;
        int ret = 0;
        for(int i=0; i<this.list.size(); i++){
            if(this.list.get(i) != 0 && list2.get(i) != 0){
                ret += this.list.get(i) * list2.get(i);
            }
        }
        return ret;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);


//using HashMap
class SparseVector {
    public Map<Integer, Integer>map;

    SparseVector(int[] nums) {
        this.map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                map.put(i, nums[i]);
            }
        }
    }

	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int ret = 0;
        for(Integer index: map.keySet()){
            if(vec.map.containsKey(index)){
                ret += map.get(index) * vec.map.get(index);
            }
        }
        return ret;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);