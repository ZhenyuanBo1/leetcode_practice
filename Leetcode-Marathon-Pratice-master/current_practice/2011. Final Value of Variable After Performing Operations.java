class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int val=0;
        for(int i=0; i<operations.length; i++){
            if(operations[i].contains("--")){
                val-=1;
            }else if(operations[i].contains("++")){
                val+=1;
            }
        }
        return val;
    }
}