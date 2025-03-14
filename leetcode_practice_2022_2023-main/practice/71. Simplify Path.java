class Solution {
    public String simplifyPath(String path) {
        //whenever we encounter a scenario where we need to go back to previous item, we usually use stack 
        Stack<String> st = new Stack<>();
        String[] arr = path.split("/");

        for(int i=0; i<arr.length; i++){
            String curr = arr[i];
            if(curr.equals("") || curr.equals(".")) continue;
            if(curr.equals("..")){
                if(!st.isEmpty()) st.pop();
            }else{
                st.push(curr);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");

        while(!st.isEmpty()){
            String dir = st.pop();
            sb.insert(1, dir + "/");
        }

        String res = sb.toString();

        return res.length() > 1 ? res.substring(0, res.length()-1) : res;

    }
}