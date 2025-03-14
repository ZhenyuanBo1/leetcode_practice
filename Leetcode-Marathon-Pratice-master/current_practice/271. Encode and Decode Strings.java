public class Codec {
    private List<Integer> strLenList = new ArrayList<>();
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String encodedStr = "";
        for(String str: strs){
            String s = encodeHelper(str);
            encodedStr += s;
            strLenList.add(s.length());
        }
        return encodedStr;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;
        for(int k=0; k<strLenList.size(); k++){
            int len = strLenList.get(k);
            list.add(s.substring(i, i+len));
            i=i+len;
        }
        for(int j=0; j<list.size(); j++){
            String str = list.get(j);
            String decodedStr = decodeHelper(str);
            list.set(j, decodedStr);
        }
        return list;
    }

    private String encodeHelper(String str){
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<str.length()){
            int count = 0;
            int j = i;
            while(j+1<str.length() && str.charAt(j) == str.charAt(j+1)){
                j++;
                count++;
            }
            sb.append(str.charAt(j));
            sb.append(count+1);
            i = j+1;
        }
        return sb.toString();
    }

    private String decodeHelper(String str){
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i+1<str.length()){
            char curr = str.charAt(i);
            int freq = Character.getNumericValue(str.charAt(i+1));
            int j = 0;
            while(j<freq){
                sb.append(curr);
                j++;
            }
            i+=2;
        }
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));