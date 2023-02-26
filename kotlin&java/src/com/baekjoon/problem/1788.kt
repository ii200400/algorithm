// 문제 링크 : https://www.acmicpc.net/problem/1788
// 제출 공유 링크 : http://boj.kr/09e6aa8c0bc642cbb94e7d15c90d3100

// 한번 공책에 끄적거리면서 고민해봤더니 n의 절대값이 같다면 F(n)의 절대값도 같다는 사실을 알았다.
// ex) F(-2)=-1, F(2)=1, F(-3)=2, F(3)=2 ...
// 위의 사실을 토대로 답을 구할 예정이다.

package com.baekjoon.problem

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = readLine().toInt()

    // n=0일 때, 예외처리를 넣은 첫째줄 출력
    // 예외처리를 하지 않으면 fibArray[1] = 1 에서 인덱스 에러가 생긴다.
    if (n == 0) {
        println(0)
        println(0)
        return
    }
    else if (n < 0 && n%2 == 0) println(-1)
    else println(1)

    // n번째 피보나치 수를 구한다.
    n = abs(n)
    val fibArray = Array(n+1) { 0 }
    fibArray[1] = 1
    for (idx in 2 until fibArray.size){ 
        // 1000000000으로 나눠서 출력하는 조건과 
        // int 자료형의 크기를 넘기지 않기 위해서 % 1000000000 사용
        fibArray[idx] = (fibArray[idx-1] + fibArray[idx-2]) % 1000000000
    }

    println(fibArray.last())
}
