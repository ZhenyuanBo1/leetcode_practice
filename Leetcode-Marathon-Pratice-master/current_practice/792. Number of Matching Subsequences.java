class Solution {
    private Map<Character, List<Integer>> map = new HashMap<>();
    public int numMatchingSubseq(String s, String[] words) {

        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.get(s.charAt(i)).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(s.charAt(i), list);
            }
        }

        int count = 0;

        for(String word: words){
            if(word.length() > s.length()) continue;
            if(check(word)){
                count += 1;
            }
        }

        return count;
    }

    private boolean check(String word){
        int prevIndex = -1;
        for(char ch: word.toCharArray()){
            if(!map.containsKey(ch)) return false;
            List<Integer> indexList = map.get(ch);
            //use binary search to look for the one that is greater than prevIndex
            int index = findIndex(indexList, prevIndex);
            if(index == -1) return false;
            prevIndex = index;
        }
        return true;
    }

    private int findIndex(List<Integer> indexList, int prevIndex){

        int left = 0, right = indexList.size()-1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(indexList.get(mid) > prevIndex){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        if(left == right && indexList.get(left) > prevIndex) return indexList.get(left);

        return -1;
    }
}


class Solution {
    //using state machine
    public int numMatchingSubseq(String s, String[] words) {
        //create a m x 26 matrix
        int m = s.length();
        s = "#" + s;
        int[][] next = new int[m+1][26];

        //populate next
        for(int i=0; i<26; i++){
            next[m][i] = -1;
        }

        for(int i=m; i>=1; i--){
            for(int j=0; j<26; j++){
                next[i-1][j] = next[i][j];
            }
            //往右看看到s.charAt(i-1)这个字符的位置即为i
            next[i-1][s.charAt(i)-'a'] = i;
        }

        int count = 0;

        for(String word: words){
            boolean flag = false;
            int i = 0;
            for(char ch: word.toCharArray()){
                //往右看看到这个ch的位置
                i = next[i][ch-'a'];
                if(i == -1){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                count += 1;
            }
        }

        return count;

    }
}