package NumberofWaystoStayintheSamePlaceAfterSomeSteps;

public class Main {
    public static void main(String[] args) {
        Solution s_obj = new Solution();
        
        int steps = 4;
        int arrLen = 2;

        System.out.println(s_obj.numWays(steps, arrLen));
    }
}
