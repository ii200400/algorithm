// 문제 링크 : https://www.acmicpc.net/problem/15684
// 제출 공유 링크 : http://boj.kr/0408854323a24fd2be8362535d5f010a
// 참고 블로그 : https://baby-ohgu.tistory.com/3

// 완탐인가..? 시간초과날 것 같은데 일단 해보겠다..

// 속도를 빠르게 하는 방법을 생각해서 해결해보려고 했는데 성공했다.
// boolean dfs 에서 boolean을 반환하는 것인데 true를 반환하면 한 깊이 return 하도록 한다.
// 음.. 사다리 2개를 사용해서 원하는 조작이 가능하다면
// 다른 위치에 사다리 2개를 사용해서 원하는 조작을 살펴볼 필요가 없으니 그것을 생략하도록 하는 것

package com.baekjoon.problem.java15684;

import java.util.Scanner;

public class Main {
    static int n, m, h, total, answer;
    static boolean[][] isLadder;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 세로선 수
        m = sc.nextInt();   // 주어지는 가로선 수
        h = sc.nextInt();   // 사다리의 높이
        /*
        세로선 수가 5이고 높이가 2인 경우 설치할 수 있는 사다리의 위치 번호를 아래와 같이 생각하고 연산할 예정이다.
        0 1 2 3
        4 5 6 7

        세로선 수가 n이고 높이가 h인 경우는..
        0 1 2 3 ... n-1
        ...
        (h-1)(n-1) ... h(n-1)-1
        */
        total = (n-1) * h;  // 사다리를 놓을 수 있는 위치 총합
        isLadder = new boolean[h][n+1]; // 연산의 편리함을 위해 +1

        // 배치된 가로선들 초기화
        for (int i = 0; i<m; i++){
            isLadder[sc.nextInt()-1][sc.nextInt()] = true;
        }

        answer = 4;
        dfs(0, -1);

        // answer가 4이면 -1 아니면 그대로 출력
        System.out.println(answer == 4? -1:answer);
    }

    // 부분집합을 구하듯이 사다리를 설치하고 해제한다.
    // true를 반환하면 한 깊이(cnt) 연산을 무시하고 return 하도록 한다.
    // 이 반환 때문에 속도가 2초정도에서 1초도 안걸리게 된다.
    static boolean dfs(int cnt, int num){
        // answer보다 cnt 크기가 같거나 크면 return
        // 그리고 해당 깊이의 탐색은 다시는 필요 없으므로 true 반환
        if (cnt >= answer){
            return true;
        }

        // 사다리 게임 진행시 각 자리가 원하는 대로 나온다면
        if (game()){
            // cnt 저장 후 true return
            answer = cnt;
            return true;
        }

        // 사다리 선택 진행
        while(++num < total){
            int r = num / (n-1);
            int c = num % (n-1);

            // 양 옆과 현 위치에 사다리가 있다면 패스
            if (isLadder[r][c] || isLadder[r][c+1] || isLadder[r][c+2])
                continue;

            // 사다리 설치가 가능하다면 설치해보고 진행하고
            // (왼쪽 한 칸은 예외처리를 위한 빈칸이므로 +1을 해주어야 원하는 위치가 나온다.)
            isLadder[r][c+1] = true;
            boolean res = dfs(cnt+1, num);
            // 설치 안 해보고 진행해보는 것도 해본다.
            isLadder[r][c+1] = false;

            // 해당 깊이의 연산이 필요 없다면 return
            if (res) return false;

        }

        return false;
    }

    // 게임 진행 시 원하는 결과가 나오면(i 세로선 결과가 i) true, 아니면 false가 나오도록
    static boolean game(){
        // 사다리타기 각 위치 지정
        int[] arr = new int[n+1];
        for (int i = 1; i<n; i++){
            arr[i] = i;
        }

        // 사다리타기 진행
        for (int i = 0; i<h; i++){
            for (int j = 1; j<n; j++){
                // 선을 만날 때 마다 두 위치를 바꿔준다.
                if(isLadder[i][j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        // 모두 원하는 위치에 있는지 확인
        for (int i = 1; i<n; i++){
            if (arr[i] != i){
                return false;
            }
        }

        return true;
    }
}
