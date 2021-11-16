// 문제 링크 : https://www.acmicpc.net/problem/2014
// 제출 공유 링크 : http://boj.kr/d1ce5692cb0745199e28e4d7287e2f3a
// 참고 : https://mygumi.tistory.com/183

// 재귀함수를 통해 완전탐색을 사용할 것이다.
// 우선 입력받은 숫자로 만들수 있는 모든 수를 구하고
// set으로 중복검사, 최소힙으로 최소값을 구하여 n번째 숫자를 구할 예정이다.

// 메모리 초과가 계속 생겨 결국에는 검색으로 풀이 방법을 찾았는데
// 수를 중복하지 않고 구하는 방법이 있었다;;
// '정수론'이라고 쓰여있던데 잘 모르는 방법이라서 생각도 못했다.

// primes : 입력받는 소수들
// heap : 최소힙, 소수의 곱들 중 최소 값을 가져오기 위함
// limit : 코틀린에서는 Int값을 넘으면 에러가 생기므로 만들어준 변수
// number, count : 힙(heap)에서 나온 소수의 곱 중, count 번째 최소 값

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main2014() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (_, n) = readLine().split(" ").map { it.toInt() }
    val primes = readLine().split(" ").map { it.toInt() }
    val heap = PriorityQueue(primes)
    val limit = Int.MAX_VALUE

    var count = 0
    while (count < n-1){
        val number = heap.poll()
        count += 1

        for (prime in primes) {
            val newNumber = number * prime.toLong()
            if (newNumber > limit) continue
            heap.add(newNumber.toInt())

            if (number % prime == 0) break
        }
    }

    println(heap.poll())
}

//fun main2014-2() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val (_, n) = readLine().split(" ").map { it.toInt() }
//    val decimals = readLine().split(" ").map { it.toInt() }
//    val heap = PriorityQueue(decimals)
//    val numberSet = mutableSetOf<Int>()
//    val limit = Int.MAX_VALUE
//
//    var count = 0
//    while (count < n-1){
//        val number = heap.poll()
//
//        numberSet.remove(number)
//        count += 1
//
//        for (decimal in decimals) {
//            val newNumber = number * decimal.toLong()
//            if (newNumber > limit) continue
//
//            val numberToInt = newNumber.toInt()
//            if (numberToInt in numberSet) continue
//            heap.add(numberToInt)
//            numberSet.add(numberToInt)
//        }
//    }
//
//    println(heap.poll())
//}