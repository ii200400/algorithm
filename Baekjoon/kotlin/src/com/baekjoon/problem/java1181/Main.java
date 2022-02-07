// 문제 링크 : https://www.acmicpc.net/problem/1181
// 제출 공유 링크 : http://boj.kr/8b6aba5d42a841a79989c14cf18cbe48

// 상대적으로 최근에 푼 것인지 비슷한 문제를 푼 것인지 햇갈렸는데 이 문제도 5년전 문구가 있는 것으로 보아
// 비슷한 다른 문제를 푼 것 같다.

// 단순히 정렬에 자주 사용되는 라이브러리를 사용하여 정렬하였다.
// 그런데.. 코틀린과 함수 사용법이 많이 달라 라이브러리 사용법을 좀 검색하였다..

package com.baekjoon.problem.java1181;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> hs = new HashSet<>();

        int t = sc.nextInt();
        for (int i = 0; i<t; i++){
            hs.add(sc.next());
        }

        // 아니.. 자바는 정렬에 쓰이는 Comparator 왜 이래..
        // 크기와 값을 기준으로 비교를 해주는 Comparator를 생성하고
        Comparator<String> c = Comparator.comparing(String::length).thenComparing(String::valueOf);
        // 위에서 만든 Comparator를 기준으로 정렬한 뒤 출력한다.
        hs.stream().sorted(c).forEach(System.out::println);
    }
}
