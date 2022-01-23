// 문제 링크 : https://www.acmicpc.net/problem/2839
// 제출 공유 링크 : http://boj.kr/623e8c517479488cb6b5b6beae20c048

// 백준의 '단계별로 풀어보기' 카테고리의 8단계 '기본 수학 1' 7번 문제
// 이러한 유형의 문제를 기본수학으로 풀 수 있다는 점을 보고 흥미를 느껴 풀었다.
// 크게 어렵지는 않았으나 문제 분류를 보지 않았다면 브루트 포스로 풀었을 지도 모르겠다.
// 더 문제 유형을 익혀야겠다고 생각했다.

// 손으로 무개 20정도 까지 풀어보면 5개마다 반복되는 패턴을 볼 수 있다.
// 해당 패턴을 토대로 총 얼마의 봉지가 필요한지 쉽게 유추하여 값을 출력할 수 있다.

package com.baekjoon.problem

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    println(if (n in arrayOf(1,2,4,7)) -1
        else mapOf(0 to 0, 1 to 1, 2 to 2, 3 to 1, 4 to 2)[n%5]?.plus(n/5)
    )
}