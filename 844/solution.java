class Solution {
    public Stack<Character> getStackReady(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if (s == '#') {
                if (stack.empty()) {
                    continue;
                }
                else {
                    stack.pop();
                }
            }
            else {
                stack.push(str.charAt(i));
            }
        }
        return stack;
    }
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack_s = getStackReady(s);
        Stack<Character> stack_t = getStackReady(t);

        while (!stack_s.empty() && !stack_t.empty()) {
            char s_ = stack_s.pop();
            char t_ = stack_t.pop();

            if (s_ != t_) {
                return false;
            }
        }
        if (!stack_s.empty() || !stack_t.empty()) {
            return false;
        }
        return true;
    }
}
