class Solution {
    Map<Character, Integer> map = new HashMap<>();
    public int balancedString(String s) {
        //using binary search by value to look for the min substring len
        int strLen = s.length();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        boolean isBalanced = true;

        for(Character ch: map.keySet()){
            if(map.get(ch) != strLen/4) isBalanced = false;
        }

        if(isBalanced) return 0;

        int left = 1, right = strLen;

        //binary search by value template
        while(left < right){
            int mid = left + (right-left)/2;
            if(isValid(mid, s)){
                //上界下压:
                right = mid;
            }else{
                //下界上调:
                left = mid + 1;
            }
        }

        return left;


    }

    private boolean isValid(int mid, String s){
        //using sliding window algo
        Map<Character, Integer> map2 = new HashMap<>();
        //i is the right pointer
        for(int i=0; i<s.length(); i++){
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0)+1);
            if(i>=mid){
                int updatedVal = map2.get(s.charAt(i-mid))-1;
                map2.put(s.charAt(i-mid), updatedVal);
            }
            //check if freq of the char outside the window is less than n/4
            boolean flag = true;
            for(Character ch: map.keySet()){
                int freq = map.get(ch) - map2.getOrDefault(ch, 0);
                if(freq > s.length()/4){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        return false;
    }
}


//using Two Pointer
class Solution {
    Map<Character, Integer> map = new HashMap<>();
    public int balancedString(String s) {
        //using binary search by value to look for the min substring len
        int strLen = s.length();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        boolean isBalanced = true;

        for(Character ch: map.keySet()){
            if(map.get(ch) != strLen/4) isBalanced = false;
        }

        if(isBalanced) return 0;

        //using two pointers
        Map<Character, Integer> map2 = new HashMap<>();
        int min = Integer.MAX_VALUE;

        int j = 0;
        for(int i=0; i<strLen; i++){
            while(j<strLen && !isValid(map2, s)){
                //add character into the window
                map2.put(s.charAt(j), map2.getOrDefault(s.charAt(j), 0)+1);
                j++;
            }
            //range is [i, j)
            if(isValid(map2, s)){
                min = Math.min(min, j-i);
            }
            map2.put(s.charAt(i), map2.get(s.charAt(i))-1);
        }

        return min;

    }

    private boolean isValid(Map<Character, Integer> map2, String s){
        for(Character ch: map.keySet()){
            if(map.get(ch) - map2.getOrDefault(ch, 0) > s.length()/4) return false;
        }
        return true;
    }
}