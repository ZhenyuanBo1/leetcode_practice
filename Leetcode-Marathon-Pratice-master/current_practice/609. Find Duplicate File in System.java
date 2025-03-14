class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<paths.length; i++){
            String dirInfoStr = paths[i];
            String[] dirInfos = dirInfoStr.split(" ");
            for(int j=1; j<dirInfos.length; j++){
                int openIndex = dirInfos[j].indexOf("(");
                int closeIndex = dirInfos[j].indexOf(")");
                String content = dirInfos[j].substring(openIndex+1, closeIndex);
                if(map.containsKey(content)){
                    map.get(content).add(dirInfos[0] + "/" + dirInfos[j].substring(0, openIndex));
                }else{
                    List<String> duplicateFiles = new ArrayList<>();
                    duplicateFiles.add(dirInfos[0] + "/" + dirInfos[j].substring(0, openIndex));
                    map.put(content, duplicateFiles);
                }
            }
        }


        List<List<String>> list = new ArrayList<>();

        for(String key: map.keySet()){
            if(map.get(key).size() >= 2) list.add(map.get(key));
        }

        return list;
    }
}