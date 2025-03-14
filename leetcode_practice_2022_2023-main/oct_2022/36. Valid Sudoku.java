class Solution {
    Map<Character, List<List<Integer>>> map = new HashMap<>();
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] != '.'){
                    char curr = board[i][j];
                    if(!map.containsKey(curr)){
                        List<List<Integer>> posList = new ArrayList<>();
                        List<Integer> pos = new ArrayList<Integer>(Arrays.asList(i, j));
                        posList.add(pos);
                        map.put(curr, posList);
                    }else{
                        if(hasRepetition(curr, i, j)) return false;
                        List<List<Integer>> targetPosList = map.get(curr);
                        targetPosList.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                        map.put(curr, targetPosList);
                    }
                }
            }
        }
        return true;
    }
    private boolean hasRepetition(char ch, int r, int c){
        List<List<Integer>> targetPosList = map.get(ch);
        for(List<Integer> list: targetPosList){
            int r0 = list.get(0);
            int c0 = list.get(1);
            if(r0 == r || c0 == c) return true;
            int rLow = (list.get(0)/3)*3;
            int cLow = (list.get(1)/3)*3;
            int rMax = rLow + 2;
            int cMax = cLow + 2;
            if(r>=rLow && r<=rMax && c>=cLow && c<=cMax) return true;
        }
        return false;
    }
}