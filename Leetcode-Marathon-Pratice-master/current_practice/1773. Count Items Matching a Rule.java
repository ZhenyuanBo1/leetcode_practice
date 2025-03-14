class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        if(ruleKey.equals("type")){
            ans = help(items, 0, ruleValue);
        }else if(ruleKey.equals("color")){
            ans = help(items, 1, ruleValue);
        }else if(ruleKey.equals("name")){
            ans = help(items, 2, ruleValue);
        }

        return ans;
    }

    private int help(List<List<String>> items, int targetIndex, String targetVal){
        int count=0;
        for(int i=0; i<items.size(); i++){
            List<String> currItem = items.get(i);
            if(currItem.get(targetIndex).equals(targetVal)){
                count += 1;
            }
        }

        return count;
    }
}