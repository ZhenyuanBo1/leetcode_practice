class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);

        while(!queue.isEmpty()){
            int start = queue.remove();
            if(visited[start]) continue;
            for(int e = start+1; e<=s.length(); e++){
                if(wordDict.contains(s.substring(start, e))){
                    queue.add(e);
                    if(e == s.length()) return true;
                }
            }
            visited[start] = true;
        }

        return false;
    }
}