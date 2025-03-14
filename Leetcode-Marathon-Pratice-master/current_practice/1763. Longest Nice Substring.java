class Solution {
    public String longestNiceSubstring(String s) {
        String result = "";

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                String target = s.substring(i, j+1);
                if(isNice(target)){
                    if(result.length() < target.length()){
                        result = target;
                    }
                }
            }
        }

        return result;
    }

    private boolean isNice(String test){
        boolean[] targetArr = new boolean[52];

        for(int i=0; i<test.length(); i++){
            if((int)test.charAt(i) >= 97){
                int lowerIndex = (int)test.charAt(i) - 97;
                targetArr[lowerIndex] = true;
            }else{
                int upperIndex = (int)test.charAt(i) - 39;
                targetArr[upperIndex] = true;
            }
        }

        for(int i=0; i<26; i++){
            if(targetArr[i]){
                if(!targetArr[i+26]) return false;
            }

            if(targetArr[i+26]){
                if(!targetArr[i]) return false;
            }
        }

        return true;
    }
}