// 문제 링크 : https://www.acmicpc.net/problem/2143
// 제출 공유 링크 : http://boj.kr/2d69b72bb87948469a353f0be7edab29

// kolin이 python 처럼 int범위를 벗어나면 자동으로 long으로 바꿔주는 줄 알고 엄청 해맷다.
// 33번째 줄의 .toLong()이 없어서 오버플로우가 나면서 계속 틀렸었다.

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val t = nextInt()
    val a = Array(nextInt()) { nextInt() }
    val b = Array(nextInt()) { nextInt() }
//    println(a.contentToString())

    fun makeMap(array: Array<Int>): Map<Int, Int> {
        val map = mutableMapOf<Int, Int>()
        for (start in array.indices) {
            var sum = 0
            for (idx in start until array.size) {
                sum += array[idx]
                map[sum] = if (map[sum] == null) 1 else map[sum]!! + 1
            }
        }

        return map
    }
    val mapA = makeMap(a)
    val mapB = makeMap(b)

    var answer: Long = 0
    for (keyA in mapA.keys){
        val keyB = t-keyA
        if (mapB[keyB] != null) answer += mapA[keyA]!!.toLong() * mapB[keyB]!!
    }
    println(answer)
}