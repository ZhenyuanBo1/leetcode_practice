class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        int n = columnNumber;

        while( n != 0){
            n--;
            sb.insert(0, (char)('A' + n % 26));
            n = n/26;
        }   

        return sb.toString();
    }
}