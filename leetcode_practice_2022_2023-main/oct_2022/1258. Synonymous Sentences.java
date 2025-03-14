class Solution {
    private String[] arrCopy;
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, String> map = new HashMap<>();
        String[] arr = text.split(" ");
        this.arrCopy = text.split(" ");
        for(int i=0; i<synonyms.size(); i++){
            String key = synonyms.get(i).get(0);
            String val = synonyms.get(i).get(1);
            map.put(key, val);
        }
        List<String> res = new ArrayList<>();
        helper(map, arr, 0, res);
        Collections.sort(res);
        return res;
    }

    private void helper(Map<String, String> map, String[] arr, int index, List<String> res){
        if(index>=arr.length){
            String newStr = buildStr(arr);
            if(!res.contains(newStr)) res.add(buildStr(arr));
            return;
        }

        for(int i=index; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                arr[i] = map.get(arr[i]);
            }
            helper(map, arr, i+1, res);
            arr[i] = this.arrCopy[i];
        }
    }

    private String buildStr(String[] curr){
        String res = "";
        for(int i=0; i<curr.length; i++){
            res += curr[i] + " ";
        }
        res = res.substring(0, res.length()-1);
        return res;
    }
}