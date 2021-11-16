// 문제 링크 : https://www.acmicpc.net/problem/17298
// 제출 공유 링크 : http://boj.kr/aeaf2462588d41d5bb099de2b3a765d6 (두번째 풀이)

// O(n^2) 시간복잡도를 가지는 코드, 물론 시간초과
// 더 효과적인 풀이는 아래를 보자

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun nonPass() = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    val numbers = readLine().split(" ").map { it.toInt() }.toIntArray()
    val answer = mutableListOf<Int>()

    // 오큰수를 찾으면 해당 오큰수를 저장하고 true를, 찾지 못하면 -1을 저장하고 false를 반환한다.
    fun searchNGE(idx: Int){
        for (search in idx+1 until numbers.size) {
            if (numbers[idx] < numbers[search]) {
                answer.add(numbers[search])
                return
            }
        }
        answer.add(-1)
    }

    for (idx in numbers.indices){
        searchNGE(idx)
    }
    println(answer.joinToString(separator = " "))
}

// 참고 : https://www.youtube.com/watch?v=XwG-QcBQ9-I&ab_channel=%EC%BD%94%EB%8D%B0%ED%92%80

// 오른쪽부터 답을 구하면 빠르게 해결할 수 있다는 글을 보고 풀이 방법을 검색하였다.
// 설명을 읽어보면 왼쪽부터 탐색하면서
// 해당 수의 바로 오른쪽 숫자가 오큰수가 아니라면 스택에 저장하고
// 오큰수가 맞다면 수를 저장하고 스택의 숫자들도 해당 수가 오큰수가 될 수 있는지 확인한다.
//
// 이해가 안된다면 위의 참고 링크를 보자, 그림을 그리면서 설명하여서 이해가 쉽다.

fun main17298(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    val numbers = readLine().split(" ").map { it.toInt() }
    val stack = Stack<Pair<Int, Int>>()
    // 오큰수를 구하지 못하면 -1이므로 초기값을 -1로 지정
    val answer = Array(numbers.size){ -1 }

    // 왼쪽부터 탐색을 한다.
    for (idx in 0 until numbers.size-1){
        // 탐색 중인 숫자의 바로 오른쪽쪽
       if (numbers[idx] < numbers[idx+1]) {
            answer[idx] = numbers[idx+1]

            while (stack.isNotEmpty()) {
                val (savedIdx, savedNumber) = stack.peek()
                if (savedNumber < numbers[idx+1]) {
                    answer[savedIdx] = numbers[idx+1]
                    stack.pop()
                }
                else break
            }
        }
        else stack.add(Pair(idx, numbers[idx]))
    }

    println(answer.joinToString(separator = " "))
}