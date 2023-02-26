// 문제 링크 : https://www.acmicpc.net/problem/5430
// 제출 공유 링크 : http://boj.kr/f998707c64394b509c74c7bc48198342

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    for (i in 0 until readLine().toInt()){
        val ops = readLine()
        readLine()
        val nums = Regex("""\d+""").findAll(readLine()).map { it.value }.toList()
        //println("=== $nums")

        // 숫자의 시작점과 끝점 저장
        var isReverse = false
        var start = 0
        var end = nums.size - 1

        // 시작점과 끝점을 들어오는 함수에 따라 계산
        for (op in ops){
            if (op == 'D'){
                if (!isReverse) start += 1
                else end -= 1

            }else{ // op == 'R'
                isReverse = !isReverse
            }
        }

        // 시작점과 끝점에 따라서 출력
        if (start > end + 1) println("error")
        else{
            val subList = if (!isReverse) nums.subList(start, end+1) else nums.subList(start, end+1).reversed()
            println(subList.joinToString(prefix="[", postfix = "]", separator = ","))
        }
    }

    close()
}