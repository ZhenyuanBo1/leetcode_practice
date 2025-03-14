class Solution {
    public List<String> generatePalindromes(String s) {
        int[] freq = new int[26];

        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            freq[index]++;
        }

        int oddCount = 0;
        char oddChar = '';

        for(int i=0; i<freq.length; i++){
            if(freq[i]%2 == 1){
                oddCount ++;
                oddChar = (char)('a' + i);
            }
        }

        // as long as there is more than 1 odd char, its empty list
        if(oddCount > 1) return new ArrayList<>();

        String base = "";
        int sLen = s.length();

        if(oddCount == 1){
            base = oddChar + "";
            freq[oddChar-'a'] -= 1;
            sLen -= 1;
        }

        List<String> res = new ArrayList<>();
        helper(res, base, freq, sLen);

        return res;
    }

    private void helper(List<String> res, String base, int[] freq, int len){
        if(len == 0){
            res.add(base);
            return;
        }

        //backtracking
        for(int i=0; i<freq.length; i++){
            if(freq[i] == 0) continue;
            freq[i] -= 2;
            char ch = (char)('a' + i);
            helper(res, ch + base + ch, freq, len-2);
            freq[i] += 2;
        }
    }
}