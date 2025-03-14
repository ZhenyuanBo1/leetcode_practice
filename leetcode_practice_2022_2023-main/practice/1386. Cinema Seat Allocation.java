class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<reservedSeats.length; i++){
            int[] seat = reservedSeats[i];
            int r = seat[0];
            int c = seat[1];
            if(map.containsKey(r)){
                map.get(r).add(c);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(c);
                map.put(r, list);
            }
        }

        int res = (n - map.size()) * 2; // for non-reserved rows, max is 2

        for(Integer r: map.keySet()){
            boolean left = true;
            boolean mid = true;
            boolean right = true;
            for(Integer s: map.get(r)){
                if(s>=2 && s<=5) left = false;
                if(s>=4 && s<=7) mid = false;
                if(s>=6 && s<=9) right = false;
            }
            if(left && right){
                res += 2;
            }else if(left || mid || right){
                res += 1;
            }
        }

        return res;

    }
}