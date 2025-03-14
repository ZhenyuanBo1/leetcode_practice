class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] ans = new int[mat.length * mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        List<List<Integer>> list = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        visited[0][0] = true;

        int index = 0;

        int[] rowOffset = new int[]{0, 1, 0, -1};
        int[] colOffset = new int[]{1, 0, -1, 0};

        boolean reverse = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> curr = new ArrayList<>();
            for(int i=0; i<size; i++){
                int[] cell = q.poll();
                curr.add(mat[cell[0]][cell[1]]);
                for(int j=0; j<4; j++){
                    int newr = cell[0] + rowOffset[j];
                    int newc = cell[1] + colOffset[j];
                    if(newr>=0 && newr<mat.length && newc>=0 && newc<mat[0].length && !visited[newr][newc]){
                        q.offer(new int[]{newr, newc});
                        visited[newr][newc] = true;
                    }
                }
            }
            if(list.size()>=2){
                if(reverse){
                    list.add(reverseList(curr));
                }else{
                    list.add(curr);
                }
                reverse = !reverse;
            }else{
                list.add(curr);
            }
        }

        for(List<Integer> l: list){
            for(Integer i: l){
                ans[index++] = i;
            }
        }

        return ans;


    }
    private List<Integer> reverseList(List<Integer> list){
        List<Integer> reversed = new ArrayList<>();
        for(int i=list.size()-1; i>=0; i--){
            reversed.add(list.get(i));
        }
        return reversed;
    }
}