// 문제 링크 : https://www.acmicpc.net/problem/10828
// 제출 공유 링크 : http://boj.kr/a6077912babd4197a06ca2ad19a1acc0

// 자료구조 스택 기초 문제 1
// 자료구조 스택 기초 문제 2는 백준 9012번 참고

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main10828() = with(BufferedReader(InputStreamReader(System.`in`))){
    val stack = Stack<Int>()

    for (i in 0 until readLine().toInt()){
        val commend = readLine().split(" ")

        when (commend[0]){
            "push" -> stack.push(commend[1].toInt())
            "pop" -> if (stack.empty()) println(-1) else println(stack.pop())
            "size" -> println(stack.size)
            "empty" -> println(if (stack.empty()) 1 else 0)
            "top" -> println(stack.lastOrNull() ?: -1)
        }
    }
}