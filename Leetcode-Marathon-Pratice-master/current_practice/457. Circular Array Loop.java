class Solution {
    public boolean circularArrayLoop(int[] nums) {

        boolean foundCycle = false;

        for(int i=0; i<nums.length; i++){
            int j = i;
            int cycleIndex = 0;
            List<Integer> indexList = new ArrayList<>();
            indexList.add(0);
            while(true){
                int steps = nums[j];
                int nextIndex = j + steps;
                if(nextIndex < 0){
                    nextIndex = ((-1)*nextIndex) % nums.length;
                }else{
                    nextIndex = nextIndex % nums.length;
                }
                if(indexList.contains(nextIndex)){
                    cycleIndex = nextIndex;
                    break;
                }else{
                    indexList.add(nextIndex);
                    j = nextIndex;
                }
            }

            int pos = indexList.indexOf(cycleIndex)+1;

            boolean allPos = nums[cycleIndex] > 0;
            boolean allNeg = nums[cycleIndex] < 0;
            boolean isCycle = true;
            for(int k=pos; k<indexList.size(); k++){
                if(allPos && nums[indexList.get(k)] < 0){
                    isCycle = false;
                    break;
                };
                if(allNeg && nums[indexList.get(k)] > 0){
                    isCycle = false;
                    break;
                }
            }
            if(isCyle && pos<indexList.size()){
                foundCycle = true;
                break;
            }
        }

        if(!foundCycle) return false;

        return true;

    }
}