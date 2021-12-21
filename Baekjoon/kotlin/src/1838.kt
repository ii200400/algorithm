// 문제 링크 : https://www.acmicpc.net/problem/1838
// 백준 공유 링크 : http://boj.kr/924fd08cd40c43cda9125313816e5157

// 알고리즘 버블 정렬 기초 문제.. 인 줄 알았으나 아니였다..
// 정확히는 O(nlogn)으로 정렬되는 알고리즘 활용과 버블 정렬의 특징을 잘 파악하였는지 확인하는 문제
// 본인의 경우 합병 정렬을 활용하였다, 라이브러리를 사용해도 되는 것을 확인하였으나 메모리는 10퍼센트 속도는 거의 2배 느린 것을 확인하였다.

// 버블 정렬은 한 사이클을 돌 때마다 남은 숫자들 중 가장 큰 숫자가 가장 뒤로 가고
// 다른 숫자들은 조금씩 자신의 자리를 찾아가는 특징이 있는데...
// 이때 각 숫자가 이동할 시, 왼쪽에서 오른쪽으로는 한 번에 움직일 수도 있지만 오른쪽에서 왼쪽으로 움직이는 것은 한칸밖에 움직이지 못한다는 점을 착안해서 풀면된다.
// 정렬의 특징을 이해하지 못했다면 풀지 못하는 좋은 문제라고 생각한다.

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val A = readLine().split(" ").mapIndexed { i, it -> arrayOf(it.toInt(), i) }.toTypedArray()

    fun mergeSort(A: Array<Array<Int>>, tempA: Array<Array<Int>>, low: Int, high: Int){
        if (low >= high) return

        val mid = (low + high) / 2
        mergeSort(A, tempA, low, mid)
        mergeSort(A, tempA, mid+1, high)

        var leftIdx = low
        var rightIdx = mid+1
        var tempIdx = low
        while (tempIdx <= high){
            when {
                leftIdx > mid -> {
                    tempA[tempIdx] = A[rightIdx]
                    rightIdx += 1
                }
                rightIdx > high -> {
                    tempA[tempIdx] = A[leftIdx]
                    leftIdx += 1
                }
                A[leftIdx][0] <= A[rightIdx][0] -> {
                    tempA[tempIdx] = A[leftIdx]
                    leftIdx += 1
                }
                else -> {
                    tempA[tempIdx] = A[rightIdx]
                    rightIdx += 1
                }
            }

            tempIdx += 1
        }

        for (i in low..high) A[i] = tempA[i]
    }

    mergeSort(A, A.copyOf(), 0, A.size-1)

//    A.sortBy { it[0] }
//
//    println(A.contentDeepToString())
    // 버블 정렬이 언제 끝나는지 확인
    var answer = 0
    for ((i, value) in A.withIndex()) answer = min(i-value[1], answer)
    println(-answer)
}
