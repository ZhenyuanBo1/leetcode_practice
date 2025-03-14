class Solution {
    public int countVowelSubstrings(String word) {

        int count = 0;
        int left = 0;

        Set<Character> set = new HashSet<>();

        while(left + 4 < word.length()){
            int right = left;
            set.clear();
            while(right < word.length()){
                char ch = word.charAt(right);
                if(ch == 'a' || ch == 'e' || ch =='i' || ch == 'o' || ch == 'u'){
                    set.add(ch);
                    if(set.size() == 5){
                        count += 1;
                    }
                    right++;
                }else{
                    break;
                }
            }
            left++;
        }

    }
}