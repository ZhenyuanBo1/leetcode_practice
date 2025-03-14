class Solution {
    private List<List<Character>> chars;
    public List<String> letterCombinations(String digits) {
        this.chars = new ArrayList<>();

        if(digits.equals("")) return new ArrayList<>();

        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        char[] arr = digits.toCharArray();

        for(char c: arr){
            this.chars.add(map.get(c));
        }

        String curr = "";

        List<String> ans = new ArrayList<>();

        backtrack(curr, ans, 0, digits.length());

        return ans;
    }

    private void backtrack(String s, List<String> ans, int index, int len){
        if(s.length() == len){
            ans.add(s);
            return;
        }

        List<Character> possibleChars = this.chars.get(index);
        for(int i=0; i<possibleChars.size(); i++){
            backtrack(s+possibleChars.get(i), ans, index+1, len);
        }
    }
}