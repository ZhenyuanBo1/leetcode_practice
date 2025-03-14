class Solution {
    public int getSum(int a, int b) {
        Stack<Integer> st = new Stack<>();

        if(a*b<0){
            if(Math.abs(a) > Math.abs(b)){
                for(int i=0; i<Math.abs(a); i++){
                    st.push(0);
                }
                for(int j=0; j<Math.abs(b); j++){
                    st.pop();
                }
            }else{
                for(int i=0; i<Math.abs(b); i++){
                    st.push(0);
                }
                for(int j=0; j<Math.abs(a); j++){
                    st.pop();
                }
            }
        }else{
            for(int i=0; i<Math.abs(a); i++){
                st.push(0);
            }
            for(int j=0; j<Math.abs(b); j++){
                st.push(0);
            }
        }

        if(a*b < 0){
            return a < b ? st.size() : (-1) * st.size();
        }else if(a*b == 0){
            if(a == 0 && b < 0 || b==0 && a<0) return (-1)*st.size();
            if(a == 0 && b > 0 || b==0 && a>0) return st.size();
        }else if(a<0 && b<0){
            return (-1)*st.size();
        }
        
        return st.size();
    }
}