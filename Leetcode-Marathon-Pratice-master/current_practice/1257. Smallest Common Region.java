class Solution {

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parent = new HashMap<>();
        parent.put(regions.get(0).get(0), null);

        Map<String, List<String>> neighbors = new HashMap<>();

        for(int i=0; i<regions.size(); i++){
            List<String> list = regions.get(i);
            List<String> newList = new ArrayList<>();
            for(int j=1; j<list.size(); j++){
                newList.add(list.get(j));
            }
            neighbors.put(list.get(0), newList);
        }

        Queue<String> q = new LinkedList<>();
        q.add(regions.get(0).get(0));


        while(!parent.containsKey(region1) || !parent.containsKey(region2)){
            String r = q.remove();

            if(neighbors.containsKey(r)){
                List<String> children = neighbors.get(r);

                for(String child: children){
                    parent.put(child, r);
                }

                q.addAll(children);
            }
        }

        Set<String> ancestors = new HashSet<>();

        while(region1 != null){
            ancestors.add(region1);
            region1 = parent.get(region1);
        }

        while(!ancestors.contains(region2)){
            region2 = parent.get(region2);
        }

        return region2;

    }
}