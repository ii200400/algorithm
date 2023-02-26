import java.util.Scanner;

public class Main {

    static int n;
    static boolean[][] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 구역 크기
        char[][] map1 = new char[n][n];  // 구역 배열 (일반인)
        char[][] map2 = new char[n][n];  // 구역 배열 (적녹색약)
        // 구역 초기화
        for (int i = 0; i<n; i++){
            String charArr = sc.next();
            for (int j = 0; j<n; j++) {
                map1[i][j] = charArr.charAt(j);
                // 적녹색약일 경우 G를 R로 바꿔놓는다.
                map2[i][j] = map1[i][j] == 'G'? 'R':map1[i][j];
            }
        }

        // 일반인 탐색
        System.out.print(searchArea(map1)+" ");

        // 적녹색약 탐색
        System.out.print(searchArea(map2)+" ");

    }

    // 지도의 모든 곳을 살펴보면서 같은 구역을 세고 출력한다.
    static int searchArea(char map[][]){
        isVisited = new boolean[n][n]; // 방문 배열
        int cnt = 0;    // 구역 개수

        // 한칸씩 살펴보면서 구역을 찾는데
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                // 방문한 곳이라면 생략하고
                if (isVisited[i][j])
                    continue;

                // 그렇지 않은 곳은 dfs를 활용하여 구역을 모두 방문한다.
                isVisited[i][j] = true;
                dfs(map, i, j);
                cnt++;
            }
        }

        // 볼 수 있는 구역의 개수를 반환한다.
        return cnt;
    }

    // 4방위 탐색
    static int[] dr = new int[]{0,0,1,-1};
    static int[] dc = new int[]{1, -1, 0, 0};

    // 깊이우선탐색
    static void dfs(char[][] map, int _r, int _c){
        // 현 위치에서 4방위 탐색을 하는데
        for (int i = 0; i<4; i++){
            int r = _r+dr[i], c = _c+dc[i];

            // 인덱스를 넘겼거나 방문을 했다면 생략
            if (r<0 || r>=n || c<0 || c>=n || isVisited[r][c])
                continue;

            // 그렇지 않고 같은 타일이라면
            if (map[r][c] == map[_r][_c]) {
                // 방문기록을 하고 dfs 이어서 진행
                isVisited[r][c] = true;
                dfs(map, r, c);
            }
        }
    }
}