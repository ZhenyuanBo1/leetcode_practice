class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> indexStack = new Stack<>();
        List<Character> sList = new ArrayList<>();

        for(char ch: s.toCharArray()){
            sList.add(ch);
        }

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                indexStack.push(i);
            }else if(s.charAt(i) == ')'){
                if(!indexStack.isEmpty() && s.charAt(indexStack.peek()) == '('){
                    indexStack.pop();
                }else{
                    indexStack.push(i);
                }
            }
        }

        while(!indexStack.isEmpty()){
            int indexToRemove = indexStack.peek();
            sList.remove(indexToRemove);
            indexStack.pop();
        }


        StringBuilder sb = new StringBuilder();

        for(Character c: sList){
            sb.append(c);
        }

        return sb.toString();
    }
}