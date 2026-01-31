import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;  // to store the maximum length
        int left = 0;    // left pointer of sliding window
        HashSet<Character> set = new HashSet<>(); // to store unique characters

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);

            // If character is already in set, remove characters from the left
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c); // add current character
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
