class Solution {
    public int maxLength(List<String> arr) {
        List<String> res = new ArrayList<>();

        for(int i=1; i<=arr.size(); i++){
            String curr = "";
            backtrack(curr, res, i, arr, 0);
        }

        int max = 0;
        for(String s: res){
            max = Math.max(max, s.length());
        }

        return max;

    }

    private void backtrack(String curr, List<String> res , int count, List<String> arr, int index){
        if(count == 0){
            res.add(curr);
            return;
        }

        for(int i = index; i<arr.size(); i++){
            String str = arr.get(i);
            if(hasUniqueChar(curr + str)){
                backtrack(curr + str, res, count - 1, arr, i + 1);
            }
        }
    }

    private boolean hasUniqueChar(String str){
        char[] arr = str.toCharArray();

        Set<Character> set = new HashSet<>();

        for(int i=0; i<arr.length; i++){
            if(!set.add(arr[i])) return false;
        }

        return true;
    }
}