class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Boolean> usedMap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0)+1);
            usedMap.put(s.charAt(i), false);
        }

        Stack<Character> cstack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(usedMap.get(curr)){
                countMap.put(curr, countMap.get(curr)-1);
            }else if(cstack.isEmpty() || cstack.peek() < curr){
                cstack.push(curr);
                countMap.put(curr, countMap.get(s.charAt(i))-1);
                usedMap.put(curr, true);
            }else{
                while(!cstack.isEmpty() && cstack.peek()>=s.charAt(i) && countMap.get(cstack.peek())>0){
                    //if the previous character is greater than the curr char, we move the curr char forward to get smallest in lexicographical order
                    usedMap.put(curr, false);
                    cstack.pop();
                }
                cstack.push(s.charAt(i));
                countMap.put(s.charAt(i), countMap.get(s.charAt(i))-1);
                usedMap.put(s.charAt(i), true);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!cstack.isEmpty()){
            sb.insert(0, cstack.pop());
        }

        return sb.toString();
    }
}