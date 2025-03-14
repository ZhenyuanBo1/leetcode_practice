class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);

        int sum = 0, flag = 0;

        for(int i=1; i<words.length; i++){
            String curr = words[i];
            String reverse = "" + words[i].charAt(1) + words[i].charAt(0);
            if(map.containsKey(reverse)){
                sum += 4;
                int updatedVal = map.get(reverse)-1;
                if(updatedVal == 0){
                    map.remove(reverse);
                }else{
                    map.put(reverse, map.get(reverse)-1);
                }
            }else{
                map.put(curr, map.getOrDefault(curr, 0)+1);
            }
        }


        //nothing to paired with
        for(String key: map.keySet()){
            if(isPalindrome(key)){
                flag = 2;
            }
        }

        return sum + flag;


    }
    private boolean isPalindrome(String word){
        return word.charAt(0) == word.charAt(1);
    }
}



