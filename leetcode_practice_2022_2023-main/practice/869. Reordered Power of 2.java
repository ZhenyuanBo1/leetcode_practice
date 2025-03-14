class Solution {
    public boolean reorderedPowerOf2(int n) {
        if(n == 1) return true;

        List<Integer> digits = new ArrayList<>();

        while(n!=0){
            int rem = n % 10;
            digits.add(0, rem);
            n = n / 10;
        }

        boolean[] visited = new boolean[digits.size()];


        return backtrack(0, digits, digits.size(), visited);

    }

    private boolean backtrack(int curr, List<Integer> digits, int len, boolean[] visited){
        if(curr != 0 && (curr+"").length() == len){
            //power of 2 will only have 1 bit 1
            return Integer.bitCount(curr) == 1;
        }

        for(int i=0; i<digits.size(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            if(backtrack(curr*10 + digits.get(i), digits, len, visited)) return true;
            visited[i] = false;
        }

        return false;
    }

}