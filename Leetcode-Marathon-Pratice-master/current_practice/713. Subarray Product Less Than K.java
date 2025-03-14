class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int p = 1, left = 0, count = 0;

        for(int right = 0; right < nums.length; right++){
            p*=nums[right];
            while(p>=k) p/=nums[left++];
            count += right - left+1;
        }

        return count;
    }
}


class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int[] preprod = new int[nums.length + 1];
        preprod[0] = 1;

        for(int i=0; i<nums.length; i++){
            preprod[i+1] = preprod[i] * nums[i];
        }

        int j=0;
        int count = 0;
        for(int i=0; i<preprod.length; i++){
            while(j<preprod.length && preprod[j]/preprod[i]<k){
                j++;
            }
            count += j-(i+1);
            // System.out.println("j: " + j + " i: " + i + " count: " + count);
            if(count < 0) return 0;
        }

        return count;
    }
}


class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k)
    {
        if (k<=1) return 0;
        int j=0;
        int prod = 1;
        int count = 0;
        for (int i=0; i<nums.size(); i++)
        {
            if (j<i)
            {
                j = i;
                prod = 1;
            }

            while (j<nums.size() && prod*nums[j]<k)
            {
                prod = prod*nums[j];
                j++;
            }
            count += j-i;
            prod = prod/nums[i];
        }
        return count;
    }
};