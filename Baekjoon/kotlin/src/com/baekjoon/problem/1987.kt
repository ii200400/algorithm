// 문제 링크 : https://www.acmicpc.net/problem/1987
// 제출 공유 링크 : http://boj.kr/79700c91e73f41e48be5e8e64217fe05

// 재귀함수를 통해 DFS 를 구현하여 완전탐색으로 해결하였다.
// 다녀간 곳의 알파벳을 기억하는 것 외에 특별한 점이 없다.

// r, c : 맵의 가로, 세로 길이
// map : 알파뱃이 부여된 맵

package com.baekjoon.problem

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (r, c) = readLine().split(" ").map { it.toInt() }
    val map = Array(r){ readLine() }
    var answer = 0

    fun search(row: Int, col: Int, step: Int, alpha: MutableSet<Char>){
        if (map[row][col] in alpha){
            if (step > answer) answer = step
            return
        }

        alpha.add(map[row][col])
        if (row+1 < r) search(row+1, col, step+1, alpha)
        if (row-1 >= 0) search(row-1, col, step+1, alpha)
        if (col+1 < c) search(row, col+1, step+1, alpha)
        if (col-1 >= 0) search(row, col-1, step+1, alpha)
        alpha.remove(map[row][col])
    }
    search(0, 0, 0, mutableSetOf())

    println(answer)
}
