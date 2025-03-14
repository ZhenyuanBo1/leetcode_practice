class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";

        Stack<Character> s = new Stack<>();

        //this makes sure that all the digits are in the ascending order
        for(int i=0; i<num.length(); i++){
            char curr = num.charAt(i);
            if(s.isEmpty() || s.peek()<curr){
                s.push(curr);
            }else{
                while(!s.isEmpty() && s.peek()>curr && k>0){
                    s.pop();
                    k--;
                }
                s.push(curr);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!s.isEmpty()){
            sb.insert(0, s.pop());
        }

        String res = sb.toString();

        //if k is not reduced to 0, meaning some digits from the end can be removed to reduce the value
        if(k>0){
            int endIndex = res.length() - k;
            res = res.substring(0, endIndex);
        }

        //remove leading zero
        int startIndex = 0;
        while(startIndex < res.length()){
            if(res.charAt(startIndex) == '0'){
                startIndex++;
            }else{
                break;
            }
        }

        return startIndex == res.length() ? "0" : res.substring(startIndex);

    }
}