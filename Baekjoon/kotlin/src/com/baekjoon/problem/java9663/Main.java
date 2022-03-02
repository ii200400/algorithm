// 문제 링크 : https://www.acmicpc.net/problem/9663
// 제출 공유 링크 : http://boj.kr/8c1c595d74c54c3e946b622a60251c6a

// 옛날 옛적에 한 번 시도해보고 실패가 박힌 이후로 어쩌다보니 안풀었는데
// 드디어 오늘 실패 표시를 벗겨내겠다!
// 그래도 3344번은 엄두도 안난다;;

package com.baekjoon.problem.java9663;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    int n, answer;
    int col[];

    Main(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // 체스판 크기
        col = new int[n];   // 해당 열에 놓인 퀸 존재 여부
        answer = 0; // n크기의 체스판에 n개의 퀸을 놓을 수 있는 경우의 수

        // 퀸 놓기 ()
        queen(0);

        System.out.println(answer);
    }

    // 현재까지 놓은 퀸의 수(idx번째)를 파라미터로 넘겨주면서
    // n개의 퀸을 놓을 수 있는 경우의 수를 세는 함수
    void queen(int idx){
        // 모든 퀸을 놓았다면 다른 경우를 찾으러 돌아간다.
        if (idx == n){
            answer++;
            return;
        }

        // idx 번째 줄에 한 칸씩
        for (int i = 0; i<n; i++){
            // 퀸을 놓아보고
            col[idx] = i;
            // 서로 공격하는 퀸이 없다는 것이 판명되면
            if (isAvailable(idx))
                // 다음 퀸을 놓는 것을 진행해본다.
                queen(idx+1);


        }
    }

    boolean isAvailable(int row){
        for (int i = 0; i<row; i++){
            if (col[i] == col[row] || Math.abs(i-row) == Math.abs(col[i]-col[row]))
                return false;
        }

        return true;
    }
}
