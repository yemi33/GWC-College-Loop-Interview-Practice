class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        /*
        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2,2]
        
        (1) Brute Force (O(m * n)) - not the most ideal, we need to think about how to deal with duplicates
        (2) Hashmap / Dictionary (O(m + n))
        
            res = ArrayList
            
            key: item
            value: number of times we see it
            1 - 2
            2 - 2
            
            check: is 2 in our hashmap -> if yes, decrement the value for 2 (we want to add the current item, aka 2 to our res)
            
            1 - 2
            2 - 1
            
            res = [2]
            
            check: is 2 in our hashmap and the value of 2 is not 0 -> if yes, decrement the value for 2 (we want to add the current item, aka 2 to our res)
            
            1 - 2
            2 - 0
            
            res = [2,2]
        
        (3) Follow up 1
        
        Input: nums1 = [1,1,2,2], nums2 = [2,2]
        
        You compare the first items in each array, and then wherever the shorter one starts, start with that itme if it exists in the longer array
        */
        
        Map<Integer, Integer> map = new HashMap();
        List<Integer> list = new ArrayList<>();
        
        for (int num : nums1) {
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) != 0) {
                map.put(num, map.get(num) - 1);
                list.add(num);
            } 
        }
        
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        
        return arr;
    }
}
