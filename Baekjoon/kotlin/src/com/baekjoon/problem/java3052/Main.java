// 문제 링크 : https://www.acmicpc.net/problem/3052
// 제출 공유 링크 : http://boj.kr/be7155b2b49741f1a9f6541db2f52bc1

// 해시 셋 사용해서 나머지가 다른 값이 몇개인지 확인할까.. boolean[]을 사용할까..

package com.baekjoon.problem.java3052;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 나머지들을 저장하는 해시셋
        HashSet<Integer> divides = new HashSet<>();
        for (int i = 0; i<10; i++){
            // 나오는 나머지를 모두 셋에 입력
            divides.add(sc.nextInt()%42);
        }

        // 셋의 크기 출력
        System.out.println(divides.size());
    }
}
