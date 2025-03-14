class Solution {
    public int minAddToMakeValid(String s) {
        //using greedy count method
        int count = 0; //temporarily unmatched left bracket
        int unmatched = 0; //temporarily unmatched right bracket

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
            }else if(s.charAt(i) == ')'){
                count--;
            }
            if(count<0){
                unmatched += 1;
                count = 0;
            }
        }

        return unmatched + count;
    }
}

class Solution {
    public int minAddToMakeValid(String s) {
        //using greedy count method
        int count=0;
        int ret = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
            }else{
                count--;
            }
            if(count < 0){
                //补一个左bracket
                ret++;
                count=0;
            }
        }

        return ret+=count;
    }
}