//binary search by value
class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length-1;
        int duplicate = -1;

        while(left <= right){
            int mid = left+(right-left)/2;
            int countLessOrEqual = 0;
            for(int i=0; i<nums.length; i++){
                if(nums[i]<=mid) countLessOrEqual++;
            }
            if(countLessOrEqual>mid){
                duplicate = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return duplicate;
    }
}


//indexing sort
class Solution {
    public int findDuplicate(int[] nums) {
        int[] newNums = new int[nums.length+1];

        for(int i=0; i<nums.length; i++){
            newNums[i+1] = nums[i];
        }

        for(int i=0; i<newNums.length; i++){
            while(newNums[i]!=i && newNums[i]!=newNums[newNums[i]]){
                int temp = newNums[i];
                newNums[i] = newNums[temp];
                newNums[temp] = temp;
            }
        }

        for(int i=0; i<newNums.length; i++){
            if(newNums[i]!=i) return newNums[i];
        }

        return -1;

    }
}