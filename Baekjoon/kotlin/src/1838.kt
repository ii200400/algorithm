// 문제 링크 : https://www.acmicpc.net/problem/10845
// 백준 공유 링크 : http://boj.kr/126316f9f1bb4c8a936f2b8cc41a7315

// 알고리즘 버블 정렬 기초 문제.. 인 줄 알았으나 정렬을 활용한 무언가의 문제이다..

// A : 정렬을 해야할 숫자 리스트
// Across : 정렬 중 숫자가 이동한 횟수를 저장하는 변수가 추가된 리스트

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main1838() = with(BufferedReader(InputStreamReader(System.`in`))) {
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

//    println(A.contentDeepToString())
    var answer = 0
    for ((i, value) in A.withIndex()) answer = min(i-value[1], answer)
    println(-answer)
}
