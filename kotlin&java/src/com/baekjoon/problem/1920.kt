// 문제 링크 : https://www.acmicpc.net/problem/1920
// 제출 공유 링크 : http://boj.kr/3126efc29cab49178847e91e2d163754

// 해시를 사용하여 숫자를 키로 넣고
// 나중에 숫자가 있는지 탐색할 때 있다면 1 없다면 0을 출력하도록 하였다.

package com.baekjoon.problem

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    readLine()
    // 해시 사용
    val a = mutableMapOf<Int, Boolean>()
    for (i in readLine().split(" ").map { it.toInt() }){
        a[i] = true // 숫자를 키로 넣는다.
    }

    readLine()
    for (i in readLine().split(" ").map { it.toInt() }){
        // 찾는 숫자가 해시에서 찾아진다면 1을, 그렇지 않다면 0을 출력한다.
        println(if(a.getOrDefault(i, false)) 1 else 0)
    }
}