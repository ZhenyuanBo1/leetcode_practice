class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();

        while(n!=0){
            int digit = n % 10;
            list.add(digit);
            n = n /10;
        }

        int[] val = new int[list.size()]; //prepare the entire array that consists of all digits

        int index = 0;
        boolean found = false;

        for(int i=list.size()-1; i>=0; i--){
            val[index++] = list.get(i);
        }

        int targetPos = 0;

        for(int i=val.length-1; i-1>=0; i--){
            if(val[i] > val[i-1]){
                targetPos = i-1;
                found = true;
                break;
            }
        }

        if(!found) return -1;
        
        //this increase the value at the target pos index
        for(int i=val.length-1; i>=0; i--){
            if(val[i] > val[targetPos]){
                int temp = val[targetPos];
                val[targetPos] = val[i];
                val[i] = temp;
                break;
            }
        }

        //to get the smallest value, we sort the digit from targetPos+1 to the end in ascending order
        Arrays.sort(val, targetPos + 1, val.length);

        String res = "";

        for(int i=0; i<val.length; i++){
            res += val[i];
        }

        return Long.parseLong(res) > Integer.MAX_VALUE ? -1 : Integer.parseInt(res);


    }
}