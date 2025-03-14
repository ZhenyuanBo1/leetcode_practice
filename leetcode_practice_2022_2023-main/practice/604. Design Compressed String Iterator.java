class StringIterator {
    private LinkedList<Character> q;
    private List<Integer> countList;
    private int i = 0;

    public StringIterator(String compressedString) {
        q = new LinkedList<>();
        countList = new ArrayList<>();
        for(int i=0; i<compressedString.length(); i++){
            char c = compressedString.charAt(i);
            if(Character.isLetter(c)){
                int j;
                q.offer(c);
                for(j=i+1; j<compressedString.length(); j++){
                    char nextc = compressedString.charAt(j);
                    if(Character.isLetter(nextc)) break;
                }
                int count = Integer.parseInt(compressedString.substring(i+1, j));
                countList.add(count);
            }
        }
    }
    
    public char next() {
        if(i<countList.size()){
            if(countList.get(i) == 1){
                i++;
                return q.poll();
            }else{
                int updatedCount = countList.get(i)-1;
                countList.set(i, updatedCount);
                return q.peekFirst();
            }
        }
        return ' ';
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */