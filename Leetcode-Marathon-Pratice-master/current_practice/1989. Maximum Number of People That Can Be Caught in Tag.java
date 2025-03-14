class Solution {

    public int catchMaximumAmountofPeople(int[] team, int dist) {
        List<Integer> notItList = new ArrayList<>();
        List<Integer> itList = new ArrayList<>();

        for(int i=0; i<team.length; i++){
            if(team[i] == 0){
                notItList.add(i);
            }else{
                itList.add(i);
            }
        }

        int i=0, j=0, count=0;

        while(j<itList.size()){
            int low = itList.get(j) - dist;
            int high = itList.get(j) + dist;
            int temp = i;
            boolean flag = false;
            while(i<notItList.size()){
                int curr = notItList.get(i);
                if(curr>=low && curr<=high){
                    count += 1;
                    i++;
                    flag = true;
                    break;
                }
                i++;
            }
            if(!flag) i = temp;
            j++;
        }

        return count;

    }

}