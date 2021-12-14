// 문제 링크 : https://www.acmicpc.net/problem/1285
// 제출 공유 링크 : http://boj.kr/6f840e158d3e4a489af48d3858c0d0b9

// 자료구조 스택 기초 문제 2
// 자료구조 스택 기초 문제 1는 백준 10828번 참고

// 굳이 스택 자료형을 쓸 필요는 없어서 단순히 Int 변수형으로 스택을 대체하였다.

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    fun isVPS(ps: String): Boolean{
        var stack = 0

        for (ch in ps){
            when (ch){
                '(' -> stack += 1
                ')' -> {
                    if (stack > 0) stack -= 1
                    else return false
                }
            }
        }

        return stack <= 0
    }

    for (i in 0 until readLine().toInt()){
        if (isVPS(readLine())) println("YES")
        else println("NO")
    }
}