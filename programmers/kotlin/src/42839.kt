// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42839?language=kotlin
// 참고 : https://hanyeop.tistory.com/117 (에라토스테네스의 체)

// 에라토스테네스의 체 사용

import java.util.*
import kotlin.math.pow

class Solution42839 {
    fun solution(numbers: String): Int {
        // 에라
        val primeSize = 10.toDouble().pow((numbers.length+1).toDouble()).toInt()
        val prime : Array<Boolean> = Array(primeSize) {true}
        // true = 소수, false = 소수가 아님
        prime[0] = false
        prime[1] = false // 0과 1은 소수가 아님

        for (i in 2 until primeSize)
            if (prime[i])
                for (j in 2 * i..primeSize step i) prime[j] = false

        var answer = 0
        return answer
    }
}

fun main(args: Array<String>) = with(Scanner(System.`in`)) {

    // 소수의 배수들을 싹다 false 처리

    repeat(nextInt()){
        if (prime[nextInt()]) count++
    } // N의 개수만큼 반복하여 입력받고 그 수가 소수인지 판별

    println(count)
}