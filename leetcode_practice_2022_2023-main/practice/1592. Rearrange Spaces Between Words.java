class Solution {
    public String reorderSpaces(String text) {
        int slow = 0;
        int spaceCount = 0;
        List<String> res = new ArrayList<>();
        int charCount = 0;

        while(slow < text.length()){
            int fast = slow;
            while(fast<text.length() && text.charAt(fast) != ' '){
                fast++;
            }
            if(fast > slow){
                String substr = text.substring(slow, fast);
                res.add(substr);
                charCount += substr.length();
                slow = fast;
            }else{
                slow++;
            }
        }

        spaceCount = text.length() - charCount;

        if(spaceCount == 0) return text;

        int spaceAmount = res.size() > 1 ? spaceCount / (res.size()-1) : 0;

        String ans = "";

        for(int i=0; i<res.size(); i++){
            ans += res.get(i);
            if(spaceCount > 0){
                ans += generateSpace(i+1 == res.size() ? spaceCount : spaceAmount);
                spaceCount -= spaceAmount;
            }
        }

        return ans;

    }

    private String generateSpace(int count){
        char c = ' ';
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<count; i++){
            sb.append(c);
        }

        return sb.toString();
    }
}