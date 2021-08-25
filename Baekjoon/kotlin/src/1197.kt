// 문제 링크 : https://www.acmicpc.net/problem/1197
// 제출 공유 링크 : http://boj.kr/d341a35ed1604dcbb430f76004b9b20f

// 처음에는 프림/크루스칼 알고리즘 중에서 어떤 것으로 구현할지 고민 중이다.
// 현재는 프림 알고리즘으로 구현 중

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (v, e) = readLine().split(" ").map { it.toInt() }
    val vertexWeights = Array(v+1) { arrayListOf<Pair<Int, Int>>() } // 인덱스 1부터 시작
    for (i in 0 until e){
        val (v1, v2, weight) = readLine().split(" ").map { it.toInt() }
        vertexWeights[v1].add(Pair(v2, weight))
        vertexWeights[v2].add(Pair(v1, weight))
    }
//    println(weights.contentDeepToString())
    // 이미 연결된 노드인지 확인을 위함, 인덱스 1부터 시작
    val isLinked = Array(v+1) { i -> i == 0 }
    val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    heap.addAll(vertexWeights[1])
    isLinked[1] = true

    var weightSum = 0
    while (true) {
        val (vertex, weight) = heap.poll() ?: break
        if (isLinked[vertex]) continue

        heap.addAll(vertexWeights[vertex])
        isLinked[vertex] = true
        weightSum += weight

        if (!isLinked.any { !it }) break
    }

    println(weightSum)
}