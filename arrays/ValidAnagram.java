// Problem: Valid Anagram (#242)
// Pattern: HashMap / Frequency Count
// -----------------------------------------------
// Approach 1: Sorting (My first solution)
// Time: O(n log n) | Space: O(n)
// -----------------------------------------------

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() == t.length()) {
            char a[] = s.toCharArray();
            char b[] = t.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            int c = s.length();
            for(int i = 0; c > 0; c--, i++) {
                if(a[i] != b[i]) return false;
            }
        } else {
            return false;
        }
        return true;
    }
}

// -----------------------------------------------
// Approach 2: Frequency Count Array (Optimal)
// Time: O(n) | Space: O(1)
// -----------------------------------------------

class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] c = new int[26];

        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
            c[t.charAt(i) - 'a']--;
        }

        for (int a : c) {
            if (a != 0) return false;
        }
        return true;
    }
}
