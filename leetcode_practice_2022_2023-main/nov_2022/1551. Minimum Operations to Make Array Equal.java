class Solution {
    public int minOperations(int n) {
        List<Integer> list = new ArrayList<>();

        int init = 1;
        for(int i=0; i<n; i++){
            list.add(init);
            init += 2;
        }

        int sum = 0;

        for(int i=0; i<list.size(); i++){
            sum += list.get(i);
        }

        int targetVal = sum / n;

        int res = 0;

        for(int i=0; i<list.size(); i++){
            if(list.get(i) < targetVal){
                res += targetVal - list.get(i);
            }
        }

        return res;
    }
}