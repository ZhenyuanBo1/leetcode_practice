import java.math.BigInteger;
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        //nums1: [3,4,6,5] nums2: [9,1,2,5,8,3]
        int totalLen = nums1.length + nums2.length;
        int totalCut = totalLen - k;
        BigInteger mx = new BigInteger("-1");
        int[] res = new int[k];

        for(int j=0; j<=totalCut; j++){

            int nums1Cut = j, nums2Cut = totalCut-j;

            if(nums1Cut<=nums1.length && nums2Cut<=nums2.length){

                // System.out.println("nums1Cut: " + nums1Cut + " nums2Cut: " + nums2Cut);

                Stack<Integer> st1 = new Stack<>();
                Stack<Integer> st2 = new Stack<>();

                for(int i=0; i<nums1.length; i++){
                    if(st1.isEmpty() || st1.peek()>nums1[i]){
                        st1.push(nums1[i]);
                    }else{
                        while(!st1.isEmpty() && st1.peek()<nums1[i] && nums1Cut>0){
                            st1.pop();
                            nums1Cut--;
                        }
                        st1.push(nums1[i]);
                    }
                }

                for(int i=0; i<nums2.length; i++){
                    if(st2.isEmpty() || st2.peek()>nums2[i]){
                        st2.push(nums2[i]);
                    }else{
                        while(!st2.isEmpty() && st2.peek()<nums2[i] && nums2Cut>0){
                            st2.pop();
                            nums2Cut--;
                        }
                        st2.push(nums2[i]);
                    }
                }

                // System.out.println(st1);
                // System.out.println(st2);

                List<Integer> temp = new ArrayList<>();
                List<Integer> newNums1 = new ArrayList<>();
                List<Integer> newNums2 = new ArrayList<>();

                while(!st1.isEmpty()){
                    newNums1.add(0, st1.pop());
                }

                while(!st2.isEmpty()){
                    newNums2.add(0, st2.pop());
                }

                BigInteger curr = merge(newNums1, newNums2, k);

                // System.out.println(curr);

                if(curr.compareTo(mx)>0){
                    mx = curr;
                }
            }

        }

        String mxStr = mx.toString();

        for(int i=0; i<res.length; i++){
            res[i] = mxStr.charAt(i) - '0';
        }


        return res;
    }

    private BigInteger merge(List<Integer> nums1List, List<Integer> nums2List, int k){
        StringBuilder num = new StringBuilder();
        int p1 = 0, p2 = 0;
        while(p1<nums1List.size() || p2<nums2List.size()){
            if(gt(nums1List, nums2List, p1, p2)){
                num.append(nums1List.get(p1++));
            }else{
                num.append(nums2List.get(p2++));
            }
        }
        String res = num.toString();
        if(res.length()>=k) res = res.substring(0, k);
        return new BigInteger(res);
    }

    private boolean gt(List<Integer> a1, List<Integer> a2, int i, int j){
        //check which list is greater
        while(i<a1.size() && j<a2.size()){
            if(a1.get(i) > a2.get(j)){
                return true;
            }else if(a1.get(i) < a2.get(j)){
                return false;
            }else{
                i++;
                j++;
            }
        }
        if(i>=a1.size()){
            return false;
        }
        return true;
    }
}