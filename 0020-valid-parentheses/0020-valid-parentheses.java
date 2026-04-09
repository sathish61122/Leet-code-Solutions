import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // Create a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // If it's a closing bracket
            else {
                // If the stack is empty, there is no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                // Check if the popped bracket matches the current closing bracket
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test cases
        System.out.println(sol.isValid("()"));      // Output: true
        System.out.println(sol.isValid("()[]{}"));  // Output: true
        System.out.println(sol.isValid("(]"));      // Output: false
        System.out.println(sol.isValid("([)]"));    // Output: false
    }
}
