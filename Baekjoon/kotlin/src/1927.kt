// 문제 링크 : https://www.acmicpc.net/problem/1927
// 제출 공유 링크 : http://boj.kr/ca51b177328f494c8ea742e2bc991c4f

// 단순한 힙 구현 문제

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main1927() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val minHeap = PriorityQueue<Int>() // PriorityQueue<Int>(reverseOrder()) 를 사용하면 maxHeap

    for (i in 0 until readLine().toInt()){
        when (val num = readLine().toInt()) {
            0 -> println(minHeap.poll() ?: 0)
            else -> minHeap.add(num)
        }
        println(minHeap.toString())
    }
}