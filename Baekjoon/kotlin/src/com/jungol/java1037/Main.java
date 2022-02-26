// 문제 링크 : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=316&sca=99&sfl=wr_hit&stx=1037
// 제출 링크 (공유 링크 아님) : http://jungol.co.kr/theme/jungol/result.php?sid=5526683

// 그냥.. 행기준으로 더하고 열기준으로 더하는데
// 다 짝수이면 OK
// 각 행의 합 중 하나만 홀수이면서 열도 하나만 홀수이면 Change bit
// 위의 경우가 아니면 Corrupt 인 것 같다.

package com.jungol.java1037;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 행렬 크기
        
        boolean[][] bits = new boolean[n][n];   // 패리티 검사를 진행할 행렬
        int changeableR = -1, changeableC = -1; // 교환 가능한 인덱스
        int[] sum = new int[n]; // 행의 합
        // 행렬 초기화
        for (int i = 0; i<n; i++){
            // 한 줄씩 입력하면서
            for (int j = 0; j<n; j++){
                int bit = sc.nextInt();
                // 행렬에 저장하고
                bits[i][j] = bit == 1;
                // 동시에 행의 합을 더한다.
                sum[i] += bit;
            }

            // 행의 합이 홀수인데
            if (sum[i] % 2 == 1){
                // 유일한 홀수 행이라면
                if (changeableR == -1){
                    // 저장
                    changeableR = i;
                }else{ // 아니라면 Corrupt 출력 후 종료
                    System.out.println("Corrupt");
                    return;
                }
            }
        }

        // 열에 대해서도 같은 작업을 해준다.
        sum = new int[n]; // 열의 합
        for (int i = 0; i<n; i++){
            // 한 줄씩 입력하면서
            for (int j = 0; j<n; j++){
                // 동시에 열의 합을 더한다.
                sum[i] += bits[j][i]? 1:0;
            }

            // 열의 합이 홀수인데
            if (sum[i] % 2 == 1){
                // 유일한 홀수 열이라면
                if (changeableC == -1){
                    // 저장
                    changeableC = i;
                }else{ // 아니라면 Corrupt 출력 후 종료
                    System.out.println("Corrupt");
                    return;
                }
            }
        }

        // 패리티 성질을 가지는 경우
        if (changeableR == -1 && changeableC == -1){
            System.out.println("OK");
        }else if (changeableR != -1 && changeableC != -1){
            // 비트를 바꿔서 패리티 성질을 가질 수 있는 경우
            // 행, 열 출력 (1부터 시작하므로 +1)
            System.out.printf("Change bit (%d,%d)%n", changeableR+1, changeableC+1);
        }else{  // 그외는 Corrupt
            System.out.println("Corrupt");
        }
    }
}
