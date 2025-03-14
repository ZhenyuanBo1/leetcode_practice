class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQ = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for(int student: students){
            studentQ.offer(student);
        }

        for(int i=sandwiches.length-1; i>=0; i--){
            stack.push(sandwiches[i]);
        }

        while(!studentQ.isEmpty()){
            int size = studentQ.size();
            boolean found = false;
            for(int i=0; i<size; i++){
                int pref = studentQ.poll();
                if(pref == stack.peek()){
                    stack.pop();
                    found = true;
                    break;
                }else{
                    studentQ.offer(pref);
                }
            }
            if(!found) return size;
        }

        return 0;
    }
}