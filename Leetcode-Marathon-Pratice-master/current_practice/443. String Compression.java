class Solution {
    public int compress(char[] chars) {
        String s = "";

        int j=0;

        for(int i=0; i<chars.length;){
            while(j+1<chars.length && chars[j]==chars[j+1]){
                j++;
            }
            int count = j-i+1;
            if(count == 1){
                s+=chars[i];
            }else{
                s+=chars[i];
                s+=count;
            }
            j++;
            i = j;
        }

        char[] sArr = s.toCharArray();

        for(int i=0; i<sArr.length; i++){
            chars[i] = sArr[i];
        }

        return sArr.length;
    }
}

class Solution {
    public int compress(char[] chars) {
        int i=0, j=0;

        StringBuilder sb = new StringBuilder();

        while(i<chars.length){
            int count = 0;
            while(j+1<chars.length && chars[j] == chars[j+1]){
                j++;
                count+=1;
            }
            sb.append(chars[j]);
            if(count + 1 > 1){
                count = count + 1;
                System.out.println(count);
                sb.append(count);
            }
            j = j+1;
            i = j;
        }

        String res = sb.toString();

        for(int k=0; k<res.length(); k++){
            chars[k] = res.charAt(k);
        }

        return res.length();
    }
}