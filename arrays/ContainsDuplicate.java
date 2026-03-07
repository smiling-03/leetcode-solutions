// Problem: Contains Duplicate (#217)
// Pattern: HashMap / HashSet
// -----------------------------------------------
// Approach 1: Sorting (My first solution)
// Time: O(n log n) | Space: O(1)
// -----------------------------------------------

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) return true;
        }
        return false;
    }
}

// -----------------------------------------------
// Approach 2: HashSet
// Time: O(n) | Space: O(n)
// -----------------------------------------------

class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) return true;
            seen.add(num);
        }
        return false;
    }
}
