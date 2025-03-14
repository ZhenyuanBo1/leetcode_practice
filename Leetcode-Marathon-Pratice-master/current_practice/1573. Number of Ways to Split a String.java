class Solution {
    public int numWays(String s) {
        //count number of ones
        long count = 0;
        long n = s.length();
        int M = 1000000000 + 7;

        Map<Long, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                count++;
                map.put(count, i);
            }
        }

        if(count % 3 != 0) return 0;
        if(count == 0) return (int)((n-1)*(n-2)/2%M);


        long val1 = map.get(count/3+1) - map.get(count/3);
        long val2 = map.get(count/3*2+1) - map.get(count/3*2);

        return (int)(val1 * val2 % M);

    }
}