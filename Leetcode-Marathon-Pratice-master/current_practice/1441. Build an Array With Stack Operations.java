class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        List<Integer> targetList = new ArrayList<>();

        for(int i=0; i<target.length; i++){
            targetList.add(target[i]);
        }


        for(int i=1; i<=n; i++){
            if(targetList.isEmpty()) break;
            if(targetList.contains(i)){
                ans.add("Push");
                targetList.remove(0);
            }else{
                ans.add("Push");
                ans.add("Pop");
            }
        }

        return ans;
    }
}