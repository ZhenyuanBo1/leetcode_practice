// Microsoft | OA 2019 | Min Steps to Make Piles Equal Height
// https://leetcode.com/discuss/interview-question/364618/Microsoft-or-OA-2019-or-Min-Steps-to-Make-Piles-Equal-Height

public class Main {

  public int minSteps(int[] piles) {
    Arrays.sort(piles);

    List<Integer> stepList = new ArrayList<>();

    int steps = 0;

    int i = piles.length - 1;
    int min = piles[0];

    while (i >= 0) {
      int currMax = piles[i];
      if (currMax == min) break;
      int j = i;
      int count = 0;
      while (j >= 0 && piles[j] == currMax) {
        j--;
        count++;
      }
      i = j;
      steps += count;
      stepList.add(steps);
    }

    int res = 0;
    for (Integer step : stepList) {
      res += step;
    }

    return res;
  }

  public static void main(String[] args) {
    int[][] testcases = {
      { 5, 2, 1 },
      { 4, 5, 5, 4, 2 },
      { 1, 1, 2, 2, 2, 3, 3, 3, 4, 4 },
    };
    for (int[] testcase : testcases) System.out.println(
      new Main().minSteps(testcase)
    );
  }
}
