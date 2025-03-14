class Solution {
    public String longestDiverseString(int a, int b, int c) {
        //check the most freq char and then the least freq char
        char[] arr = new char[]{'a', 'b', 'c'};
        PriorityQueue<int[]> heap = new PriorityQueue<>((x1, x2)->(x2[0] - x1[0]));
        heap.add(new int[]{a, 0});
        heap.add(new int[]{b, 1});
        heap.add(new int[]{c, 2});

        String str = "";

        while(!heap.isEmpty()){

            //get the most freq character
            int[] maxFreq = heap.remove();

            if(str.length() == 0 || str.charAt(str.length()-1) != arr[maxFreq[1]]){
                int count = Math.min(2, maxFreq[0]);
                for(int i = 0; i<count; i++){
                    str+=arr[maxFreq[1]];
                }
                int freq = maxFreq[0] - count;
                if(freq > 0) heap.add(new int[]{freq, maxFreq[1]});
            }else{
                int[] secMaxFreq = heap.remove();
                str += arr[secMaxFreq[1]];
                int freq = secMaxFreq[0];
                freq -= 1;
                if(freq > 0) heap.add(new int[]{freq, secMaxFreq[1]});
            }
        }

        return str;
    }
}>