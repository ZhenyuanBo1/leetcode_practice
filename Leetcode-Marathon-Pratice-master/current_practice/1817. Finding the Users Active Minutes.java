class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<logs.length; i++){
            int[] log = logs[i];
            int userID = log[0];
            int mins = log[1];
            if(map.containsKey(userID)){
                map.get(userID).add(mins);
            }else{
                Set<Integer> minSet = new HashSet<>();
                minSet.add(mins);
                map.put(userID, minSet);
            }
        }



        int[] ans = new int[k];

        for(Integer key: map.keySet()){
            int uam = map.get(key).size();
            ans[uam-1]++;
        }

        return ans;
    }
}