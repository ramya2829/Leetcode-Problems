import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        for (String s : strs) {
            boolean placed = false;
            
            // Check if 's' belongs to any existing anagram group
            for (List<String> group : result) {
                // We only need to check against the first word of the group
                if (isAnagram(s, group.get(0))) {
                    group.add(s);
                    placed = true;
                    break;
                }
            }
            
            // If it doesn't match any existing group, create a new one
            if (!placed) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(s);
                result.add(newGroup);
            }
        }

        return result;
    }

    // Helper method to check if two strings are anagrams without sorting
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        
        for (int c : count) {
            if (c != 0) return false;
        }
        
        return true;
    }
}