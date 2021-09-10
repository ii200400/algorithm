// 문제 링크 : https://www.acmicpc.net/problem/7576
// 제출 공유 링크 : http://boj.kr/cb904e3883ec4fef92efe79204314ce4

// 너비우선탐색으로 해결할 예정이다.
// m, n : 세로 줄 수, 가로 줄 수
// queue : 너비우선탐색을 위한 큐
// box : 토마토 상자
// lastDay : 토마토가 모두 익었을 시 시간이 얼마나 지났는지 저장하는 변수

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 변수 초기화
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val queue: Queue<Array<Int>> = LinkedList()
    val box = Array(n){ rIdx ->
        val row = readLine().split(" ").map { it.toInt() }.toTypedArray()
        for (cIdx in row.indices) if (row[cIdx] == 1) queue.offer(arrayOf(rIdx, cIdx, 0))
        row
    }
    //println(box.contentDeepToString())

    val directions = arrayOf(arrayOf(1,0), arrayOf(-1,0), arrayOf(0,1), arrayOf(0,-1))
    var lastDay = 0
    // 큐에 들어있는 값이 없을  때까지 반복
    while (queue.isNotEmpty()){
        val (r, c, day) = queue.poll()

        // 상, 하, 좌, 우 탐색 및 익지 않은 토마토가 있으면 익었다고 표시 후, 위치와 날짜를 큐에 저장
        for (dir in directions){
            if (r+dir[0] in 0 until n && c+dir[1] in 0 until m && box[r+dir[0]][c+dir[1]] == 0){
                box[r+dir[0]][c+dir[1]] = 1
                queue.offer(arrayOf(r+dir[0], c+dir[1], day+1))
                lastDay = max(lastDay, day+1)
            }
        }
    }

    // 익지 않은 토마토가 있는지 확인
    for (rowTomato in box){
        for (tomato in rowTomato){
            if (tomato == 0){
                println(-1)
                return
            }
        }
    }
    println(lastDay)
}