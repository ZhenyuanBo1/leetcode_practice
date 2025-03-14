class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
        }

        List<Integer> duplicates = new ArrayList<>();

        Set<Integer> uniques = new HashSet<>();

        for(Character c: freq.keySet()){
            if(!uniques.add(freq.get(c))){
                duplicates.add(freq.get(c));
            }
        }

        int res = 0;
        
        for(int i=0; i<duplicates.size(); i++){
            int val = duplicates.get(i);
            while(uniques.contains(val)){
                val--;
                res++;
            }
            if(val > 0) uniques.add(val);
        }

        return res;
    }
}