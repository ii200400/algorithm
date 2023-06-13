import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 노드의 수
        ArrayList<Integer>[] adjList = new ArrayList[n+1];  // 인접리스트
        int[][] disjoint = new int[n+1][2];  // 서로소 집합 [각 노드별][부모 노드, 루트부터의 깊이]
        disjoint[1] = new int[] {1, 0};    // 1은 항상 루트이므로

        // 인접리스트 초기화
        for (int i = 1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());;
            adjList[from].add(to);
            adjList[to].add(from);
        }

        // bfs를 활용하여 트리의 서로소 집합 구현
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        // bfs 시작
        int level = 0;
        while (!q.isEmpty()){
            level++;

            // 레벨우선 탐색
            int size = q.size();
            for (int i = 0; i<size; i++){
                int current = q.poll();

                // 인접한 노드 탐색
                for (int next : adjList[current]){
                    // 이미 방문한 경험이 있다면 생략
                    if(disjoint[next][0] != 0)
                        continue;

                    disjoint[next] = new int[] { current, level };
                    q.offer(next);
                }
            }
        }

        // 공통조상이 궁금한 두 정점의 입력 회수
        int question = Integer.parseInt(br.readLine());
        int node1, node2;
        for (int i = 0; i<question; i++){
            st = new StringTokenizer(br.readLine());
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());

            // 두 노드의 깊이가 같도록 조정한다.
            int min = Math.min(disjoint[node1][1], disjoint[node2][1]);
            while (min != disjoint[node1][1]){
                node1 = disjoint[node1][0];
            }
            while (min != disjoint[node2][1]){
                node2 = disjoint[node2][0];
            }

            // 공통조상을 찾을 때까지 탐색
            while(node1 != node2){
                node1 = disjoint[node1][0];
                node2 = disjoint[node2][0];
            }
            // 공통조상 출력
            System.out.println(node1);
        }
    }
}