class MyCalendar {
    private TreeMap<Integer, Integer> tmap;
    public MyCalendar() {
        tmap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        int prev = tmap.floorkey(start);
        int next = tmap.ceilingKey(start);
        if((prev == null || tmap.get(prev)<=start) && (next == null || end<=next)){
            tmap.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */