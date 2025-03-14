class Solution {
    public boolean isSubsequence(String s, String t) {
        //using two pointer approach
        int p1 = 0, p2 = 0;

        while(p1 < s.length() && p2 < t.length()){
            //two pointers only move when a match is found, otherwise, only move p2
            if(s.charAt(p1) == t.charAt(p2)){
                p1++;
            }
            p2++;
        }

        return p1 == s.length();
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        //using hashmap
        //using map to store char-index list relationship from t
        Map<Character, List<Integer>> map = new HashMap<>();

        for(int i=0; i<t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                map.get(t.charAt(i)).add(i);
            }else{
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                map.put(t.charAt(i), indexList);
            }
        }

        int prevIndex = -1;
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            //look for curr in map
            if(map.containsKey(curr)){
                boolean found = false;
                for(Integer index: map.get(curr)){
                    if(index > prevIndex){
                        //found the expected index in t
                        prevIndex = index;
                        found = true;
                        break;
                    }
                }
                if(!found) return false;
            }else{
                return false;
            }
        }
        return true;
    }
}
