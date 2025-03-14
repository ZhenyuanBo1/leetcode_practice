class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int numOccur = 0;
        int numCut = s.length()-k;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == letter) numOccur += 1;
        }

        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if((st.isEmpty() || st.peek()<=curr) && numCut>0){
                st.push(curr);
                if(curr == letter){
                    numOccur--;
                    repetition--;
                }
            }else{
                System.out.println(st);
                while(!st.isEmpty() && st.peek()>curr && numCut>0){
                    if(st.peek() == letter && numOccur > repetition){
                        st.pop();
                        System.out.println(st);
                        repetition++;
                        numCut--;
                    }else if(st.peek() != letter){
                        st.pop();
                        numCut--;
                    }else
                }
                st.push(curr);
                System.out.println(st);
                if(curr == letter){
                    numOccur--;
                    repetition--;
                }
                System.out.println(st);
            }
        }


        while(!st.isEmpty() && st.size()>k){
            st.pop();
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.insert(0, st.pop());
        }

        return sb.toString();
    }
}

"hjjhhhmhhwhz"
6
"h"
5

"aaabbbcccddd"
3
"b"
2