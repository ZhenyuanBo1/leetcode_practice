class Solution {
    public int minDeletions(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> freqs = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for(Character c: freq.keySet()){
            if(!freqs.add(freq.get(c))) duplicates.add(freq.get(c));
        }

        int count = 0;

        for(Integer i: duplicates){
            while(freqs.contains(i)){
                i--;
                count++;
            }
            if(i>0) freqs.add(i);
        }
        
        return count;

    }
}