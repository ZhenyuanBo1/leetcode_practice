class Solution {
    public String validIPAddress(String queryIP) {
        String res = "";
        if(queryIP.indexOf(".") > -1){
            if(isIPv4(queryIP)){
                res = "IPv4";
            }
        }else if(queryIP.indexOf(":") > -1){
            if(isIPv6(queryIP)){
                res = "IPv6";
            }
        }

        if(res.equals("")) return "Neither";
        return res;
    }
    private boolean isIPv4(String ip){
        String[] arr = ip.split("\\.", -1);
        
        if(arr.length > 4 || arr.length < 4) return false;
        for(int i=0; i<arr.length; i++){
            String curr = arr[i];
            
            if(curr.length() == 0) return false;
            
            //check if there is any leading 0
            if(curr.charAt(0) == '0' && curr.length() > 1) return false;

            for(int j=0; j<curr.length(); j++){
                if(!Character.isDigit(curr.charAt(j))) return false;
            }

            //check if value is from 0 to 255
            if(curr.length() > 3) return false;
            
            if(Integer.parseInt(curr) > 255) return false;
            
        }
        return true;
    }
    private boolean isIPv6(String ip){
        String[] arr = ip.split(":", -1);

        if(arr.length > 8 || arr.length < 8) return false;
        
        String candidates = "0123456789abcdefABCDEF";
        for(int i=0; i<arr.length; i++){
            String curr = arr[i];
            
            if(curr.length() > 4 || curr.length() == 0) return false;
            
            for(int j=0; j<curr.length(); j++){
                if(!Character.isLetterOrDigit(curr.charAt(j)) || candidates.indexOf(curr.charAt(j)) == -1) return false;
                
            }
        }
        return true;
    }
}