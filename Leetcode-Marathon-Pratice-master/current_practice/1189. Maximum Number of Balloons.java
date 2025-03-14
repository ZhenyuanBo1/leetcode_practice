class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        String target = "balloon";
        char[] textArr = text.toCharArray();

        for(int i=0; i<textArr.length; i++){
            if(target.indexOf(textArr[i]) > -1){
                map.put(textArr[i], map.getOrDefault(textArr[i], 0)+1);
            }
        }


        int[] occurence = new int[target.length()];

        for(int j=0; j<target.length(); j++){
            if(!map.containsKey(target.charAt(j))) return 0;

            if(target.charAt(j) == 'b' || target.charAt(j) == 'a' || target.charAt(j) == 'n'){
                occurence[j] = map.get(target.charAt(j));
            }else{

                int numberOccur = map.get(target.charAt(j));
                occurence[j] = numberOccur / 2;
            }
        }

        int min = Integer.MAX_VALUE;

        for(int k=0; k<occurence.length; k++){
            if(occurence[k] < min){
                min = occurence[k];
            }
        }

        return min;


    }
}