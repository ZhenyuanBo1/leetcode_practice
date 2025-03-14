class Solution {
    public int countBinarySubstrings(String s) {
        //separate into groups of the same character
        List<Integer> group = new ArrayList<>();

        int count = 0, totalCount=0;
        for(int i=0; i+1<s.length(); i++){
            if(s.charAt(i) == s.charAt(i+1)){
                count++;
            }else{
                count++;
                group.add(count);
                count=0;
            }
        }

        group.add(++count);

        for(int i=0; i+1<group.size(); i++){
            totalCount += Math.min(group.get(i), group.get(i+1));
        }

        return totalCount;

    }
}