class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> q = new LinkedList<>();

        for(int i=0; i<deck.length; i++){
            q.offer(i);
        }

        int[] res = new int[deck.length];

        for(Integer i: deck){
            res[q.pollFirst()] = i;
            if(!q.isEmpty()){
                q.offerLast(q.pollFirst());
            }
        }

        return res;
    }
}