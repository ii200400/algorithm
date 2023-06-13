import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] adjList;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 정점의 개순
        adjList = new ArrayList[n+1]; // 인접 리스트 + 편의상 1크게 (인접행렬쓰면 시간초과날듯..?)
        parents = new int[n+1];    // i번째 인덱스의 부모노드 (+ 정점 방문 여부에도 활용 0이면 방문x 아니면 방문o)

        // 인접리스트 초기화
        for (int i = 1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i<n-1; i++){  // 트리는 정점이 n개라면 간선은 n-1이기 때문
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 일단 무향그래프 취급
            adjList[from].add(to);
            adjList[to].add(from);
        }

        // 깊이우선으로 해결
//        dfs(1);

        // 너비우선으로 해결
        bfs();

        // 정점 2부터 각 정점의 부모 정점 출력
        for (int i = 2; i<n+1; i++) {
            System.out.println(parents[i]);
        }
    }

    static void dfs(int current){
        for (int v : adjList[current]){
            // 방문했다면 (부모 설정이 되어있다면) 생략
            if (parents[v] != 0)
                continue;

            // 아직 방문하지 않았다면 부모 정점 기록하고
            parents[v] = current;
            // 탐색 계속하기
            dfs(v);
        }
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int current = q.poll();

            for (int v : adjList[current]){
                // 방문했다면 생략
                if (parents[v] != 0)
                    continue;

                // 아직 방문하지 않았다면 부모 정점 기록하고
                parents[v] = current;
                // 큐에 방문 정점 추가
                q.add(v);
            }
        }
    }
}