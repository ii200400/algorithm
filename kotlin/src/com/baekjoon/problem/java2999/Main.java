// 문제 링크 : https://www.acmicpc.net/problem/2999
// 제출 공유 링크 : http://boj.kr/987f31d6254a4946addb322df429671d

// 해독보다 해독하는데 필요한 행렬을 구하는 것이 더 길 것 같은 문제;;
// 어차피 두 개 모두 for문 이니 그렇게 길지는 않을 테지만..

// 햇갈려서.. 이해했다가 이해를 못했다가를 반복한다.. 머리아프다;;

package com.baekjoon.problem.java2999;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        String password = sc.next();
        int passLen = password.length();
        int r, c;   // 암호에 쓰이는 배열의 세로, 가로 줄 수
        // 제곱근 부터 작은 값을 살펴나가면서 세로, 가로 줄 수를 확인한다.
        for (r = (int) Math.sqrt(passLen); r>0; r--){
            // 가장 먼저 나온 가능한 가로/세로가 가장 큰 행을 가지게 된다.
            if (passLen % r == 0)
                break;
        }
        // 열 초기화
        c = passLen / r;

        // 암호에 쓰인 행렬을 만들고
        char[][] matrix = new char[r][c];
        int passwordIdx = 0;
        // 행렬을 채워넣는다. (세로 우선으로)
        for (int i = 0; i<c; i++){
            for (int j = 0; j<r; j++){
                matrix[j][i] = password.charAt(passwordIdx++);
            }
        }

        // 다시 정상적으로 읽으면 평서문을 볼 수 있다.
        for (int i = 0; i<r; i++){
            for (int j = 0; j<c; j++){
                System.out.print(matrix[i][j]);
            }
        }
    }
}
