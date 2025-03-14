class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<asteroids.length; i++){
            int curr = asteroids[i];
            boolean push = true;
            //when we find out a pair that run in opposite direction, the asteroids will expode and keep checking other asteroids
            while(!st.isEmpty() && st.peek() > 0 && curr < 0){
                int val1 = Math.abs(st.peek());
                int val2 = Math.abs(curr);
                if(val1 > val2){
                    push = false;
                    break;
                }else if(val1 == val2){
                    push = false;
                    st.pop();
                    break;
                }else{
                    st.pop();
                }
            }
            if(push) st.push(curr);
        }
        
        System.out.println(st);

        if(st.size() == 0) return new int[]{};

        int[] res = new int[st.size()];

        int i=st.size()-1;

        while(!st.isEmpty()){
            res[i--] = st.pop();
        }

        return res;

    }
}