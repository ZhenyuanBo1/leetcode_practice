class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int val: score){
            heap.add(val);
        }

        List<Integer> scores = new ArrayList<>();

        while(!heap.isEmpty()){
            scores.add(heap.remove());
        }

        String[] res = new String[score.length];

        for(int i=0; i<score.length; i++){
            int index = scores.indexOf(score[i]);
            if(index == 0){
                res[i] = "Gold Medal";
            }else if(index == 1){
                res[i] = "Silver Medal";
            }else if(index == 2){
                res[i] = "Bronze Medal";
            }else{
                res[i] = Integer.toString(index+1);
            }
        }

        return res;
    }
}