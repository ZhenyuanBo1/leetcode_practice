class Solution {
    public int numTilePossibilities(String tiles) {
        int sum = 0;
        List<List<String>> res = new ArrayList<>();
        for(int i=1; i<=tiles.length(); i++){
            Set<String> curr = new HashSet<>();
            boolean[] visited = new boolean[tiles.length()];
            helper(curr, visited, "", tiles, i);
            sum += curr.size();
        }
        return sum;
    }
    private void helper(Set<String> curr, boolean[] visited, String seq, String tiles, int len){
        if(len == 0){
            curr.add(seq);
            return;
        }
        for(int i=0; i<tiles.length(); i++){
            if(visited[i]) continue;
            char c = tiles.charAt(i);
            visited[i] = true;
            helper(curr, visited, seq + c, tiles, len-1);
            visited[i] = false;
        }
    }
}