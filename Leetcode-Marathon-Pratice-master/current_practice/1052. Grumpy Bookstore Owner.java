class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int i=0, j=0;
        int max = Integer.MIN_VALUE;
        int numSatisfied = 0;

        //calculate all already satified customers
        for(int k=0; k<grumpy.length; k++){
            if(grumpy[k] == 0){
                numSatisfied += customers[k];
            }
        }

        while(i+minutes<=grumpy.length){
            if(grumpy[j] == 1) numSatisfied += customers[j];
            j++;
            if(j-i == minutes){
                max = Math.max(max, numSatisfied);
                if(grumpy[i]==1) numSatisfied -= customers[i++];
                else i++;
            }
        }

        return max;
    }
}