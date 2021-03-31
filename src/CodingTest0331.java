import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


class CodingTest0331{

    private static boolean [] check;

    private static Map<Integer, List<Integer>> initial = new HashMap<>();

    private static int[] box;

    int[][] solution(int n, int[][] signs){

        int[][] answer = new int[n][n];

        for (int i = 0; i < n; i++){

            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < n; j++){
                if (signs[i][j] == 1){
                    temp.add(j);
                }
            }
            initial.put(i, temp);
        }

        for (int i = 0; i < n; i++){
            check = new boolean[n];
            box = new int[n];
            dfs(box, i, initial.get(i));
            for (int j = 0; j < box.length; j++){
                if(box[j] == 1) answer[i][j] = 1;
            }
        }
        return answer;

    }

    public void dfs(int[] box, int start, List<Integer> paths){

        if(check[start]){
            return;
        }

        for (int i = 0; i < paths.size(); i++){

            int next = paths.get(i);
            paths = initial.get(next);
            box[next] = 1;
            if(paths != null && !check[next]){
                check[next] = true;
                dfs(box, start, paths);
                check[next] = false;
            }
        }
    }
}