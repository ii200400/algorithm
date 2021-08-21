// 문제 링크 : https://www.acmicpc.net/problem/1285
// 제출 공유 링크 : http://boj.kr/6f840e158d3e4a489af48d3858c0d0b9

// 처음에는 그리디로 풀 수 있을 것 같다고 생각했는데 안되는 반례를 떠올려서 부루트 포스로 해결하려한다.

// 비트마스크와 그리디를 활용해서 푼다는 것을 오해하였다는 것을 늦게 알았다.
// 비트마스크를 사용하지는 않았지만 (왜 사용하는지 잘 모르겠다, 코틀린을 쓴 다른 사람들을 보니 모두 비트 마스크를 썼는데.. 동전 배열 저장 형식이 mutableList인지 Array인지 로 나뉜다;;)
// 충분히 재귀로 풀 수 있어 보여 재귀로 풀어버렸다.

// 오히려 행 부분을 어떤 방식이든 완전탐색을 사용하고 열 부분은 그리디하게 계산하는 것이 더 중점적인 문제였다.

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val map = Array(n){ readLine().map { it == 'H' }.toTypedArray() }
    var minTail = 400
//    println(map.contentDeepToString())

    // 열을 기준으로 탐색하면서 tail이 가장 적은 경우를 센다.
    fun countTail(): Int{
        var count = 0
        for (i in 0 until n){
            var greedyCount = 0
            // head와 tail 중 더 작은 값을 더한다. (어차피 뒤집을 수 있기 때문에 가능한 연산)
            for (j in 0 until n) if (!map[j][i]) greedyCount += 1
            count += min(greedyCount, n-greedyCount)
        }

        return count
    }

    fun reverseRow(idx: Int){
        for (i in 0 until n) map[idx][i] = !map[idx][i]
    }
    fun searchRow(idx: Int){
        if (idx == n) minTail = min(minTail, countTail())
        else{
            searchRow(idx+1)
            reverseRow(idx)
            searchRow(idx+1)
        }
    }

    // 행을 뒤집을 수 있는 모든 가지 수 확인 시작
    searchRow(0)
    println(minTail)
}