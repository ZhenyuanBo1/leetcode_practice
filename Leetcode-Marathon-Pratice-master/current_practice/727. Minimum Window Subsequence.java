class Solution {
    public String minWindow(String s1, String s2) {
        //use state machine to build next matrix for s2
        int m = s2.length();
        s2 = "#" + s2;

        int[][] next = new int[m+1][26];

        for(int i=0; i<26; i++){
            next[m][i] = -1;
        }

        for(int i=m; i>=1; i--){
            for(int j=0; j<26; j++){
                next[i-1][j] = next[i][j];
            }
            next[i-1][s2.charAt(i)-'a'] = i;
        }

        //iterate through s2 to look for the starting and end index in s1
        int j=0, startIndex=-1;
        String res = "";
        int left = 0;

        while(left + s2.length()-1 < s1.length()){
            int right = left;
            while(right+1 < s1.length()){
                int pos = next[j][s1.charAt(right)-'a'];
                // System.out.println("pos: " + pos);
                if(pos != -1){
                    if(pos == s2.length()-1){
                        //finish the iteration of s2, start over again
                        j = 0;
                        String curr = "";
                        if(startIndex != -1) curr = s1.substring(startIndex, right+1);
                        else if(s2.length() == 2) curr = s2.substring(1);
                        if(res.length() == 0){
                            res = curr;
                        }else if(curr.length() < res.length()){
                            res = curr;
                        }
                        break;
                    }else{
                        if(j==0 && pos==1){
                            startIndex = right;
                        }
                        if(startIndex != -1) j = pos;
                    }
                }
                right++;
            }
            // System.out.println("start index: " + startIndex + " right index: " + right);
            left++;
        }

        return res;
    }
}