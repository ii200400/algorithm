// 문제 링크 : https://www.acmicpc.net/problem/13913
// 제출 공유 링크 : http://boj.kr/aed8485a7d99497da24ed4246dc533e6

// 키야~ 이번 변형도 마음에 든다. 경로를 찾는 방법은 disjoint set을 활용할 예정이다.
// disjoint 배열을 사용해서 현 위치에서 갈 수 있는 위치에 현 위치 숫자를 저장하고
// 나중에 동생 위치를 찾으면 서로소 집합의 root를 찾듯이 탐색하면서 출력할 예정

// 예를 들어..(-1은 미방문을 의미)
// [ -1, -1, -1, -1, -1,  0, -1, -1, -1,  5, -1, -1, -1, -1,  9, -1, -1,  14, -1, -1, .. ]
//    0   1   2   3   4   5   6   7   8   9   0   1   2   3   4   5   6   7   8   9  ..
// 라는 배열이 있고(실재로는 이런 배열로 만들어지지는 않을테지만;) 5인덱스에 있는 언니가 17인덱스의 동생을 찾았다면
// 17출력 - 17인덱스의 숫자 14로 이동 - 14출력 - 14인덱스의 숫자 9로 이동 - 9출력 - 9인덱스의 숫자 5로 이동 - 5출력
// 위와 같은 느낌으로 출력할 예정이다.

package com.baekjoon.problem.java13913;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] disjoint;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 수빈 위치
        int m = sc.nextInt();   // 동생 위치
        // 경로를 찾는 방법이 서로소 집합의 루트를 찾는 방법과 같아서 아래와 같은 변수명을 지었다.
        disjoint = new int[100001];   // 경로 배열, 가장 빠른 경로로 도달할 시에 방문한 이전 인덱스 번호

        // 경로 배열 초기화 (-1은 방문 경험이 없다는 의미)
        Arrays.fill(disjoint, -1);
        disjoint[n] = n;  // 현 위치 초기화

        // 큐 초기화
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        // bfs시작
        int depth = 0;
        while (!q.isEmpty() && disjoint[m] == -1) {   // 동생 위치로 가는 경우의 수가 있다면 탈출
            int size = q.size();
            depth++;

            // 레벨 탐색
            for (int i = 0; i<size; i++) {
                int current = q.poll();

                // 현 위치에서 갈 수 있는 다른 위치를 탐색한다.
                for (int search: new int[]{current+1, current-1, current*2}){
                    // 탐색 위치가 범위를 벗어나면 생략한다.
                    if (search < 0 || search > 100000)
                        continue;

                    // 방문 경험이 없다면
                    if(disjoint[search] == -1){
                        // 큐에 탐색 위치를 추가하고 경로 배열에 현재 위치를 넣어준다.
                        disjoint[search] = current;
                        q.add(search);
                    }
                }
            }
        }

        // 동생 위치로 가는 최소 시간과 모든 경우의 수 출력
        System.out.println(depth);
        printPath(m);
    }

    // n에서 m까지 가는 경로를 출력하는 함수
    // 서로소 집합의 루트를 탐색하듯이 탐색하고 출력한다.
    static void printPath(int a){
        if (disjoint[a] == a){
            System.out.print(a);
            return;
        }
        printPath(disjoint[a]);
        System.out.print(" "+a);
    }
}
