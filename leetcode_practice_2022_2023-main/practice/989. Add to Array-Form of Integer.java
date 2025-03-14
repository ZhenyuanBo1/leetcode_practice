class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> num2 = new ArrayList<>();

        while(k != 0){
            int rem = k % 10;
            k = k/10;
            num2.add(0, rem);
        }

        List<Integer> res = new ArrayList<>();

        int i = num2.length-1;
        int j = num.length-1;
        int carry = 0;

        while(i>=0 && j>=0){
            int sum = num2.get(i) + num[j] + carry;
            int remainder = sum % 10;
            res.add(0, remainder);
            carry = sum / 10;
            i--;
            j--;
        }

        while(j>=0){
            int sum = num[j] + carry;
            int remainder = sum % 10;
            res.add(0, remainder);
            carry = sum / 10;
            j--;
        }

        while(i>=0){
            int sum = num2.get(i) + carry;
            int remainder = sum % 10;
            res.add(0, remainder);
            carry = sum / 10;
            i--;
        }

        if(carry > 0){
            res.add(0, carry);
        }

        return res;
    }
}