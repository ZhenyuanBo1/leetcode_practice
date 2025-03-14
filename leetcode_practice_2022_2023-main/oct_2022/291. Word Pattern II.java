class Solution {
    //using backtracking + hashmap
    Map<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    public boolean wordPatternMatch(String pattern, String s) {
        return isMatch(s, 0, pattern, 0, map, set);
    }

    private boolean isMatch(String str, int i, String pattern, int j){
        if(i==str.length() && j == pattern.length()) return true;
        if(i==str.length() || j == pattern.length()) return false;

        char c = pattern.charAt(j);
        if(map.containsKey(c)){
            String s = map.get(c);
            if(!str.startsWith(s, i)) return false;
            return isMatch(str, i+s.length(), pattern, j+1);
        }

        for(int k=i; k<str.length(); k++){
            String p = str.substring(i, k+1);
            if(set.contains(p)) continue;
            map.put(c, p);
            set.add(p);
            if(isMatch(str, k+1, pattern, j+1)) return true;
            map.remove(c);
            set.remove(p);
        }

        return false;
    }
}