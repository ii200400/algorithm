// 문제 링크 : https://www.acmicpc.net/problem/1182
// 제출 공유 링크 : // 문제 링크 : https://www.acmicpc.net/problem/13244
//// 제출 공유 링크 : http://boj.kr/9d290605611f4b0ea933b35ab7d8d38c

// 이전에 부르트포스로 풀었다가 시간제한으로 틀렸던 문제이다. (다시보니 자료구조를 잘 못 쓴것이었다.)
// 재귀함수를 사용해서 부르트포스를 구현하였다.

// n : 수열 정수 개수
// sum : 부분수열의 합
// numbers : 수열

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 변수 초기화
    val (n, sum) = readLine().split(" ").map { it.toInt() }
    val numbers = readLine().split(" ").map { it.toInt() }

    var answer = 0
    // 부분수열의 합만 구하여 조건이 충족되면 answer+1 을 진행하는 함수
    fun search(subSum: Int, idx: Int){
        if (idx == n-1) {
            if (subSum + numbers[idx] == sum) answer += 1
            if (subSum == sum) answer += 1
            return
        }
        search(subSum + numbers[idx], idx+1)
        search(subSum, idx+1)
    }
    search(0, 0)

    // 부분수열의 크기는 양수라는 조건이 있는데 search함수는 공집합까지 만드므로
    // 예외처리한 것
    if (sum == 0) println(answer - 1)
    else println(answer)
}