class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> scoreMap = new TreeMap<>();
        for(int i=0; i<items.length; i++){
            int[] currItem = items[i];
            int studentID = currItem[0];
            int studentScore = currItem[1];
            if(scoreMap.containsKey(studentID)){
                scoreMap.get(studentID).add(studentScore);
            }else{
                List<Integer> scoreList = new ArrayList<>();
                scoreList.add(studentScore);
                scoreMap.put(studentID, scoreList);
            }
        }

        int[][] ans = new int[scoreMap.size()][2];

        int j=0;
        for(Integer key : scoreMap.keySet()){
            Collections.sort(scoreMap.get(key));
            System.out.println(scoreMap.get(key));
            int sum = 0;
            int count = 0;
            int index = scoreMap.get(key).size()-1;
            while(count<5){
                if(index<0) break;
                sum += scoreMap.get(key).get(index);
                count += 1;
                index -= 1;
            }

            ans[j][0] = key;
            ans[j][1] = sum/(scoreMap.get(key).size() > 5 ? 5 : scoreMap.get(key).size()) ;
            j+=1;
        }

        return ans;
    }
}