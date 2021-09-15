// 문제 링크 : https://www.acmicpc.net/problem/2014
// 제출 공유 링크 : http://boj.kr/130e3509865040dcb788ecf9d8c21886
// 참고 : https://comyoung.tistory.com/236

// n의 범위가 너무 커서 특정 기법이나 방법을 모르면 못풀겠다는 생각에 바로 문제풀이 검색을 해보았다.
// 피보나치 수를 K라는 수로 나눌 때, 나머지는 항상 주기를 가지게 되는 피사노 주기라는 개념을 모르면 풀 수 없다는 것을 알았다.
// 위의 블로그를 참고하여 작성하였으며 피사노 주기만 알면 어렵지 않은 내용이었다.

// fib : 피보나치 수 저장을 위한 배열

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = (readLine().toLong() % 1500000).toInt()
    val fib = Array(n+1){0}
    fib[1] = 1

    for (i in 2..n) fib[i] = (fib[i-1] + fib[i-2]) % 1000000
    println(fib[n])
}