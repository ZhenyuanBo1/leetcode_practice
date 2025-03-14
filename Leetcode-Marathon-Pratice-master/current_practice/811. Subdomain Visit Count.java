class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(String domains: cpdomains){
            String domainPart = domains.split(" ")[1];
            String[] subdomains = domainPart.split("\\.");

            int count = Integer.parseInt(domains.split(" ")[0]);
            String[] allDomains = getAllDomains(subdomains);

            for(String dom: allDomains){
                map.put(dom, map.getOrDefault(dom, 0) + count);
            }
        }

        for(String key: map.keySet()){
            String countPairedDomain = map.get(key) + " " + key;
            res.add(countPairedDomain);
        }

        return res;
    }
    private String[] getAllDomains(String[] subdomains){
        List<String> list = new ArrayList<>();
        for(int i=subdomains.length-1; i>=0; i--){
            if(list.isEmpty()){
                list.add(subdomains[i]);
            }else{
                String parentDomain = list.get(list.size()-1);
                String currDomain = subdomains[i] + "." + parentDomain;
                list.add(currDomain);
            }
        }

        return list.toArray(new String[list.size()]);
    }
}