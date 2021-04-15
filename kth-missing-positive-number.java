class Solution {
    // [3,4,5] k = 2, 1,2 -> 2
    // [1,2,3] k = 2, 4,5 -> 5
    // [1 3 6] k = 2. 2, -> 4
    public int findKthPositive(int[] arr, int k) {
        int numMissing = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                numMissing += arr[i] - 1;
                if (numMissing >= k) {
                    return k;
                }
            } else {
                numMissing += arr[i] - arr[i - 1] - 1;
                if (numMissing >= k) {
                    numMissing -= arr[i] - arr[i - 1] - 1;
                    int kth = arr[i - 1];
                    while (numMissing < k) {
                        kth++;
                        numMissing++;
                    }
                    return kth;
                }
            }
        }
        
        int kth = arr[arr.length - 1];
        while (numMissing < k) {
            kth++;
            numMissing++;
        }
        return kth;
    }
}
