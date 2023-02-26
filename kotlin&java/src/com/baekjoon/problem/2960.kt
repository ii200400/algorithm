// 문제 링크 : https://www.acmicpc.net/problem/2960
// 제출 공유 링크 : http://boj.kr/a8c2b2b4253342f5a3babd997c70ccaf

// 에라토스테네스의 체 구현 문제
// 4373번 문제를 풀기 전에 에라토스테네스의 체와 같이 구현하면 되겠다는 생각이 들긴 했는데
// 코드를 어떻게 구현했는지 가물가물하여 직접 해당 문제를 찾아서 풀어보았다.

// array : 에라토스테네스의 체를 저장한 배열, true이면 해당 인덱스의 숫자는 소수이다.
// cnt : 찾은 소수의 개수

import java.io.BufferedReader
import java.io.InputStreamReader

fun main2960() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, goal) = readLine().split(" ").map { it.toInt() }
    val array = Array(n+1){ true }
    var cnt = 0

    // 소수 찾기
    for(num in 2..n){
        if (array[num]) {
            var multiple = num

            while (multiple <= n) {
                // 소수를 찾았다면 cnt+1
                if (array[multiple]) {
                    array[multiple] = false
                    cnt += 1

                    // 원하는 goal번째 소수를 찾았다면 끝
                    if (cnt == goal) {
                        println(multiple)
                        return
                    }

                }
                multiple += num
            }
        }
    }
}