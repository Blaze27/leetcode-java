package NumberofWaystoStayintheSamePlaceAfterSomeSteps;

import java.util.*;
public class Solution {
    final int mod = 1000000007;
    public int solve(int current_idx, int steps_remaining, int array_length, int[][] memo) {
        if (current_idx == 0 && steps_remaining == 0) {
            return 1;
        }

        if (steps_remaining == 0 && current_idx != 0) {
            return 0;
        }

        if (memo[current_idx][steps_remaining] != -1) {
            return memo[current_idx][steps_remaining];
        }

        int result = 0;
        if (current_idx > 0 ) {
            result += (solve(current_idx - 1, steps_remaining - 1, array_length, memo) % mod);
            result %= mod;
            memo[current_idx][steps_remaining] = result;
        }

        if (current_idx < array_length - 1) {
            result += (solve(current_idx + 1, steps_remaining - 1, array_length, memo) % mod) % mod;
            result %= mod;
            memo[current_idx][steps_remaining] = result;
        }

        result += (solve(current_idx, steps_remaining - 1, array_length, memo) % mod);
        result %= mod;
        memo[current_idx][steps_remaining] = result;

        return memo[current_idx][steps_remaining];
    }

    public int numWays(int steps, int arrLen) {
        int current_idx = 0;
        int[][] memo = new int[steps + 1][steps + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return (solve(current_idx, steps, arrLen, memo) % mod);
    }
}

