// 문제 링크 : https://www.acmicpc.net/problem/1712
// 제출 공유 링크 : http://boj.kr/160b1a84d7e64b15a1d969237161d4ee

// 백준의 '단계별로 풀어보기' 카테고리의 8단계 '기본 수학 1' 1번 문제
// 쉬워보이는데 비하여 그렇지 않은 정답비율이 신경쓰여 풀어보았다.
// 음.. 모르겠다. 아직 안 익숙하신 분들이 int 대신 long 사용하는 것을 잊으셨나..?

package com.baekjoon.problem

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (a, b, c) = readLine().split(" ").map { it.toLong() }
    println(if (c > b) a/(c-b)+1 else -1)
}