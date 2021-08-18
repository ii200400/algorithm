// 문제 링크 : https://www.acmicpc.net/problem/14500
// 제출 공유 링크 : http://boj.kr/1cb6cb525b394416b3c479bae1a77528
// 제출 공유 링크 : http://boj.kr/cd2031470b6e4483a1ee6bbcebb93148 (속도 개선)
// 제출 공유 링크 : http://boj.kr/fd43d61acb484b7e8ac29b4df742570b (listOf를 array 형식들로 변경, 현 코드)
// 참고 : https://myjamong.tistory.com/141

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val form = arrayOf(
        // 1,4 idx 0
        arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3)),
        // 2,3 idx 1~8
        arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 0)),
        arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 1)),
        arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2)),

        arrayOf(intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(1, 1), intArrayOf(1, 2)),
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 1), intArrayOf(1, 2)),
        arrayOf(intArrayOf(0, 2), intArrayOf(1, 0), intArrayOf(1, 1), intArrayOf(1, 2)),

        arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 1), intArrayOf(1, 2)),
        arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 0), intArrayOf(1, 1)),

        //3,2 idx 9~16
        arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 1), intArrayOf(2, 1)),
        arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(1, 1), intArrayOf(2, 1)),
        arrayOf(intArrayOf(2, 0), intArrayOf(0, 1), intArrayOf(1, 1), intArrayOf(2, 1)),

        arrayOf(intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(0, 1)),
        arrayOf(intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(1, 1)),
        arrayOf(intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(2, 1)),

        arrayOf(intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(1, 1), intArrayOf(2, 1)),
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 1), intArrayOf(2, 0)),
        // 2,2 idx 17
        arrayOf(intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(1, 1)),
        // 4,1 idx 18
        arrayOf(intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 0))
    )

    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val paper = List(n) { readLine()!!.split(" ").map { it.toInt() } }
//    println(paper)

    fun searchMax(iLimit: Int, jLimit: Int, start: Int, end: Int): Int {
        var max = 0
        for (i in 0 until n - iLimit) {
            for (j in 0 until m - jLimit) {
                // 각 형태마다
                for (idx in start..end) {
                    // 네칸의 숫자를 모두 더함
                    var sumTemp = 0
                    for (temp in 0 until 4) {
                        sumTemp += paper[i + form[idx][temp][0]][j + form[idx][temp][1]]
                    }
                    max = max(max, sumTemp)
                }
            }
        }

        return max
    }

    var maxSum = 0
    maxSum = max(maxSum, searchMax(0, 3, 0, 0))
    maxSum = max(maxSum, searchMax(1, 2, 1, 8))
    maxSum = max(maxSum, searchMax(2, 1, 9, 16))
    maxSum = max(maxSum, searchMax(1, 1, 17, 17))
    maxSum = max(maxSum, searchMax(3, 0, 18, 18))


    println(maxSum)
}