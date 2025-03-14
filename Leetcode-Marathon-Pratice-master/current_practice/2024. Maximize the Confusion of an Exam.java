class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max = 0;
        int l=0, r=0, flip=0;
        char[] arr = answerKey.toCharArray();

        //we split into two scenarios, where all characters are either F or T
        while(l<arr.length){
            //window size is not fixed
            //flip F to T
            while(r<arr.length && (arr[r] == 'T' || flip<k)){
                if(ar[r] != 'T'){
                    flip++;
                }
                r++;
            }
            max = Math.max(max, r-l);
            if(arr[l] == 'F') flip--;
            l++;
        }

        flip = 0;
        r=0;
        l=0;

        while(l<arr.length){
            //flip T to F
            while(r<arr.length && (arr[r] == 'F' || flip<k)){
                if(arr[r] != 'F'){
                    flip++;
                }
                r++;
            }
            max = Math.max(max, r-l);
            if(arr[l] == 'T') flip--;
            l++;
        }

        return max;
    }
}