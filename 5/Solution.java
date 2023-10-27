public class Solution {
    public static boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start += 1;
            end -= 1;
        }
        return true;
    }
    public static String longestPalindrome(String s) {
        int ans_start = -1, ans_end = -1;
        int length = -1;
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                if ((end - start + 1) > length && isPalindrome(start, end, s)) {
                    ans_start = start;
                    ans_end = end;
                    length = (end - start) + 1;
                }
            }
        }
        return s.substring(ans_start, ans_end + 1);
    }

    public static void main(String[] args) {
        String s = Solution.longestPalindrome("babad");
        System.out.println(s);
    }
}