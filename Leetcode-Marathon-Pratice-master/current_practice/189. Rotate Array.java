class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        if(k==0 || k==n) return;

        int pos = n - k%n;

        int left = 0, right = pos;

        int[] nums1 = new int[nums.length];

        int j=0;
        for(int i=right; i<n; i++){
            nums1[j++] = nums[i];
        }

        while(left<right){
            nums1[j++] = nums[left++];
        }

        for(int i=0; i<nums1.length; i++){
            nums[i] = nums1[i];
        }

    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for(int start=0; count<nums.length; start++){
            int current = start;
            int prev = nums[start];
            while(start!=current){
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                curent = next;
                count++;
            }
        }
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        /*
        1. calculate the next position for each of the existing value
        2. place the value into the next position
        */
        for(int start=0; count<nums.length; start++){
            int current = start;
            int prev = nums[start];
            do{
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }while(start!=current);
        }
    }
}