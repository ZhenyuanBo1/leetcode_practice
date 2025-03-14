class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for(int i=1; i<s.length(); i++){
            char ch = s.charAt(i);
            char pair = ' ';
            if(!stack.isEmpty()) pair = stack.peek();
            if(ch == ']'){
                if(pair == '[') stack.pop();
                else return false;
            }else if(ch == ')'){
                if(pair == '(') stack.pop();
                else return false;
            }else if(ch == '}'){
                if(pair == '{') stack.pop();
                else return false;
            }else if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
        }

        if(!stack.isEmpty()) return false;

        return true;
    }
}