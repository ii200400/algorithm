// 문제 링크 : https://www.acmicpc.net/problem/1074
// 제출 공유 링크 : http://boj.kr/3fda3b8d3c06433b999958ed2f677b06

// 아.. 주석을 ... 어떻게 쓰지;;;
// 주석을 써도 미래의 나는 못 알아볼 것 같다..
// 음.. 가장 큰 Z 정사각형을 구하고 사분면 중 하나일 테니 r과 c를 토대로 계산하면서
// 숫자를 계산해 나갔다.

package com.baekjoon.problem.java1074;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();   // 안 쓴다.
        int r = sc.nextInt();   // 세로 칸 수
        int c = sc.nextInt();   // 가로 칸 수
        if (r == 0 && c == 0) {
            System.out.println(0);  // 둘 다 0이면 아래의 로그 계산이 잘 되지 않아서 예외처리
            return;
        }

        // 입력받은 r과 c를 통해 N 계산 (입력으로 주어지는 N이 생각보다 더 큰 값이 들어오는지 아닌지 몰라서 사용 ex. 10 0 0 )
        int n = Math.max(baseLog(r, 2), baseLog(c, 2));
        int area = (int) Math.pow(4, n);        // 사분면에 들어갈 수 있는 칸 수
        int condition = (int) Math.pow(2, n);   // 사분면의 길이
        int cnt = 0;    // r,c 위치의 숫자 값 저장 변수 (정답)
        do {
            // 4개의 면 중 어느 면에 들어가 있는지 확인
            int divide = condition << 1;
            int leftR = r % divide;
            int leftC = c % divide;

            // 1사분면은 더하지 않아도 된다.
            if (leftR < condition && leftC >= condition){   // 오른쪽 위 (2사분면)
                cnt += area;
            }else if (leftR >= condition && leftC < condition){ // 왼쪽 아래 (3사분면)
                cnt += area*2;
            }else if (leftR >= condition && leftC >= condition){  // 오른쪽 아래 (4사분면)
                // 사실 위의 조건 때문에 && leftC >= condition 은 없어도 된다.
                cnt += area*3;
            }

            // 더 작은 사분면을 탐색하러 간다.
            area /= 4;
            condition /= 2;
        } while(area != 0); // 사분면의 크기가 0이면 끝낸다.

        System.out.println(cnt);
    }

    static int baseLog(double x, double base) {
        return (int) (Math.log(x) / Math.log(base));
    }

    // 재귀로도 풀어보고 싶은데..
}
