class Solution {
    public String originalDigits(String s) {
        /*
        even numbers:
        Letter "z" is present only in "zero".
        Letter "w" is present only in "two".
        Letter "u" is present only in "four".
        Letter "x" is present only in "six".
        Letter "g" is present only in "eight".

        That is actually the key how to count 3s, 5s and 7s since some letters are present only in one odd and one even number (and all even numbers has already been counted) :

        Letter "h" is present only in "three" and "eight".
        Letter "f" is present only in "five" and "four".
        Letter "s" is present only in "seven" and "six".

        Now one needs to count 9s and 1s only, and the logic is basically the same :

        Letter "i" is present in "nine", "five", "six", and "eight".
        Letter "n" is present in "one", "seven", and "nine".
        */
        Map<Character, Integer> sMap = new HashMap<>();

        //build sMap
        for(int i=0; i<s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
        }

        String res = "";

        int[] rep = new int[10];

        rep[0] = sMap.getOrDefault('z', 0);
        rep[2] = sMap.getOrDefault('w', 0);
        rep[4] = sMap.getOrDefault('u', 0);
        rep[6] = sMap.getOrDefault('x', 0);
        rep[8] = sMap.getOrDefault('g', 0);

        rep[3] = sMap.getOrDefault('h', 0) - rep[8];
        rep[5] = sMap.getOrDefault('f', 0) - rep[4];
        rep[7] = sMap.getOrDefault('s', 0) - rep[6];

        rep[9] = sMap.getOrDefault('i', 0) - rep[5] - rep[6] - rep[8];
        rep[1] = sMap.getOrDefault('n', 0) - rep[7] - 2*rep[9];


        for(int i=0; i<10; i++){
            for(int j=0; j<rep[i]; j++){
                res += i;
            }
        }

        return res;

    }
}