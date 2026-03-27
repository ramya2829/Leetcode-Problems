class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;

        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                numSeen = true;
            } 
            else if (c == '.') {
                if (dotSeen || eSeen) return false; // dot after e or multiple dots
                dotSeen = true;
            } 
            else if (c == 'e' || c == 'E') {
                if (eSeen || !numSeen) return false; // e without number
                eSeen = true;
                numSeen = false; // reset for exponent digits
            } 
            else if (c == '+' || c == '-') {
                // Sign must be at start or after e
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } 
            else {
                return false; // invalid character
            }
        }

        return numSeen;
    }
}