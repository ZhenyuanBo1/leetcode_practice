class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        //calculate the hash value of each string and use that as key to group strings
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strings){
            String curr = str;
            int shift = curr.charAt(0);
            String res = "";
            for(int i=0; i<curr.length(); i++){
                //use the same difference to get the character that has the same difference from 'a'
                res += (char)((curr.charAt(i) - shift + 26) % 26 + 'a');
            }
            if(map.containsKey(res)){
                map.get(res).add(curr);
            }else{
                List<String> group = new ArrayList<>();
                group.add(curr);
                map.put(res, group);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(String key: map.keySet()){
            List<String> newGroup = new ArrayList<>();
            for(String str: map.get(key)){
                newGroup.add(str);
            }
            ans.add(newGroup);
        }

        return ans;
    }
}