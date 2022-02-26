// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq

// 아랰ㅋㅋㅋ 방향 전환 하는 거 꼭 보잨ㅋㅋㅋ
// 이게 이렇게 축약이 된다, 사실 본인이 알아낸 것은 아니고
// 7년 전에 디미고 친구가 짯던 코드가 가물가물 기억나서 축약이 된다는 것을 기억하고 있었다.
// 그 때 당시에 그 친구가 본인의 영혼을 담아서 짧게 만들었다고 했는데, 영혼 잘 받았다 친구야~

package com.ssafy.swea.java1954;

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        // 테스트 케이스 수마다 반복
        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 크기 입력 및 달팽이 배열 초기화
            int n = sc.nextInt();
            int[][] snail = new int[n][n];
            System.out.printf("#%d\n", test_case);
            
            int nr = 0, nc = 1;     // r의 변화값, c의 변화값
            int cnt = 1;            // 달팽이 배열 입력값
            int max = (int) Math.pow(n, 2); // 조건값 그냥.. n*n하면 된다;
            
            // 달팽이 만들기 - 입력값이 조건값보다 작을동안 r과 c를 달팽이 모양으로 옮긴다.
            for(int r = 0, c = 0; cnt <= max; r += nr, c += nc){
                snail[r][c] = cnt;
                cnt++;

                // 진행 위치가 배열 밖으로 나가거나 이미 값이 있는 경우 변화(방향) 값을 바꿔준다.
                if (r+nr < 0 || n <= r+nr || c+nc <0 || n <= c+nc ||
                    snail[r+nr][c+nc] != 0){
//                    if (nr == 0 && nc == 1) {
//                        nr = 1;
//                        nc = 0;
//                    } else if (nr == 1 && nc == 0){
//                        nr = 0;
//                        nc = -1;
//                    }else if (nr == 0 && nc == -1){
//                        nr = -1;
//                        nc = 0;
//                    }else{
//                        nr = 0;
//                        nc = 1;
//                    }

                    // 어..? 축약이 된다. 기쁘다!
//                    if (nr == 0) {
//                        nr = nc;
//                        nc = 0;
//                    } else {
//                        nc = -nr;
//                        nr = 0;
//                    }

                    // 어.. 또 축약된닼ㅋㅋㅋ
                    int temp = nr;
                    nr = nc;
                    nc = -temp;
                }
            }

            // 달팽이 배열을 출력한다!
            for (int[] row : snail) {
                for (int item : row)
                    System.out.print(item+" ");
                System.out.println();
            }
        }
    }
}