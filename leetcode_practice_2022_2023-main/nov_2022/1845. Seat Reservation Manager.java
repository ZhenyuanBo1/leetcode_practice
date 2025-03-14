class SeatManager {
  private PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

  public SeatManager(int n) {
    for (int i = 0; i < n; i++) {
      this.pq.add(i + 1);
    }
  }

  public int reserve() {
    return pq.poll();
  }

  public void unreserve(int seatNumber) {
    this.pq.add(seatNumber);
  }
}
/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
