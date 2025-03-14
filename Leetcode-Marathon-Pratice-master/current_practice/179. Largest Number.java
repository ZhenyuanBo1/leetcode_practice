class Solution {
    private class largestNumberComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
    public String largestNumber(int[] nums) {
        String[] unsorted = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            unsorted[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(unsorted, new largestNumberComparator());

        if(unsorted[0].equals("0")){
            return "0";
        }

        String res = new String();

        for(int j=0; j<unsorted.length; j++){
            res += unsorted[j];
        }

        return res;
    }
}