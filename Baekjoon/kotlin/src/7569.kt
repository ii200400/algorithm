// 문제 링크 : https://www.acmicpc.net/problem/7569
// 제출 공유 링크 : http://boj.kr/2f1efa65b96b4d8a8730ccd9bab26688

// 아.. M-N-H로 했었어야하는데 X-Y-Z로 네이밍을 이미 해버렸다.. 실쑤 헤헷

import java.util.*

val searchX = arrayOf(1,-1,0,0,0,0)
val searchY = arrayOf(0,0,1,-1,0,0)
val searchZ = arrayOf(0,0,0,0,1,-1)
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val queue: Queue<Array<Int>> = LinkedList()
    val (x, y, z) = arrayOf(nextInt(), nextInt(), nextInt())
    var dayCount = 0
    val box = MutableList(z) { z ->
        MutableList(y) { y ->
            MutableList(x) { x ->
                val state = nextInt()
                if (state == 1) queue.add(arrayOf(x, y, z, 0))
                state
            }
        }
    }
    //    println(box)

    fun rip() {
        val (tempX, tempY, tempZ, day) = queue.poll()
        for (idx in searchX.indices) {
            val movedX = tempX + searchX[idx]
            val movedY = tempY + searchY[idx]
            val movedZ = tempZ + searchZ[idx]
            if (
                movedX in 0 until x && movedY in 0 until y && movedZ in 0 until z &&
                box[movedZ][movedY][movedX] == 0
            ) {
                dayCount = day+1
                box[movedZ][movedY][movedX] = 1
                queue.add(arrayOf(movedX, movedY, movedZ, day+1))
            }
        }
    }

    while (queue.isNotEmpty()) {
        rip()
    }

    fun isAllRipped(): Int {
        for (oneLayer in box) {
            for (oneRow in oneLayer) {
                if (0 in oneRow) {
                    return -1
                }
            }
        }
        return dayCount
    }
    println(isAllRipped())
}