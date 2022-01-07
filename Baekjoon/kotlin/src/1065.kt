// 문제 링크 : https://www.acmicpc.net/problem/1065
// 제출 공유 링크 : http://boj.kr/9bf15ba49d754c5f9b6c73755e861e8b

// 백준의 '단계별로 풀어보기' 카테고리의 6단계 '함수'의 3번 문제
// 이전에 풀어본 적이 있는 것 같지만 다시 풀어보기로 하였다.

// cnt : 한수인 수의 개수를 셀때 사용하는 변수
// diff : 한수에서 등차수열의 차이를 저장하는 변수
// tempNum : 한수인지 판단할 때 수를 잠시 저장하는 임의의 변수

import java.io.BufferedReader
import java.io.InputStreamReader

fun main1065() = with(BufferedReader(InputStreamReader(System.`in`))) {

    // 한수인지 확인하는 함수
    fun isHanSu(num: Int): Boolean{
        // 2자리 이하는 무조건 등차수열이다.
        if (num < 100) return true

        // 첫째 자리와 둘째 자리의 수를 이용하여 등차수열인지 확인할 두 수의 차이를 구한다.
        val diff = (num % 10) - (num % 100 / 10)
        // 위에서 첫째 자리와 둘째자리는 이미 계산했으니 둘째자리와 셋째자리가 비교되도록 수를 조정한다.
        var tempNum = num / 10
        while (tempNum > 9){ // 2자리 이상이라면 첫째 자리와 둘째 자리를 살펴본다.
            // 각 자리수가 등차수열인지 확인
            if ((tempNum % 10) - (tempNum % 100 / 10) != diff)
                return false
            tempNum /= 10
        }
        return true
    }

    // 1부터 입력받은 수까지 한수인 수를 센다.
    var cnt = 0
    for (num in 1..readLine().toInt())
        if (isHanSu(num)) cnt += 1

    println(cnt)
}