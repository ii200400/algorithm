import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 도시 개수
        int m = sc.nextInt();   // 버스 개수
        int[][] adjMatrix = new int[n+1][n+1];  // 인접 행렬

        // 인접행렬 초기화
        for (int i = 1; i<=n; i++){
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            // 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있으므로 가장 싼 것 하나만 저장
            adjMatrix[from][to] = Math.min(adjMatrix[from][to], sc.nextInt());
        }

        // 플로이드 워셜
        for (int k = 1; k<=n; k++){
            for (int i = 1; i<=n; i++){
                if (k == i || adjMatrix[i][k] == Integer.MAX_VALUE) continue;

                for (int j = 1; j<=n; j++){
                    if (k == j || i == j || adjMatrix[k][j] == Integer.MAX_VALUE) continue;

                    // 최단거리 갱신
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }

        // 도시별 이동 최소 비용
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=n; j++){
                System.out.print((adjMatrix[i][j] == Integer.MAX_VALUE? 0:adjMatrix[i][j]) + " ");
            }
            System.out.println();
        }
    }
}