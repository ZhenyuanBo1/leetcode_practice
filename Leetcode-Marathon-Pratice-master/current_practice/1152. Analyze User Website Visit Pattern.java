class Solution {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<List<String>>> userVisit = new HashMap<>();

        for(int i=0; i<username.length; i++){
            String user = username[i];
            String web = website[i];
            int time = timestamp[i];
            List<String> visit = new ArrayList<>();
            visit.add(web);
            visit.add(Integer.toString(time));
            if(!userVisit.containsKey(user)){
                List<List<String>> visits = new ArrayList<>();
                visits.add(visit);
                userVisit.put(user, visits);
            }else{
                userVisit.get(user).add(visit);
            }
        }

        for(String user: userVisit.keySet()){
            List<List<String>> visits = userVisit.get(user);
            Collections.sort(visits, new Comparator<List<String>>(){
                public int compare(List<String> a, List<String> b){
                    int t1 = Integer.parseInt(a.get(1));
                    int t2 = Integer.parseInt(b.get(1));
                    return t1-t2;
                }
            });
        }

        //for sorting lexicographically
        TreeMap<String, Set<String>> res = new TreeMap<>();

        for(String user: userVisit.keySet()){
            List<List<String>> visits = userVisit.get(user);
            if(visits.size()>=3){
                for(int i=0; i<visits.size(); i++){
                    for(int j=i+1; j<visits.size(); j++){
                        for(int k=j+1; k<visits.size(); k++){
                            String site = visits.get(i).get(0) + "," + visits.get(j).get(0) + "," + visits.get(k).get(0);
                            if(res.containsKey(site)){
                                res.get(site).add(user);
                            }else{
                                Set<String> users = new HashSet<>();
                                users.add(user);
                                res.put(site, users);
                            }
                        }
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(String site: res.keySet()){
            max = Math.max(max, res.get(site).size());
        }

        String ans = "";

        for(String site: res.keySet()){
            if(res.get(site).size() == max){
                ans = site;
                break;
            }
        }

        String[] arr = ans.split(",");

        List<String> pattern = new ArrayList<>();

        for(String str: arr){
            pattern.add(str);
        }

        return pattern;

    }

}