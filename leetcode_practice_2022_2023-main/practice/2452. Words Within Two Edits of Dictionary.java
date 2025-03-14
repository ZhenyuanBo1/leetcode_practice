class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for(String query: queries){
            if(isValid(query, dictionary)){
                ans.add(query);
            }
        }
        return ans;
    }
    private boolean isValid(String query, String[] dictionary){
        boolean seen = false;
        for(int i=0; i<dictionary.length; i++){
            String item = dictionary[i];
            int count = 0;
            for(int j=0; j<query.length(); j++){
                if(item.charAt(j) != query.charAt(j)) count++;
            }
            if(count <= 2) seen = true;
        }
        return seen;
    }
}