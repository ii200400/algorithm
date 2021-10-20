// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42839?language=kotlin
// 참고 : https://hanyeop.tistory.com/117 (에라토스테네스의 체)

// 에라토스테네스의 체 사용

import kotlin.math.pow

class Solution42839 {
    fun solution(numbers: String): Int {
        // 에라토스테네스의 체
        val primeSize = 10.toDouble().pow((numbers.length).toDouble()).toInt()
        val prime : Array<Boolean> = Array(primeSize) {true}
        // true = 소수, false = 소수가 아님 혹은 이미 만든적 있는 소수
        prime[0] = false
        prime[1] = false // 0과 1은 소수가 아님

        for (i in 2 until primeSize)
            if (prime[i])
                for (j in 2 * i until primeSize step i) prime[j] = false

        var answer = 0
        // 종이 조각으로 만들 수 있는 모든 숫자 조합 확인
        fun checkNumbers(numbers: String, primeString: String) {
            for (idx in numbers.indices) {
                val primeNumber = (primeString + numbers[idx]).toInt()
                if (prime[primeNumber]) { // 소수이면서 이전에 나온 숫자가 아니라면
                    answer += 1
                    prime[primeNumber] = false
                    println(primeNumber)
                }
                checkNumbers(numbers.removeRange(idx, idx + 1), primeString + numbers[idx])
            }
        }
        checkNumbers(numbers, "")

        return answer
    }
}

//정확성  테스트
//테스트 1 〉	통과 (12.23ms, 57.5MB)
//테스트 2 〉	통과 (66.24ms, 67.5MB)
//테스트 3 〉	통과 (12.37ms, 58MB)
//테스트 4 〉	통과 (63.75ms, 67.1MB)
//테스트 5 〉	통과 (2278.41ms, 128MB)
//테스트 6 〉	통과 (11.59ms, 58.7MB)
//테스트 7 〉	통과 (16.91ms, 58.4MB)
//테스트 8 〉	통과 (2227.24ms, 125MB)
//테스트 9 〉	통과 (11.64ms, 57.9MB)
//테스트 10 〉	통과 (81.55ms, 67.4MB)
//테스트 11 〉	통과 (24.65ms, 59.1MB)
//테스트 12 〉	통과 (23.03ms, 59.6MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0

fun main() {
    Solution42839().solution("7777777")
    Solution42839().solution("011")
}
