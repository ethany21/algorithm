public class SolutionCheck {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int result = sol.solution(begin, target, words);

        System.out.println(result);
    }
}
