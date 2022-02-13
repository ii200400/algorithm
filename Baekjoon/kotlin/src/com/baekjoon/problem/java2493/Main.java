// 문제 링크 : https://www.acmicpc.net/problem/2493
// 제출 공유 링크 : http://boj.kr/a0312fd9a6cb4673b3285164d6534922

// 유명한 문제라고 하셨는데 진짜 푼 기억이 있어서 놀랐다..
// 그런데 어디서 풀었는지는 모르겠다. 학교 자료구조 시간에 교수님이 설명한 문제 중 하나라고 생각하고 있다.

// 아주 이쁜 스택문제 역순으로 탐색하면 깔끔하게 해결이 가능하다.

package com.baekjoon.problem.java2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] receive = new int[n];
        Stack<int[]> stack = new Stack<>();

        // 뒤에서부터 타워의 높이를 읽어오면서 작업을 진행한다.
        String[] heightStr = br.readLine().split(" ");
        for (int i = n-1; 0<=i; i--){
            // 다음 타워의 높이보다 낮은 스택의 타워들을 receive에 기록한다.
            int height = Integer.parseInt(heightStr[i]);
            while(!stack.isEmpty() && stack.peek()[0] < height){
                int[] info = stack.pop();
                receive[info[1]] = i;
            }

            // stack에 현재 타워 데이터(높이, 인덱스) 추가
            stack.add(new int[] {height, i} );
        }

        // 스택의 남은 데이터 처리
        while(!stack.isEmpty()){
            int[] info = stack.pop();
            receive[info[1]] = -1;
        }

        // 결과 출력
        for (int i = 0; i<n; i++) {
            System.out.print((receive[i]+1)+" "); // 타워가 1부터 시작하기 때문에 +1
        }
    }
}
