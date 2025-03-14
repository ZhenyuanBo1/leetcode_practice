class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> digitList = new ArrayList<>();

        while(n!=0){
            int rem = n % 10;
            digitList.add(0, rem);
            n = n/10;
        }

        int[] digitArr = new int[digitList.size()];

        for(int i=0; i<digitList.size(); i++){
            digitArr[i] = digitList.get(i);
        }

        boolean found = false;

        int targetPos = 0;

        for(int i=digitArr.length-1; i-1>=0; i--){
            if(digitArr[i] > digitArr[i-1]){
                //find the digit that needs to be increased
                targetPos = i-1;
                found = true;
                break;
            }
        }

        if(!found){
            return -1;
        }

        for(int j=digitArr.length-1; j>targetPos; j--){
            if(digitArr[j]>digitArr[targetPos]){
                int temp = digitArr[targetPos];
                digitArr[targetPos] = digitArr[j];
                digitArr[j] = temp;
                break;
            }
        }

        Arrays.sort(digitArr, targetPos+1, digitArr.length);

        String val = "";

        for(int k=0; k<digitArr.length; k++){
            val += digitArr[k];
        }

        return Long.parseLong(val) > Integer.MAX_VALUE ? -1 : Integer.parseInt(val);


    }
}