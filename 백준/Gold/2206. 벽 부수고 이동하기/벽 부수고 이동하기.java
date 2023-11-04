import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 맵의 가로 줄 수
        int m = Integer.parseInt(st.nextToken());   // 맵의 세로 줄 수
        boolean[][] wall = new boolean[n][m];    // 맵 배열
        // [세로 칸수][가로 칸수]
        int[][] visited = new int[n][m];   // 각 위치별

        // 예외처리
        if (n == 1 && m == 1){
            System.out.println(1);
            return;
        }

        // 맵 배열 초기화
        for (int i = 0; i<n; i++){
            String s = br.readLine();
            for (int j = 0; j<m; j++){
                wall[i][j] = s.charAt(j) - '0' == 1;
            }
        }

        // 큐 생성
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 2});  // 가로, 세로, 벽을 부순지 여부(1 예스, 2이 놉 - visited 방문배열 초기화가 0이라서)
        visited[0][0] = 2;

        int[] dr = new int[] {1, -1, 0, 0};
        int[] dc = new int[] {0, 0, 1, -1};

        // bfs 시작
        int depth = 1;  // 시작 위치도 카운트하는 것 같다.
        while(!q.isEmpty()){
            depth++;

            // 깊이 우선 탐색 진행
            int qSize = q.size();
            for (int i = 0; i<qSize; i++){
                int[] current = q.poll();
                int r = current[0]; // 행 위치
                int c = current[1]; // 열 위치
                int broken = current[2];    // 벽을 부순지 여부(1 예스, 2이 놉)

                // 4방위 탐색
                for (int j = 0; j<4; j++){
                    int nr = r+dr[j];
                    int nc = c+dc[j];

                    if (nr == n-1 && nc == m-1){
                        System.out.println(depth);
                        return;
                    }

                    // 탐색 범위가 벗어나거나 적절한 상태에 도달하지 못했다면 패스
                    // 적절한 상태는.. 이전에 방문을 하지 않았거나, 벽을 부순 상태에서 방문한 곳을 벽을 안 부순 상태에서 한번더 탐색하게 되었을 때
                    if (nr < 0 || nr >=n || nc < 0 || nc >= m || visited[nr][nc] >= broken)
                        continue;

                    if (wall[nr][nc]){
                        if (broken >= 2){
                            visited[nr][nc] = broken-1;
                            q.add(new int[]{nr, nc, broken-1});
                        }
                    }else{
                        visited[nr][nc] = broken;
                        q.add(new int[]{nr, nc, broken});
                    }
                }
            }
        }

        System.out.println(-1);
    }
}