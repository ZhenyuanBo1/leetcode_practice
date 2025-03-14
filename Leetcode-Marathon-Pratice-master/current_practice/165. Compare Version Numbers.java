class Solution {
    public int compareVersion(String version1, String version2) {

        String[] v1DigitArr = version1.split("\\.");
        String[] v2DigitArr = version2.split("\\.");

        int i=0, j=0;

        while(i<v1DigitArr.length || j<v2DigitArr.length){
            if(i>=v1DigitArr.length){
                if(Integer.parseInt(v2DigitArr[j])>0){
                    return -1;
                }else{
                    j++;
                }
            }else if(j>=v2DigitArr.length){
                if(Integer.parseInt(v1DigitArr[i])>0){
                    return 1;
                }else{
                    i++;
                }
            }else{
                if(Integer.parseInt(v1DigitArr[i]) > Integer.parseInt(v2DigitArr[j])){
                    return 1;
                }else if(Integer.parseInt(v1DigitArr[i]) < Integer.parseInt(v2DigitArr[j])){
                    return -1;
                }else{
                    i++;
                    j++;
                }
            }
        }

        return 0;
    }
}