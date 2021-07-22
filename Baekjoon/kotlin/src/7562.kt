// 문제 링크 : https://www.acmicpc.net/problem/7562
// 제출 공유 링크 : http://boj.kr/e86f1fc2fe9641d9bf5e797dd0fc4ab9

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val moveX = listOf(1,2,2,1,-1,-2,-2,-1)
    val moveY = listOf(2,1,-1,-2,-2,-1,1,2)

    val queue: Queue<List<Int>> = LinkedList()
    lateinit var map: MutableList<MutableList<Int>>

    for (i in 0 until nextInt()){
        queue.clear()

        val mapLen = nextInt()
        map = MutableList(mapLen){MutableList(mapLen){0}}

        val startX = nextInt(); val startY = nextInt()
        queue.add(listOf(startX, startY, 0))
        map[startX][startY] = 1

        val goal = listOf(nextInt(), nextInt())
        while (true){
            val step = queue.poll()
            if (step[0] == goal[0] && step[1] == goal[1]) {
                println(step[2])
                break
            }

            for (idx in moveX.indices){
                val x = step[0]+moveX[idx]
                val y = step[1]+moveY[idx]
                if (x in 0 until mapLen && y in 0 until mapLen && map[x][y] == 0){
                    queue.add(listOf(x, y, step[2]+1))
                    map[x][y] = 1
                }
            }
        }
    }
}