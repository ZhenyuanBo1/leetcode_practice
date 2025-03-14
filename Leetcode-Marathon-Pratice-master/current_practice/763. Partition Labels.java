class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                List<Integer> range = map.get(s.charAt(i));
                range.set(1, i);
            }else{
                List<Integer> indicies = new ArrayList<>();
                indicies.add(i);
                indicies.add(i);
                map.put(s.charAt(i), indicies);
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> list: map.values()){
            List<Integer> list1 = new ArrayList<>();
            list1.add(list.get(0));
            list1.add(1);
            List<Integer> list2 = new ArrayList<>();
            list2.add(list.get(1));
            list2.add(-1);
            res.add(list1);
            res.add(list2);
        }

        Collections.sort(res, new Comparator<List<Integer>>(){
            public int compare(List<Integer> a, List<Integer> b){
                return Integer.compare(a.get(0), b.get(0));
            }
        });

        List<Integer> ans = new ArrayList<>();

        int count = 0, start = 0, end = 0;

        for(int i=0; i<res.size(); i++){
            if(res.get(i).get(1) == 1){
                count++;
                if(count == 1){
                    start = res.get(i).get(0);
                }
            }else{
                count--;
                if(count == 0){
                    end = res.get(i).get(0);
                    int len = end-start+1;
                    ans.add(len);
                }
            }
        }

        return ans;
    }
}