// 문제 링크 : https://www.acmicpc.net/problem/13244
// 제출 공유 링크 : http://boj.kr/9d290605611f4b0ea933b35ab7d8d38c
// 참고 : https://ssungkang.tistory.com/entry/Algorithm-%EC%9C%A0%EB%8B%88%EC%98%A8-%ED%8C%8C%EC%9D%B8%EB%93%9CUnion-Find

// 유니온 파인드(union-find)를 활용해서 풀 예정이다.

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    // 유니온 파인드 id 저장
    var parents = emptyArray<Int>()

    // id 검색
    fun searchId(v: Int): Int{
        if (v == parents[v]) return v

        parents[v] = searchId(parents[v])
        return parents[v]
    }
    // id 통합 + 사이클이 생기는지 확인
    fun union(v1: Int, v2: Int): Boolean{
        if (searchId(v1) == searchId(v2)) return true
        parents[searchId(v1)] = parents[searchId(v2)]
        return false
    }
    // 트리가 하나인지 확인
    fun isSingleTree(n: Int): Boolean{
        val id = searchId(1)
        for (j in 2 until n){
            if (id != searchId(j)) return false
        }
        return true
    }

    // 테스트 케이스 수 만큼 반복
    for (i in 0 until t) {
        val n = readLine().toInt()
        parents = Array(n + 1) { idx -> idx }

        // 간선 수 만큼 반복
        val edges = Array(readLine().toInt()) {readLine().split(" ").map { it.toInt() }.toTypedArray()}
        var isGraph = false
        for ((v1, v2) in edges){
            if (union(v1, v2)) {
                isGraph = true
                break
            }
        }
        if (isGraph || !isSingleTree(n)) println("graph")
        else println("tree")
    }
}
