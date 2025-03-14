class Solution {
    public boolean isHappy(int n) {
        //we need to detect if there is a cycle, if so it is not a happy number
        int sum = 0;

        Set<Integer> visited = new HashSet<>();
        visited.add(n);

        while(true){
            System.out.println("n: " + n);
            while(n!=0){
                int rem = n % 10;
                sum += rem * rem;
                n = n / 10;
            }
            if(sum == 1){
                return true;
            }

            if(!visited.add(sum)) break;

            n = sum;
            sum = 0;
        }

        return false;
    }
}