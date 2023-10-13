class solution_2 {
    public int recursiveCall(int i, int n, int[] cost, int[] memo) {
        if (i >= n) {
            return 0;
        }

        if ( memo[i] != -1 ) {
            return memo[i];
        }

        memo[i] = cost[i] + Math.min(recursiveCall(i + 1, n, cost, memo), recursiveCall(i + 2, n, cost, memo));
        return memo[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int i = 0;
        int n = cost.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return Math.min( recursiveCall(i, n, cost, memo), recursiveCall(i + 1, n, cost, memo) );
    }
}
