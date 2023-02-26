import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // [빨강 비용, 초록 비용, 파랑 비용]
        int[] colors = new int[3];  // 마지막으로 탐색한 집을 해당 색으로 칠했을 때 최소비용

        int[] input;    // 입력 받는 배열
        for (int i = 0; i<n; i++){
            input = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};

            // 입력값
            colors = new int[]{
                    Math.min(colors[1], colors[2])+input[0],    // 이전에 초록/파랑 지붕의 집까지의 비용 중 작은 것 + 현재 집의 빨강 지붕 비용
                    Math.min(colors[0], colors[2])+input[1],    // 이전에 빨강/파랑 지붕의 집까지의 비용 중 작은 것 + 현재 집의 초록 지붕 비용
                    Math.min(colors[0], colors[1])+input[2],    // 이전에 빨강/초록 지붕의 집까지의 비용 중 작은 것 + 현재 집의 파랑 지붕 비용
            };
        }

        // 마지막 집까지 지붕을 칠할 때 가장 작은 비용을 출력
        System.out.println(Math.min(Math.min(colors[0], colors[1]), colors[2]));
    }
}