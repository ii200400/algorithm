// 문제 링크 : https://www.acmicpc.net/problem/1715
// 제출 공유 링크 : http://boj.kr/9ea6de9e7bd04fcc83eee14454aa903f

// 보자마자 우선순위 큐로 풀면 될것 같아 최소힙을 이용하여 풀었다.
// 예전에는 해당 방법을 알지 못해서 틀린 것 같다.

// count : 비교 횟수
// priorityQueue : 숫자 카드 묶음들을 최소힙방식으로 저장

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main1715() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 변수 초기화
    var count = 0
    val priorityQueue = PriorityQueue<Int>()
    for (i in 0 until readLine().toInt()) {
        priorityQueue.add(readLine().toInt())
    }

    // 최소힙에서 가장 작은 카드 묶음 2개를 고르고 합친 후 다시 넣어주는 과정을
    // 카드 묶음이 1개가 될 때까지 반복
    while (priorityQueue.size != 1){
        val cardSet1 = priorityQueue.poll()
        val cardSet2 = priorityQueue.poll()
        val newCardSet = cardSet1 + cardSet2
        count += newCardSet
        priorityQueue.add(newCardSet)
    }
    println(count)
}