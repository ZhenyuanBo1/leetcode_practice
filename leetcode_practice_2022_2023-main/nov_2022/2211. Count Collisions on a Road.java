class Solution {
    public int countCollisions(String directions) {
        Stack<Character> st = new Stack<>();
        char[] arr = directions.toCharArray();

        int count = 0;

        for(int i=0; i<arr.length; i++){
            char dir = arr[i];
            boolean push = true;
            while(!st.isEmpty() && st.peek() != dir){
                char prevDir = st.peek();
                if(prevDir == 'R' && dir == 'L'){
                    count += 2;
                    st.pop();
                    dir = 'S';
                }else if(prevDir == 'R' && dir == 'S'){
                    count += 1;
                    st.pop();
                }else if(prevDir == 'S' && dir == 'L'){
                    count += 1;
                    dir = 'S';
                    break;
                }else{
                    break;
                }
            }

            if(push) st.push(dir);
        }

        return count;
    }
}