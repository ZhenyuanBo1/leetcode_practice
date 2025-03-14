class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        //max size is not used 
        //we keep the string length as min as possible in order to max frequency 
        Map<String, Integer> freq = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(int i=0; i<s.length()-minSize+1; i++){
            String substr = s.substring(i, i+minSize);
            if(isValid(substr, maxLetters)){
                freq.put(substr, freq.getOrDefault(substr, 0)+1);
                max = Math.max(max, freq.get(substr));
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
    private boolean isValid(String s, int maxLetters){
        Set<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            set.add(s.charAt(i));
        }

        return set.size() <= maxLetters;
    }
}