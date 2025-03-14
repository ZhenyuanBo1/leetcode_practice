class Solution {
    public String maxValue(String n, int x) {

        int insertIndex = -1;

        if(n.charAt(0) == '-'){
            //process the negative number
            for(int i=1; i<n.length(); i++){
                if(Character.getNumericValue(n.charAt(i)) > x){
                    insertIndex = i;
                    break;
                }
            }
        }else{
            //process the positive number
            for(int i=0; i<n.length(); i++){
                if(Character.getNumericValue(n.charAt(i)) < x){
                    insertIndex = i;
                    break;
                }
            }
        }

        insertIndex = insertIndex == -1 ? n.length() : insertIndex;

        if(insertIndex == 0){
            return x + n;
        }else if(insertIndex == n.length()){
            return n + x;
        }

        // System.out.println(insertIndex);

        return n.substring(0, insertIndex) + x + n.substring(insertIndex);




    }
}