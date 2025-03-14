class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1arr = version1.split("\\.");
        String[] version2arr = version2.split("\\.");

        List<Integer> version1list = new ArrayList<>();

        for(String s: version1arr){
            version1list.add(Integer.parseInt(s));
        }

        List<Integer> version2list = new ArrayList<>();

        for(String s: version2arr){
            version2list.add(Integer.parseInt(s));
        }

        while(version1list.size() > version2list.size()){
            version2list.add(0);
        }

        while(version2list.size() > version1list.size()){
            version1list.add(0);
        }

        int i = 0;

        while(i<version1list.size() && i<version2list.size()){
            int val1 = version1list.get(i);
            int val2 = version2list.get(i);
            if(val1 < val2) return -1;
            else if(val1 > val2) return 1;
            i++;
        }

        return 0;
    }
}