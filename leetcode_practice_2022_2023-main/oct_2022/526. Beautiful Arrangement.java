class Solution {
    private int totalLen;
    private int res;
    public int countArrangement(int n) {
       boolean[] visited = new boolean[n];
       this.totalLen = n;
       List<Integer> curr = new ArrayList<>();
       helper(curr, visited, n);
       return this.res; 
    }

    private void helper(List<Integer> curr, boolean[] visited, int n){
        if(n == 0){
            this.res += 1;
            return;
        }

        for(int i=1; i<=this.totalLen; i++){
            if(visited[i-1]) continue;
            int nextIndex = curr.size() + 1;
            if(i % nextIndex == 0 || nextIndex % i == 0){
                visited[i-1] = true;
                curr.add(i);
                helper(curr, visited, n-1);
                curr.remove(curr.size()-1);
                visited[i-1] = false;
            }
        }
    }
}