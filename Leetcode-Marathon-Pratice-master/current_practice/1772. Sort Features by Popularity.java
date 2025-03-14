class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> fmap = new HashMap<>();
        Map<String, Integer> imap = new HashMap<>();

        for(int i=0; i<features.length; i++){
            fmap.put(features[i], 0);
            imap.put(features[i], i);
        }

        for(String response: responses){
            String[] arr = response.split(" ");
            Set<String> visited = new HashSet<>();
            for(String val: arr){
                if(!visited.contains(val)){
                    visited.add(val);
                    map.put(val, map.getOrDefault(val, 0)+1);
                }
            }
        }

        Arrays.sort(features, new Comparator<String>(){
            public int compare(String a, String b){
                if(map.get(a) == map.get(b)){
                    return imap.get(a) - imap.get(b);
                }
                return fmap.get(b) - fmap.get(a);
            }
        });

        return features;



    }


}