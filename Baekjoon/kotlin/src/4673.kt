// 문제 링크 : https://www.acmicpc.net/problem/4673
// 제출 공유 링크 : http://boj.kr/778f1552aa2d4f61898317db3ad640e5

// 백준의 '단계별로 풀어보기' 카테고리의 6단계 '함수'의 2번 문제
// 에라토스테네스의 체와 비슷한 문제같아 구현도 비슷하게 하여 풀었다.

// selfNumbers : 셀프 넘버를 저장하는 변수, 연산 후 i번째 인덱스의 값이 true라면 셀프 넘버가 맞다.

import java.io.BufferedReader
import java.io.InputStreamReader

fun main4673() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val selfNumbers = Array(10001){ true }

    // 다음 수열을 구하는 함수
    fun nextSeq(num: Int): Int{
        var sum = num
        var dividedNum = num
        while (dividedNum > 0) { // 각 자리수를 더해준다.
            sum += dividedNum % 10
            dividedNum /= 10
        }

        return sum
    }

    // 셀프 숫자를 한 숫자씩 찾는다.
    for (num in 1 until selfNumbers.size){
        // selfNumbers에 저장된 값이 false라면 바로 continue하여 아래 연산을 진행하지 않는다.
        if (!selfNumbers[num]) continue
        println(num) // 셀프 숫자이므로 출력

        // 위의 셀프 숫자를 통해 만들 수 있는 숫자들은 모두 false 값을 가지도록 한다.
        var seq = nextSeq(num)
        while (seq < selfNumbers.size) {
            selfNumbers[seq] = false
            seq = nextSeq(seq)
        }
    }
}