// 문제 링크 : https://www.acmicpc.net/problem/10845
// 백준 공유 링크 : http://boj.kr/126316f9f1bb4c8a936f2b8cc41a7315

// 자료구조 큐 기초 문제 1
// 자료구조 큐 기초 문제 2는 1158번 참고

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main10845() = with(BufferedReader(InputStreamReader(System.`in`))){
    val queue: Queue<Int> = LinkedList()

    for (i in 0 until readLine().toInt()){
        val commend = readLine().split(" ")
        when(commend[0]){
            "push" -> queue.offer(commend[1].toInt())
            "pop" -> println(queue.poll() ?: -1)
            "size" -> println(queue.size)
            "empty" -> println(if (queue.isEmpty()) 1 else 0)
            "front" -> println(queue.firstOrNull() ?: -1)
            "back" -> println(queue.lastOrNull() ?: -1)
        }
    }
}