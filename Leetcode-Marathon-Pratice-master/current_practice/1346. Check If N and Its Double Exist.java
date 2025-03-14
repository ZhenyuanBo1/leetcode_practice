class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);

        for(int i=1; i<arr.length; i++){
            int val1 = arr[i] * 2;
            if(map.containsKey(val1) && map.get(val1) != i) return true;

            if(arr[i] % 2 == 0 ){
                int val2 = arr[i] / 2;
                if(map.containsKey(val2) && map.get(val2) != i) return true;
            }

            map.put(arr[i], i);

        }

        return false;

    }
}

//binary search
class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++){

            int doubleIndex = findValue(arr[i] * 2, arr);
            int halfIndex = findValue(arr[i] * 1.0/2, arr);

            if(doubleIndex != -1 && doubleIndex != i) return true;
            if(halfIndex != -1 && halfIndex != i) return true;

        }

        return false;

    }
    private int findValue(double target, int[] arr){
        int left = 0, right = arr.length-1;

        while(left < right){
            int mid = left + (right -left)/2;
            if((double)arr[mid] > target){
                right = mid - 1;
            }else if((double)arr[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }

        if(left == right && arr[left] == target) return left;

        return -1;
    }
}