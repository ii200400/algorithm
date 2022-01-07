// 문제 링크 : https://www.acmicpc.net/problem/1011
// 제출 공유 링크 : http://boj.kr/569894a661a547a18c7d3e0f59ed8c75
// 참고한 질문 : https://www.acmicpc.net/board/view/13747

// 백준의 '단계별로 풀어보기' 카테고리의 8단계 '기본 수학 1' 9번 문제
// 의외로 어려웠다. 코딩테스트에는 나오지 않을 문제이지만,
// 처음에는 에라테토.. 어쩌구 체를 푸는 것과 같이 풀었다. 생각해보니 기본수학 문제라서 뒤늦게 해결 방법을 바꾸었다.

// 질문검색에서 제곱근을 사용하는 방법도 있다는 글을 보고 코드는 보지 않고 풀이를 구현해보았다.
// 해당 풀이는 참고 질문 링크를 참고하자.

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    for (t in 0 until readLine().toInt()){
        val (x, y) = readLine().split(" ").map { it.toInt() }
        val dis = y-x
        val closestNum = sqrt(dis.toDouble()).toInt()
        println(
            when {
                dis == closestNum*closestNum -> closestNum*2 - 1
                dis - closestNum*closestNum <= closestNum -> closestNum*2
                else -> closestNum*2+1
            }
        )
    }
}