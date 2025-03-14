class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        //use state machine to find out subsequence
        Collections.sort(dictionary); //sort the string list in lexicographically

        //this is the template that can be used to test if a str is a subsequence of another
        int m = s.length();
        s = "#" + s;
        int[][] next = new int[m+1][26];

        for(int i=0; i<26; i++){
            next[m][i] = -1;
        }

        for(int i=m; i>=1; i--){
            for(int j=0; j<26; j++){
                next[i-1][j] = next[i][j];
            }
            next[i-1][s.charAt(i)-'a'] = i;
        }

        String res = "";
        for(String str: dictionary){
            int i = 0;
            boolean flag = false;
            for(char ch: str.toCharArray()){
                i = next[i][ch-'a'];
                if(i == -1){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                if(str.length() > res.length()){
                    res = str;
                }
            }
        }

        return res;
    }
}