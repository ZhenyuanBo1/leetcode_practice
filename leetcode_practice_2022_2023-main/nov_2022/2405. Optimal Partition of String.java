class Solution {
    public int partitionString(String s) {
        //using two pointers
        int p1=0;
        List<String> res = new ArrayList<>();
        while(p1<s.length()){
            int p2 = p1;
            Set<Character> set = new HashSet<>();
            while(p2<s.length() && !set.contains(s.charAt(p2))){
                set.add(s.charAt(p2));
                p2++;
            }  
            res.add(s.substring(p1, p2));
            p1 = p2;
        }
        return res.size();
    }
}