class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        //use state machine
        int n = s.length();
        int[] lastPos = new int[n];
        int[] nextPos = new int[n];

        int temp = -1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '|'){
                temp = i;
            }
            lastPos[i] = temp;
        }

        temp = n;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '|'){
                temp = i;
            }
            nextPos[i] = temp;
        }

        temp = 0;
        int[] presum = new int[n];
        //build presum to calculate number of plates up to a point
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '*'){
                presum[i] = temp + 1;
                temp += 1;
            }else{
                presum[i] = temp;
            }
        }

        int[] res = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int newStart = nextPos[start];
            int newEnd = lastPos[end];
            if(newStart>=start && newEnd<=end && newStart<=newEnd){
                res[i] = presum[newEnd] - presum[newStart];
            }
        }

        return res;

    }
}