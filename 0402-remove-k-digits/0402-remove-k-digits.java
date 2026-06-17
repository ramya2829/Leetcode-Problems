class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }

            st.push(ch);
        }
        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();

        for (char c : st) {
            ans.append(c);
        }
        while (ans.length() > 0 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        if (ans.length() == 0) {
            return "0";
        }

        return ans.toString();
    }
}