class Solution {
    public boolean canWin(String currentState) {
        for(int i=1; i<currentState.length(); i++){
            if(currentState.charAt(i) == '+' && currentState.charAt(i-1) == '+'){
                char[] arr = currentState.toCharArray();
                arr[i] = '-';
                arr[i-1] = '-';
                if(!canWin(new String(arr))){
                    return true;
                }
            }
        }

        return false
    }
}