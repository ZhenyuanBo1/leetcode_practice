class Solution {
    public boolean rotateString(String s, String goal) {
        for(int i=0; i<s.length(); i++){
            String newstr = s.substring(i+1) + s.substring(0, i+1);
            if(newstr.equals(goal)) return true;
        }
        return false;
    }
}

class Solution {
    //all rotations will be part of A + A
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}