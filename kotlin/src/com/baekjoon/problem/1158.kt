// 문제 링크 : https://www.acmicpc.net/problem/10845
// 백준 공유 링크(링크드 리스트) : http://boj.kr/126316f9f1bb4c8a936f2b8cc41a7315
// 백준 공유 링크(큐) : http://boj.kr/13797d6b38d145c487e7727b6ac936e2

// 자료구조 큐 기초 문제 1는 10845번 참고
// 자료구조 큐 기초 문제 2

// 두 가지 방법이 생각나 각각 구현하였다.
// 단순히 링크드 리스트로 풀이하는 방법과
// 큐를 이용해서 문제에서 서술된 것과 같이 빼고 넣고를 반복 풀이하는 방법으로 해결해 보았다.

// 전자의 방법으로는 24424KB 196ms 후자의 방법으로는 196172KB 408ms이 걸렸다.
// 알고리즘 분류에 왜 큐가 들어가 있는지 잘 모르겠다..
// 차라리 원을 따라 사람을 제거해 나갈때 지나치는 사람이 가지는 숫자를 모두 더한 값을 출력하라고 하면
// 큐를 활용할 수 밖에 없었을 텐데..
// 9012번 문제도 그렇고 큐에 저장된 값을 활용하지 않아 아쉬운 문제였다.

package com.baekjoon.problem

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 링크드 리스트와 수학 계산으로 풀이
    fun useLinkedList(n: Int, k: Int) {
        val linkedList = LinkedList(List(n) { it + 1 })
        val answer = Array(n) { 0 }
        var position = 0

        while (linkedList.isNotEmpty()) {
            position = (position + k - 1) % linkedList.size
            answer[n - linkedList.size] = linkedList.elementAt(position)
            linkedList.removeAt(position)
        }

        println(answer.joinToString(", ", "<", ">"))
    }

    // 큐를 활용하여 풀이
    fun useQueue(n: Int, k: Int) {
        val queue: Queue<Int> = LinkedList(List(n) { it + 1 })
        val answer = Array(n) { 0 }

        while (queue.isNotEmpty()) {
            for (i in 0 until ((k - 1) % queue.size)) queue.offer(queue.poll())
            answer[n - queue.size] = queue.poll()
        }

        println(answer.joinToString(", ", "<", ">"))
    }

    val (n, k) = readLine().split(" ").map { it.toInt() }
//    useLinkedList(n, k)
    useQueue(n, k)
}