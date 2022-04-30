// 문제 링크 : https://www.acmicpc.net/problem/5639
// 제출 공유 링크 : http://boj.kr/355c8a8c92c5424090bdd2d008c66989
// 백준 이진 검색 트리

// 스택을 활용하여 풀었다. 자면서 생각했더니 될 것 같아서..
// .. 스택으로 삽질하다가 안되는 것을 늦게 알고 다른 문제부터 풀고 있다.
// 3시간 삽질에 건강이 좋아진 기분이 든다..^ㅠ^

// 다른 문제 풀고 다시 보니 조건을 잘못 설정했다는 생각이 들어서
// 스택 알고리즘에서 조금 고쳐봤더니 잘 나오는 것 같다.
// 음.. 거의 어거지로 푼 것 같다;; 스캐너를 버퍼로 바꿔주니 통과는 되었는데 시간이 어마어마하게 오래걸린다.
// 기억상 이전에도 트리 안만든다고 X꼬쇼를 했었는데 오늘도 한 것 같다;
// 편향 트리인 경우일 것이다. 보통의 트리는 nlogn인데 편향트리는 n^2이다.

// 아니.. 입력 종료를 ctrl D로 강제종료시켜주는 문제도 다 봤네;;
// 입력값을 어떻게 해주어야 진행이 되는거야아아아아강가아가

/**
 * 내가만든 테케
50
30
24
28
29
45
47
46
48
98
52
51
53
60
100
101
 */

package com.baekjoon.problem.java5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();   // 후위 순회로 바꿔주기 위해 스택 사용
//        stack.add(sc.nextInt()); // 스택 초기화
        stack.add(Integer.parseInt(br.readLine()));
//        while (sc.hasNextInt()) {
        while (true){
            // 전위 순회한 결과를 하나씩 읽어온다.
//            int num = sc.nextInt();
            String s = br.readLine();
            if (s == null) break;
            int num = Integer.parseInt(s);

            if (num > stack.peek()){ // 스택의 가장 위 수보다 크다면
                // 현재 수 보다 작으면서 가장 큰 수를 찾고
                int max = 0, maxIdx = -1;
                for (int idx = stack.size() - 1; idx >= 0 && num > stack.get(idx); idx--) {
                    if (max < stack.get(idx)){
                        max = stack.get(idx);
                        maxIdx = idx;
                    }
                }

                // 해당 수 까지 출력해버린다.
                int compareWith = stack.get(maxIdx);
                for (int tempIdx = stack.size() - 1; stack.get(tempIdx) < compareWith; tempIdx--) {
                    System.out.println(stack.pop());
                }
            }

            // 현재 수를 스택에 넣는다.
            stack.add(num);
        }

        // 남은 수를 모두 출력한다.
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
