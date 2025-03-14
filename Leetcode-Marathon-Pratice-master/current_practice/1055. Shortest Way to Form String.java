class Solution {
    public int shortestWay(String source, String target) {
        //use state machine for source
        int m = source.length();
        source = "#" + source;

        int[][] next = new int[m+1][26];

        for(int i=0; i<26; i++){
            next[m][i] = -1;
        }

        for(int i=m; i>=1; i--){
            for(int j=0; j<26; j++){
                next[i-1][j] = next[i][j];
            }
            next[i-1][source.charAt(i)-'a'] = i;
        }

        int count = 0;

        int j = 0;
        /*
        axxxxbxxxx     abcabc
        we need to iterate through source again and again until we finish traversing all the
        chars in the abcabc string
        we stop iteration once we cannot see the current character in target in source
        */
        for(int i=0; i<target.length(); i++){
            int pos = next[j][target.charAt(i)-'a'];
            // System.out.println(pos + " j: " + j);
            if(pos != -1){
                j = pos;
            }else{
                if(j==0) return -1;
                count += 1;
                j=0;
                i--;
            }
        }

        return count+1;
    }
}