// 진법변환으로 대충 가장 큰 소수(0이 포함되지 않은)처럼보이는 녀석이
// 1212211111111 정도로 이다. 이것의 제곱근은 1101004.59...
// http://www.iwiz.pe.kr/bbs/view/webdev/article_51.html 참고!

import java.util.*
import kotlin.math.sqrt

class Solution2 {
    // copyN : 진법변환을 위해 만든 n의 분신
    // conversion : k진법으로 변환한 수 (링크드리스트)
    // numberList : conversion을 정규표현식을 활용하여 나눈 것

    fun solution(n: Int, k: Int): Int {
        // 변수 초기화
        var copyN = n
        val conversion = LinkedList<Int>()
        // k 진법으로 전환
        while (copyN >= k){
            conversion.addFirst(copyN % k)
            copyN /= k
        }
        conversion.addFirst(copyN)

        // 정규표현식을 이용하여 split
        val kNumber = conversion.joinToString("")
        val numberList = kNumber.split("0+".toRegex())
        // val cache = mutableSetOf<Int>()

        var answer = 0
        // 소수인지 확인하는 함수
        // 소수이면 true 아니면 false 를 반환한다.
        fun isDecimal(number: Long): Boolean{
            for (i in 3..sqrt(number.toFloat()).toInt()) {
                if (number % i == 0L) return false
            }
            return true
        }
        for (number in numberList) {
            if (number == "" || number.toLong() == 1L) continue
            if (isDecimal(number.toLong())) answer += 1
        }

        return answer
    }
}

//fun main() {
//    println(Solution2().solution(437674, 3))
//    println(Solution2().solution(110011, 10))
//    println(Solution2().solution(1, 3))
//    println(Solution2().solution(2, 3))
//    println(Solution2().solution(3, 3))
//    println(Solution2().solution(3, 4))
//    println(Solution2().solution(4, 5))
//    println(Solution2().solution(6, 7))
//}