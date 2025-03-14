class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        st.push("/");
        for(int i=0; i<path.length();){
            char c = path.charAt(i);
            if(c == '/'){
                int k = i;
                while(k<path.length() && path.charAt(k) == '/'){
                    k++;
                }
                i=k;
            }else{
                //two pointers to get the dir name
                int j = i;
                String newDir = "";
                while(j<path.length() && path.charAt(j) != '/'){
                    newDir += path.charAt(j++);
                }
                if(newDir.equals("..")){
                    if(st.size() > 1) st.pop();
                }else if(!newDir.equals(".")){
                    st.push(newDir);
                }
                i=j;
            }
        }

        StringBuilder newPath = new StringBuilder();

        while(st.size()>1){
            newPath.insert(0, st.pop()+"/");
        }

        String res = newPath.toString();
        res = "/" + res;
        if(res.length()>1) res = res.substring(0, res.length()-1);
        
        return res;
    }
}