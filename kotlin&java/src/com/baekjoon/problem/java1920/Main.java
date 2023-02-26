// 문제 링크 : https://www.acmicpc.net/problem/1920
// 제출 공유 링크 : http://boj.kr/f97c5d7c66284624913910c83cf2b881

// 이번에는 set을 사용해보았다.
// 숫자를 하나씩 넣고 size가 커지면 0 그렇지 않으면 1을 출력하도록 하였다.

package com.baekjoon.problem.java1920;

import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // hashset에 하나씩 입력
        int size = sc.nextInt();
        HashSet<Integer> a = new HashSet<>();
        for (int i = 0; i<size; i++){
            a.add(sc.nextInt());
        }

        int savedSize = a.size();
        int times = sc.nextInt();
        for (int i = 0; i<times; i++){
            // 탐색할 숫자를 set에 추가하고
            a.add(sc.nextInt());
            if (a.size() == savedSize)
                // 크기가 같으면 같은 숫자가 있다는 의미이므로 1을 출력
                System.out.println(1);
            else{
                // 그렇지 않으면 0을 출력한다.
                System.out.println(0);
                savedSize++;
            }
        }
    }
}
