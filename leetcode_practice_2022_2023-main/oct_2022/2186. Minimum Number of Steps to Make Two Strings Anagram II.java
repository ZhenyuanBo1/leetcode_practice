class Solution {
    Map<Character, Integer> smap = new HashMap<>();
    Map<Character, Integer> tmap = new HashMap<>();
    public int minSteps(String s, String t) {
        for(int i=0; i<s.length(); i++){
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int j=0; j<t.length(); j++){
            tmap.put(t.charAt(j), tmap.getOrDefault(t.charAt(j), 0) + 1);
        }

        //check t in s
        int missingCharT = 0;
        for(Character key: tmap.keySet()){
            if(!smap.containsKey(key)){
                missingCharT += tmap.get(key);
            }else{
                if(smap.get(key) < tmap.get(key)){
                    missingCharT += tmap.get(key) - smap.get(key);
                }
            }
        }

        //check s in t
        int missingCharS = 0;
        for(Character key: smap.keySet()){
            if(!tmap.containsKey(key)){
                missingCharS += smap.get(key);
            }else{
                if(tmap.get(key) < smap.get(key)){
                    missingCharS += smap.get(key) - tmap.get(key);
                }
            }
        }

        return missingCharS + missingCharT;
    }

}

