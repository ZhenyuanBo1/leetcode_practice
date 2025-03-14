class Solution {
    public int sumSubarrayMins(int[] arr) {
        /*
        1. locate the index of the prev smaller and next smaller for a given index
        2. calculate the number of subarrays with the info given from step 1
        3. calculate the sum
        */
        int[] nextSmaller = new int[arr.length];
        int[] prevSmaller = new int[arr.length];

        Arrays.fill(nextSmaller, arr.length);
        Arrays.fill(prevSmaller, -1);

        Stack<Integer> st1 = new Stack<>();

        for(int i=0; i<arr.length; i++){
            if(st1.isEmpty() || arr[st1.peek()] <= arr[i]){
                st1.push(i);
            }else{
                while(!st1.isEmpty() && arr[st1.peek()] > arr[i]){
                    nextSmaller[st1.peek()] = i;
                    st1.pop();
                }
                st1.push(i);
            }
        }

        Stack<Integer> st2 = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            if(st2.isEmpty() || arr[st2.peek()] < arr[i]){
                st2.push(i);
            }else{
                while(!st2.isEmpty() && arr[st2.peek()] >= arr[i]){
                    prevSmaller[st2.peek()] = i;
                    st2.pop();
                }
                st2.push(i);
            }
        }

        long sum = 0;
        int M = 1000000000 + 7;

        for(int i=0; i<arr.length; i++){
            long num = (long)arr[i] * (i-prevSmaller[i]) % M * (nextSmaller[i] - i) % M;
            sum = (sum + num) % M;
        }

        return (int)sum;

    }
}