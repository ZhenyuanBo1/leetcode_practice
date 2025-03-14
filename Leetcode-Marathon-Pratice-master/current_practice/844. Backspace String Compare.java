class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!='#'){
                st1.push(s.charAt(i));
            }else{
                if(!st1.isEmpty()) st1.pop();
            }
        }

        for(int j=0; j<t.length(); j++){
            if(t.charAt(j)!='#'){
                st2.push(t.charAt(j));
            }else{
                if(!st2.isEmpty()) st2.pop();
            }
        }

        StringBuilder s1 = new StringBuilder();
        StringBuilder t1 = new StringBuilder();

        while(!st1.isEmpty()){
            s1.insert(0, st1.peek());
            st1.pop();
        }

        while(!st2.isEmpty()){
            t1.insert(0, st2.peek());
            st2.pop();
        }

        return s1.toString().equals(t1.toString());
    }
}