// 문제 링크 : https://www.acmicpc.net/problem/15829
// 제출 공유 링크 : http://boj.kr/89e681190d9641bb9f6f8eb33fbfa76a

// 해시 함수를 직접 구현해보는 문제..
// 이지만 개인적으로는 간단한 나머지에 관한 특징도 어느정도 알고 있어야 풀 수 있다고 생각한다.

// 사칙연산이 다음과 같은 수식이 성립되는 것 처럼
// (1+2)*3 = 1*3 + 2*3
// 나머지 또한 다음과 같은 수식이 성립한다. %로 하면 나눗셈과 햇갈리니 나머지 연산을 mod라고 작성하였다.
// (a+b) mod c = (a mod c) + (b mod c)
// (a*b) mod c = (a mod c) * (b mod c)
// 단, 우항이 c를 넘긴다면 다시 c로 나머지 연산을 해야한다.
//
// 이것도 사칙연산에 포함되는지 몰라서 찾아보았지만 나머지에 관한 공식은 크게 찾아보기 힘들어서 직접 실험하였다.
// 증명까지 하기는 어렵지만 수식이 성립한다고 판단하여 위의 특징을 활용하여 Int나 Long을 넘기지 않도록 해시함수를 구현하였다.

// sum : 해시값을 구하는 과정의 중간 값을 저장하는 변수
// remainOf31 : 31의 N제곱의 나머지를 저장하는 변수

import java.io.BufferedReader
import java.io.InputStreamReader

fun main15829() = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    val str = readLine()

    var sum = 0L
    var remainOf31 = 1L
    for (char in str) {
        sum = (remainOf31 * (char.toInt()-96) + sum) % 1234567891
        remainOf31 = (remainOf31 * 31) % 1234567891
    }
    println(sum)
}