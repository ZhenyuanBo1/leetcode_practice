class UndergroundSystem {
    Map<Integer, String> customerStationMap;
    Map<Integer, Integer> customerCheckinTimeMap;
    Map<String, List<Integer>> travelTimeMap;
    public UndergroundSystem() {
        customerStationMap = new HashMap<>();
        customerCheckinTimeMap = new HashMap<>();
        travelTimeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        customerCheckinTimeMap.put(id, t);
        customerStationMap.put(id, stationName);
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(customerCheckinTimeMap.containsKey(id) && customerStationMap.containsKey(id)){
            int travelTime = t - customerCheckinTimeMap.get(id);
            String startEnd = customerStationMap.get(id) + "-" + stationName;
            if(travelTimeMap.containsKey(startEnd)){
                List<Integer> list = travelTimeMap.get(startEnd);
                list.add(travelTime);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(travelTime);
                travelTimeMap.put(startEnd, list);
            }
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<Integer> travelTimes = travelTimeMap.get(startStation + "-" + endStation);
        int sum = 0;

        for(Integer t: travelTimes){
            sum += t;
        }

        return (double)sum / (double)travelTimes.size();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */