class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<groupSizes.length; i++){
            if(map.containsKey(groupSizes[i])){
                map.get(groupSizes[i]).add(i);
            }else{
                List<Integer> indicies = new ArrayList<>();
                indicies.add(i);
                map.put(groupSizes[i], indicies);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(Integer size: map.keySet()){
            List<Integer> indices = map.get(size);
            int j=0;
            List<Integer> group = new ArrayList<>();
            while(j<indices.size()){
                group.add(indices.get(j++));
                if(group.size() == size){
                    ans.add(group);
                    group = new ArrayList<>();
                }
            }
        }

        return ans;
    }
}