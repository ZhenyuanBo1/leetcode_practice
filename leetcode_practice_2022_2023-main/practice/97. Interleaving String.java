class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int p1 = 0, p2 = 0;
        in slow = 0;
        boolean isCurrS1 = true;

        while(slow < s3.length()){
            int fast = slow+1;
            while(fast < s3.length()){
                if(isCurrS1){
                    String s1substr = s1.substring(p1);
                    if(s1substr.indexOf(s3.substring(slow, fast)) > -1){
                        fast++;
                    }else{
                        break;
                    }
                }else{
                    String s2substr = s2.substring(p2);
                    if(s2substr.indexOf(s3.substring(slow, fast)) > -1){
                        fast++;
                    }else{
                        break;
                    }
                }
            }
            if(isCurrS1){
                p1 += fast-slow+1;
            }else{
                p2 += fast-slow+1;
            }
            isCurrS1 = !isCurrS1;
            slow = fast;
        }

        return p1 >= s1.length() && p2 >= s2.length();
    }
}