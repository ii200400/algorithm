// 문제 링크 : https://www.acmicpc.net/problem/13460
// 제출 공유 링크 : http://boj.kr/b656b47f4d4549ee868ea576785bdcbd

// 가장 적은 행동을 취해서 구슬 탈출이 성공하는 회수를 구하는 것이여서 dfs보다는 bfs가 더 적절한 문제라고 생각한다.
// 그런데 bfs로 풀 생각하면서 습관적으로 dfs로 풀었다.
// 조건도 제한이 크고 (깊이 10 이하) 맵도 작아 (가로/세로 3~10) 큰 문제가 되지는 않았다.

// 해결 방법을 글로 풀면 다음과 같다.
// 동(3),서(1),남(2),북(0)을 숫자와 매핑하여 해당 방향으로 기울인다.
// 기울이는 것은 이전 방향과 내각이 90도가 차이나는 방향만을 선택한다.
// (이전에 동쪽으로 기울였으면 다음 탐색은 북쪽과 남쪽으로 기울이라는 의미)
// 먼저 빨간 구슬이 굴러가서 멈추는 위치를 계산하고 구멍에 빠졌는지 확인한다.
// 다음으로 파란구슬이 굴러가서 멈추는 위치를 계산하고 구멍에 빠졌는지 확인한다.
// 빨간구슬이 파란구슬에 막혀 굴러가지 못했을 경우를 생각하여 빨간구슬이 구멍에 빠지지 않은 경우에만 빨간구슬을 한번 더 굴린다.
// 기울이기 전과 후의 구슬 위치가 같다면, 두 구슬 중 하나라도 구멍에 빠졌다면(행동 횟수를 저장한 뒤) 행동을 무른다(return).
// 위의 과정이 10번 이하가 되도록 반복하고 구슬이 탈출하지 못하는 경우라면 -1을 출력하도록 한다.

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main13460() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 기울일 때 가로/세로로 구슬이 움직이는 칸
    val dirCol = arrayOf(0, -1, 0, 1)
    val dirRow = arrayOf(-1, 0, 1, 0)

    // 입력값들
    val (r, c) = readLine().split(" ").map { it.toInt() }
    var redBall = listOf(0,0)
    var blueBall = listOf(0,0)
    val map = List(r) { row ->
        val line = readLine().toMutableList()
        for (idx in line.indices) {
            when (line[idx]) {
                'R' -> redBall = listOf(row, idx)
                'B' -> blueBall = listOf(row, idx)
            }
        }
        line
    }
    var answer = 11

//    println(map.contentDeepToString())
//    println("$redBall $blueBall")

    // 구슬이 어디로 움직일지 계산한다.
    fun move(dir: Int, map: List<List<Char>>, ball: List<Int>): List<Int>{
        val rolledBall = mutableListOf(0,0)
        var cnt = 1
        while (true) { // 특정 조건까지 구슬을 굴린다.
            when (map[ball[0] + dirRow[dir]*cnt][ball[1] + dirCol[dir]*cnt]) {
                '#', 'R', 'B' -> { // 탐색 위치에 이런 물체가 감지되면 구슬이 멈추는 위치를 저장하고 break
                    rolledBall[0] = ball[0] + dirRow[dir]*(cnt-1)
                    rolledBall[1] = ball[1] + dirCol[dir]*(cnt-1)
                    break
                }
                'O' -> { // 구멍에 떨어지면 위치를 (-1, -1)로 바꿔버리고 break
                    rolledBall[0] = -1
                    rolledBall[1] = -1
                    break
                }
            }
            cnt += 1
        }

        return rolledBall
    }

    // 구멍에 떨어졌는지(위치가 (-1, -1)인지) 확인한다.
    fun checkBallInHole(ball: List<Int>): Boolean{
        return (ball[0] == -1 && ball[1] == -1)
    }
    
    // 0 북 1 서 2 남 3 동
    val rollTo = arrayOf(1,3)
    fun rollBalls(dir: Int, copyMap: List<MutableList<Char>>, redBall: List<Int>, blueBall: List<Int>, cnt: Int){
        // 행동이 탐색했던 구슬 탈출보다 더 오래걸린다면(answer는 최대 11) return
        if (answer <= cnt) return

        // 구슬이 구멍에 빠졌는지 아닌지 확인
        var isRedInHole = false
        var isBlueInHole = false

        // 빨간구슬이 굴러가는 위치 계산 및 지도에 기록
        var rolledRedBall = move(dir, copyMap, redBall.toList())
        isRedInHole = checkBallInHole(rolledRedBall)
        copyMap[redBall[0]][redBall[1]] = '.'
        if (!isRedInHole) copyMap[rolledRedBall[0]][rolledRedBall[1]] = 'R'

        // 파란구슬이 굴러가는 위치 계산 및 지도에 기록
        val rolledBlueBall = move(dir, copyMap, blueBall.toList())
        isBlueInHole = checkBallInHole(rolledBlueBall)
        copyMap[blueBall[0]][blueBall[1]] = '.'
        if (!isBlueInHole) copyMap[rolledBlueBall[0]][rolledBlueBall[1]] = 'B'

        // 빨간 구슬이 구멍에 빠지지 않았다면, 다시 빨간구슬이 굴러가는 위치 계산 및 지도에 기록
        if (!isRedInHole) {
            val temp = rolledRedBall.toList()
            rolledRedBall = move(dir, copyMap, rolledRedBall.toList())
            isRedInHole = checkBallInHole(rolledRedBall)
            copyMap[temp[0]][temp[1]] = '.'
            if (!isRedInHole) copyMap[rolledRedBall[0]][rolledRedBall[1]] = 'R'
        }

        // 구슬 위치가 달라진 것이 없으면 return
        if (rolledRedBall == redBall && rolledBlueBall == blueBall)
            return

        // 구슬 중 하나라도 구멍에 빠졌으면 return
        if (isRedInHole){
            // 구슬 탈출에 성공했다면 행동 횟수 기록
            if (!isBlueInHole) answer = min(answer, cnt)
            return
        }else if (isBlueInHole) return

        // 다음으로 기울일 방향 선택 및 실행
        for (p in rollTo) {
            rollBalls((dir + p) % 4, copyMap.map { it.toMutableList() }, rolledRedBall.toList(), rolledBlueBall.toList(), cnt + 1)
        }
    }

    // 북,서,남,동 순서로 기울이기 시작
    for (i in 0..3) {
        rollBalls(i, map.map { it.toMutableList() }, redBall.toList(), blueBall.toList(), 1)
    }

    // 가장 적게 걸린 행동 회수 출력, 없다면 -1
    println(if (answer == 11) -1 else answer)
}
