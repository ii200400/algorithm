// 문제 링크 : https://www.acmicpc.net/problem/1874
// 제출 공유 링크 : http://boj.kr/b3ad24ccc15149fdbfa0cadcf13a896f

// 스택을 활용하여 풀었다.
// 음.. 본인이 해당 문제를 메모지에 손으로 풀 때 사용한 방식을 그대로 코드로 구현하여 풀었다.

package com.baekjoon.problem.java1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        // 변수 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] ops = new char[2*n];; // 연산 저장 배열
        Stack<Integer> stack = new Stack<>(); // 스택

        int nextInt; // 다음에 pop 해야하는 수열
        int num = 1; // 다음에 push할 숫자
        int opsIdx = 0; // op 배열의 인댁스

        // n개의 수열을 읽어오면서 작업을 진행한다.
        for (int i = 0; i<n; i++){
            nextInt = Integer.parseInt(br.readLine());

            if (num-1 < nextInt){ // 다음 수열이 넣었던 수 들의 최대값 보다 클 때
                while (num != nextInt){
                    stack.push(num);
                    ops[opsIdx++] = '+';
                    num++;
                }

                ops[opsIdx++] = '+';
                num++;
                ops[opsIdx++] = '-';

            }else if (num-1 > nextInt){  // 다음 수열이 넣었던 수 들의 최대값 보다 작을 때
                // 바로 스택에서 꺼낼 수 있는 수가 아니라면
                if (stack.peek() != nextInt) {
                    // 수열을 만들 수 없으므로 no를 출력하고 프로그램을 종료한다.
                    System.out.println("NO");
                    return;
                }

                // 수열을 만들 수 있다면 그대로 작업을 진행한다.
                stack.pop();
                ops[opsIdx++] = '-';
            }
        }

        // 연산자들 출력
        for (char op : ops) {
            System.out.println(op);
        }
    }
}
