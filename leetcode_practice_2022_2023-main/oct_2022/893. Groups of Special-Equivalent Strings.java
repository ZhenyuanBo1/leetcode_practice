class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> res = new HashSet<>();

        for(int i=0; i<words.length; i++){
            String word = words[i];
            String convertedWord = convertStr(word);
            res.add(convertedWord);
        }

        return res.size();
    }

    private String convertStr(String word){
        String evenRes = "", oddRes = "";

        for(int i=0; i<word.length(); i++){
            if(i%2 == 0) evenRes += word.charAt(i);
            else if(i%2 == 1) oddRes += word.charAt(i);
        }

        char[] ordereEvendArr = evenRes.toCharArray();
        char[] orderedOddArr = oddRes.toCharArray();

        Arrays.sort(ordereEvendArr);
        Arrays.sort(orderedOddArr);

        String orderedEvenRes = "";
        String orderedOddRes = "";

        for(int i=0; i<ordereEvendArr.length; i++){
            orderedEvenRes += ordereEvendArr[i];
        }

        for(int i=0; i<orderedOddArr.length; i++){
            orderedOddRes += orderedOddArr[i];
        }

        String res = orderedEvenRes + orderedOddRes;

        return res;
    }
}