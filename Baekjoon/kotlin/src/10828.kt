// 문제 링크 : https://www.acmicpc.net/problem/10828
// 제출 공유 링크 : http://boj.kr/a6077912babd4197a06ca2ad19a1acc0

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val stack = Stack<Int>()

    for (i in 0 until readLine().toInt()){
        val commend = readLine().split(" ")

        when (commend[0]){
            "push" -> stack.push(commend[1].toInt())
            "pop" -> if (stack.empty()) println(-1) else println(stack.pop())
            "size" -> println(stack.size)
            "empty" -> if (stack.empty()) println(1) else println(0)
            "top" -> if (stack.empty()) println(-1) else println(stack.peek())
        }
    }
}