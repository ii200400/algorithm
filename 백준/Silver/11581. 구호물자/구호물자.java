import java.util.Scanner;

public class Main {
    static int n;
    static boolean[][] adjMatrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 교차로 수
        adjMatrix = new boolean[n+1][n+1];  // 인접행렬

        // 인접행렬 초기화
        for (int i = 1; i<n; i++){
            int e = sc.nextInt();
            for (int j = 0; j<e; j++){
                adjMatrix[i][sc.nextInt()] = true;
            }
        }

        // dfs 시작
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        if(dfs(1, visited)){
            System.out.println("CYCLE");
        }else {
            System.out.println("NO CYCLE");
        }
    }


    static boolean dfs(int num, boolean[] visited){
        for (int i = 1; i<=n; i++){
            if (!adjMatrix[num][i])
                continue;

            if (visited[i]){
                return true;
            }

            visited[i] = true;
            if (dfs(i, visited))
                return true;
            visited[i] = false;
        }

        return false;
    }
}