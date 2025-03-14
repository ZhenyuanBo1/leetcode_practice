class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();

        List<Integer> indexList = new ArrayList<>();

        for(int i: indices){
            indexList.add(i);
        }

        for(int i=0; i<s.length();){
            if(indexList.indexOf(i) > -1){
                int sourceIndex = indexList.indexOf(i);
                String srcStr = sources[sourceIndex];
                String sub = s.substring(i, i+srcStr.length() > s.length() ? s.length() : i+srcStr.length());
                if(sub.equals(srcStr)){
                   sb.append(targets[sourceIndex]); 
                }else{
                    sb.append(sub);
                }
                i+=srcStr.length();
                indexList.set(sourceIndex, -1);
            }else{
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}