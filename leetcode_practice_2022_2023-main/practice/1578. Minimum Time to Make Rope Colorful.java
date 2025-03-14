class Solution {
    //using two pointers to separate strings into groups of duplicate chars
    public int minCost(String colors, int[] neededTime) {
        int p1 = 0;
        int cost = 0;

        while(p1<colors.length()){
            int p2 = p1+1;
            while(p2<colors.length() && colors.charAt(p2) == colors.charAt(p1)){
                p2++;
            }
            cost += getCost(neededTime, p1, p2);
            p1 = p2;
        }

        return cost;
    }
    private int getCost(int[] neededTime, int s, int e){
        int max = Integer.MIN_VALUE;
        for(int i=s; i<e; i++){
            max = Math.max(neededTime[i], max);
        }

        int currCost = 0;

        for(int i=s; i<e; i++){
            currCost += neededTime[i];
        }

        return currCost - max;
    }
}