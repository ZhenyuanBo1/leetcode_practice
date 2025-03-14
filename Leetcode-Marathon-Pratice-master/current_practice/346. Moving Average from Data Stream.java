class MovingAverage {

    private int currWindowSize=0;
    List<Integer> history = new ArrayList<>();

    public MovingAverage(int size) {
        this.currWindowSize = size;
    }

    public double next(int val) {
        history.add(val);
        int index=history.size()-1;
        double sum=0;
        int count=1;

        while(index>=0){
            if(count>currWindowSize) break;
            sum += history.get(index);
            index--;
            count++;
        }

        int len = history.size()>currWindowSize ? currWindowSize : history.size();
        return sum/len;
    }
}
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

 //solution:

 class MovingAverage {
  int size, windowSum = 0, count = 0;
  Deque queue = new ArrayDeque<Integer>();

  public MovingAverage(int size) {
    this.size = size;
  }

  public double next(int val) {
    ++count;
    // calculate the new sum by shifting the window
    queue.add(val);
    int tail = count > size ? (int)queue.poll() : 0;

    windowSum = windowSum - tail + val;

    return windowSum * 1.0 / Math.min(size, count);
  }
}