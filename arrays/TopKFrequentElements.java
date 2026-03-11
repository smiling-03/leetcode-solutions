// Problem: Top K Frequent Elements (#347)
// Pattern: HashMap + Sorting / Bucket Sort
// -----------------------------------------------
// Approach 1: HashMap + Sorting (My first solution)
// Time: O(n log n) | Space: O(n)
// -----------------------------------------------

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            f.put(nums[i], f.getOrDefault(nums[i], 0) + 1);
        }
        List<int[]> p = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : f.entrySet()) {
            p.add(new int[]{entry.getValue(), entry.getKey()});
        }
        p.sort((a, b) -> Integer.compare(b[0], a[0]));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = p.get(i)[1];
        }
        return res;
    }
}

// -----------------------------------------------
// Approach 2: Bucket Sort (Optimal)
// Time: O(n) | Space: O(n)
// -----------------------------------------------

class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            for (int num : bucket[i]) {
                res[idx++] = num;
                if (idx == k) break;
            }
        }
        return res;
    }
}
