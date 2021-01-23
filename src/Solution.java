public class Solution {

    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(target, numbers, 0);
        return answer;
    }

    public void dfs(int target, int[] numbers, int k) {
        if (k == numbers.length) {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            if (sum == target) answer++;
            return;
        } else {
            numbers[k] *= 1;
            dfs(target, numbers, k + 1);
            numbers[k] *= -1;
            dfs(target, numbers, k + 1);
        }
    }

}
/**
 프로그래머스 level 2 타겟 넘버
 dfs가 제대로 뭔지도 몰랐던 시절에 풀었던 문제
 다른 사람이 올린 코드 보느라 정신 없었다
 지금도 dfs를 제대로 활용해서 문제 푸는 것은 아니니 만큼
 더욱더 정진하자
 **/