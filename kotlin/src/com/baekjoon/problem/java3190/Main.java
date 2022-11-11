// 문제 링크 : https://www.acmicpc.net/problem/3190
// 제출 공유 링크 : http://boj.kr/26de46659e574f3c950c21b0dc595e5c

// 실재로 해본 경험이 있는 게임 같은데..? 어쨋든
// 일단 뱀을 이동하는데 사용할 자료구조는 큐를 선택할 것이다. 선입후출의 위치 이동을 보이기 때문.
// 해시셋까지 사용해야하나 싶었는데 사과 개수가 최대 100개라서 ㅎㅎ;
// 그냥 큐에 있는지 없는지 확인하는 함수를 사용하면 될 것 같다.
// 또한 사과의 위치는 해시셋으로 관리해준다.

// 시간초과 나는 줄 알았더니 그냥 프로그램이 입력을 기다리고 있었다.
// 예외처리 할게 왜 이리 많아;; 정말 알고리즘 없이 곤란한 문제였다.

package com.baekjoon.problem.java3190;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 해시 셋과 큐의 원소 일치 여부 확인을 위해 따로 클래스 사용
    static class Position {
        int r, c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (r != position.r) return false;
            return c == position.c;
        }

        @Override
        public int hashCode() {
            int result = r;
            result = 31 * result + c;
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 보드 크기
        HashSet<Position> apples = new HashSet<>();    // 사과 위치

        // 사과 위치 초기화
        int appleNum = sc.nextInt();
        for (int i = 0; i < appleNum; i++) {
            apples.add(new Position(sc.nextInt(), sc.nextInt()));
        }

        Queue<Position> snake = new LinkedList<>();    // 뱀의 위치
        Position current = new Position(1, 1);  // 뱀의 머리 위치
        snake.add(current); // 뱀 위치 초기화
        int[] d = new int[]{0, 1};  // 이동 방향
        int playtime = 0;   // 게임 시간

        int turnInfo = sc.nextInt(), cnt = 1;    // 방향 회전 회수
        int turnTime = sc.nextInt();    // 회전하는 시간
        char turn = sc.next().charAt(0);    // 회전하는 방향

        // 한칸씩 이동하는데
        while (true){
            playtime++;
            int r = current.r + d[0];
            int c = current.c + d[1];

            // 보드판을 넘어가거나 자신의 몸과 부딪히면 바로 출력 후 끝
            if (r <= 0 || n < r || c <= 0 || n < c || snake.contains(new Position(r, c))){
                System.out.println(playtime);
                return;
            }

            // 머리부터 이동하고
            current = new Position(r, c);
            snake.add(current);

            // 이동하는 위치에 사과가 있다면 사과 삭제
            if (apples.contains(current)) {
                apples.remove(current);
                
            }else{  // 이동하는 위치에 사과가 없다면 꼬리 삭제
                snake.poll();
            }

            if (playtime == turnTime) {
                int temp = d[0];
                if (turn == 'L') {   // 왼쪽으로 턴
                    d[0] = -d[1];
                    d[1] = temp;
                } else {  // 오른쪽으로 턴
                    d[0] = d[1];
                    d[1] = -temp;
                }

                if (turnInfo != cnt) {  // 안 사용하면 입력을 기다린다고 가만히 있는다.
                    cnt++;
                    turnTime = sc.nextInt();    // 다음 회전하는 시간
                    turn = sc.next().charAt(0);    // 다음 회전하는 방향
                }
            }
        }
    }
}
