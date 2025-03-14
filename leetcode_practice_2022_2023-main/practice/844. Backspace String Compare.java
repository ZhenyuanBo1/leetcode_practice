class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '#' && !st1.isEmpty()){
                st1.pop();
            }else{
                if(s.charAt(i) != '#') st1.push(s.charAt(i));
            }
        }

        for(int i=0; i<t.length(); i++){
            if(t.charAt(i) == '#' && !st2.isEmpty()){
                st2.pop();
            }else{
                if(t.charAt(i) != '#') st2.push(t.charAt(i));
            }
        }

        StringBuilder sb1 = new StringBuilder();

        while(!st1.isEmpty()){
            sb1.insert(0, st1.pop());
        }

        StringBuilder sb2 = new StringBuilder();

        while(!st2.isEmpty()){
            sb2.insert(0, st2.pop());
        }


        return sb1.toString().equals(sb2.toString());
    }
}