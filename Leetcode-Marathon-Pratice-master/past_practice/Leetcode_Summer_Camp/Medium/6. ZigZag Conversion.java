class Solution {
    public String convert(String s, int numRows) {

        if(numRows==1) return s;

        int[] indexArr = new int[s.length()];
        int rowIndex = 1;
        String res = "";
        boolean hasReachedMax = false;

        for(int i=0; i<indexArr.length; i++){
            if(rowIndex == numRows){
                hasReachedMax = true;
            }
            if(rowIndex==1 && hasReachedMax){
                hasReachedMax = false;
            }
            if(!hasReachedMax){
                indexArr[i] = rowIndex;
                rowIndex++;
            }else{
                indexArr[i] = rowIndex;
                rowIndex--;
            }
        }

        for(int i=1; i<=numRows; i++){
            for(int j=0; j<indexArr.length; j++){
                if(indexArr[j]==i){
                    res+=s.charAt(j);
                }
            }
        }

        return res;
    }
}