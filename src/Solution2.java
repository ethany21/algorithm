import java.util.Arrays;

public class Solution2 {
    static int answer = 0;

    public boolean decide(String a, String b) {
        String[] arr_a = a.split("");
        String[] arr_b = b.split("");

        int difference = 0;

        for (int i = 0; i < arr_a.length; i++) {
            if (arr_a[i].equals(arr_b[i])) continue;
            else difference++;
        }
        if (difference == 1) return true;
        return false;
    }

    public int solution(String begin, String target, String[] words) {

        if (!Arrays.stream(words).anyMatch(target::equals)) {
            return 0;
        } else {
            dfs(begin, target, words);
            return answer;
        }
    }

    public void dfs(String begin, String target, String[] words) {

        boolean[] check = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            if (decide(begin, words[i])) {
                answer += 1;
                begin = words[i];
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < begin.length(); j++) {
                    sb.append("a");
                }
                words[i] = sb.toString();
                check[i] = true;
            } else check[i] = false;
        }
        int true_count = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i] == true) true_count += 1;
        }

        if (true_count == 0) return;

        if (begin.equals(target)) return;
        else dfs(begin, target, words);
    }
}
/**
 프로그래머스 Level 3 단어변환 문제
 dfs를 이용해 풀었다
 내 기억상 처음으로 풀이 보지 않고 스스로 힘으로 풀었던 문제라 감회가 남다른데
 그래도 아직 갈 길은 한참 멀었다....
 **/