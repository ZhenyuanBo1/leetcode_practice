class Solution{
    public int[] solution(int N){
        int[] res = new int[N];

        int i=0;
        int negStart = -1;
        while(i<N/2){
            res[i++] = negStart;
            negStart -= 1;
        }

        int posStart = -negStart;
        while(i<N){
            res[i++] = posStart;
            posStart -= 1;
        }

        return res;
    }
}

//task 3:
class Solution{
    public int solution(String S){
        char[] arr = S.toCharArray();

        int val = 0;

        int count=0;

        for(int i=arr.length-1; i>=0; i--){
            int curr = Character.getNumericValue(arr[i]);
            if(curr == 1){
                val += curr * Math.pow(2, count);
            }
            count++;
        }

        int stepCount = 0;

        while(val != 0){
            if(val % 2 == 0){
                val = val / 2;
            }else{
                val = val - 1;
            }
            stepCount++;
        }

        return stepCount;
    }
}

//task 1:

class Solution{
    public int solution(int[] A){

        Arrays.sort(A);

        //look for the middle value and use that as reference
        int mid = A[A/2];

        int count = 0;

        for(int i=0; i<A.length; i++){
            count += Math.abs(A[i] - mid);
        }

        //for even array, there are two references, we need to find the minimum one
        if(A.length % 2 == 0 ){
            int count1 = 0;
            mid = A[A/2-1];
            for(int i=0; i<A.length; i++){
                count1 += Math.abs(A[i] - mid);
            }
        }

        int minStep = Math.min(count, count1);

        return minStep;
    }
}

