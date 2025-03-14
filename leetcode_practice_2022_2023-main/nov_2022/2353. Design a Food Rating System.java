class FoodRatings {
    class Pair{
        String food;
        String cuisine;
        int rating;
        public Pair(String food, String cuisine, int rating){
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }
    HashMap<String, PriorityQueue<Pair>> map1; // key is cuisine, value is pq
    HashMap<String, Pair> map2; // key is food, value is pair
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.map1 = new HashMap<>();
        this.map2 = new HashMap<>();
        for(int i=0; i<foods.length; i++){
            Pair p = new Pair(foods[i], cuisines[i], ratings[i]);
            if(!this.map1.containsKey(cuisines[i])){
                PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
                    if(p1.rating == p2.rating) return p1.food.compareTo(p2.food);
                    return Integer.compare(p2.rating, p1.rating);
                });
                pq.add(p);
                this.map1.put(cuisines[i], pq);
            }else{
                PriorityQueue<Pair> pq = this.map1.get(cuisines[i]);
                pq.add(p);
            }
            this.map2.put(foods[i], p);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Pair p = this.map2.get(food);
        PriorityQueue<Pair> pq = this.map1.get(p.cuisine);
        pq.remove(p);
        p.rating = newRating;
        pq.add(p);
    }
    
    public String highestRated(String cuisine) {
        return this.map1.get(cuisine).peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */