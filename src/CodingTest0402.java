public class CodingTest0402 {


    /**
     *
     * @param office
     * @param r
     * @param c
     * @param move
     * @return
     *
     *
     * 아이포트폴리오 코딩테스트
     * 양의 정수 그리고 -1로 이루어진 2차원 정수형 배열이 주어진다
     *
     * -1은 물건이 놓인 좌표에 위치, 나머지 양의 정수들은 해당 좌표에 쌓인 먼지의 크기를 의미한다
     * 진공로봇 청소기는 좌표들을 움직이면서 먼지를 빨아들여 0으로 만든다
     * r과 c로 로봇 청소기가 처음 위치한 곳을 알려준다
     * move는 String 배열로 주어지고, "go", "right", "left" 으로 이루어져 있다
     * 로봇 청소기는 방향을 가지고 움직이며, 맨 처음에는 항상 북쪽으로 향하고 있다고 가정한다
     * move 배열 중에 go가 있으면 청소기가 향한 방향으로 한 칸 이동한다
     * 그러나, 배열의 크기를 벗어나거나, 물건이 놓여져 있어 -1이 위치한 좌표가 있다면 이동하지 않는다
     * right나 left를 만나면 이동하지는 않고 오른쪽이나 왼쪽으로 다음에 움직일 방향을 바꾼다
     * 예를 들어 처음에 북쪽을 향하도록 되어 있다가 right를 만나면 동쪽, 그다음 right를 만나면 남쪽을 향한다
     * 남쪽을 향하는 상태에서 letf를 만나면 동쪽으로 방향을 튼다.
     *
     * 진공청소기가 작업을 마칠 때 빨아들인 총 먼지의 합을 return하라
     *
     */


        public int solution(int[][] office, int r, int c, String[] move) {
            int answer = 0;

            int size = office.length - 1;

            answer += office[r][c];
            office[r][c] = 0;

            String[] polar = {"북", "동", "남", "서"};

            int direction = 0;

            int[] next = {r, c};

            for (int i = 0; i < move.length; i++) {

                if (direction == -1) {
                    direction += 4;
                }

                if (move[i].equals("go")) {

                    if (direction % 4 == 0) next[0] -= 1;
                    if (direction % 4 == 1) next[1] += 1;
                    if (direction % 4 == 2) next[0] += 1;
                    if (direction % 4 == 3) next[1] -= 1;

                    System.out.println(next[0] + ", " + next[1]);

                    if (next[0] > size || next[0] < 0 || next[1] > size || next[1] < 0) {
                        if (direction % 4 == 0) next[0] += 1;
                        if (direction % 4 == 1) next[1] -= 1;
                        if (direction % 4 == 2) next[0] -= 1;
                        if (direction % 4 == 3) next[1] += 1;
                        continue;
                    }

                    if (office[next[0]][next[1]] == -1) {
                        if (direction % 4 == 0) next[0] += 1;
                        if (direction % 4 == 1) next[1] -= 1;
                        if (direction % 4 == 2) next[0] -= 1;
                        if (direction % 4 == 3) next[1] += 1;
                        continue;
                    }

                    answer += office[next[0]][next[1]];
                    office[next[0]][next[1]] = 0;
                }
                if (move[i].equals("right")) direction += 1;
                if (move[i].equals("left")) direction -= 1;
            }
            return answer;
        }
}
