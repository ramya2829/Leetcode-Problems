import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String dir : components) {
            if (dir.equals("") || dir.equals(".")) {
                continue; // ignore
            } else if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.pop(); // go up
            } else {
                stack.push(dir); // valid directory
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }

        return sb.toString();
    }
}