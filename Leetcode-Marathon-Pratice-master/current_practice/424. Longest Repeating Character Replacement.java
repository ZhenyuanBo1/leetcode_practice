class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();

        int l=0, n=s.length(), max=0;

        for(int r=0; r<n; r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0)+1);
            // System.out.println(Collections.max(count.values()));
            while((r-l+1-Collections.max(count.values()))>k){
               count.put(s.charAt(l), count.get(s.charAt(l))-1);
               l++;
            }
            // System.out.println("r: " + r + " l: " + l);
            max = Math.max(max, r-l+1);
        }

        return max;
    }
}