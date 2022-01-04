// 문제 링크 : https://www.acmicpc.net/problem/2220
// 제출 공유 링크 : http://boj.kr/de1d077d0ba8473c9a118579410136f4

// 문제에서 설명해준 heapify 과정과
// 코틀린에서 제공하는 우선순위 큐 자료형에서 제공하는 add() 함수가 같은 과정을 가지고 있어 쉽게 해결하였다.

// swap하는 횟수가 가장 많도록 하기 위해서는 가장 작은 숫자가 항상 가장 높은 레벨을 가지고 있어야 한다.
// 이를 해결하기 위해서는 heapify를 잘 이해하기만하면 된다.
// 힙의 데이터 삽입 과정은 항상 새로운 데이터를 가장 마지막 자리에 넣고 수를 비교하여 적절한 위치를 찾아가는 것이고
// 힙의 데이터 삭제 과정은 마지막 위치의 데이터를 루트 노드에 올리고 적절한 위치를 찾아가는 것이다.

// 힙에 저장된 데이터들 보다 큰 수를 계속해서 삽입하고 난 후
// 힙에 저장된 데이터들 보다 작은 숫자를 넣어 힙을 완성시키고 다시 삭제를 진행하면
// 삭제된 숫자가 삽입 시 올라간 경로 그대로 가장 작은 숫자가 내려가 마지막 자리로 찾아가게 된다.
// 이를 활용하여 문제를 풀면 아래와 같이 간단한 풀이가 완성된다.

// 코틀린에서 제공하는 우선순위 큐 자료형을 활용하여 2~n을 순서대로 삽입하고 가장 마지막에 1을 넣어준다.
// 본인의 경우 1을 넣어주는 것을 대신해 가장 마지막에 " 1" 문자열을 출력하는 것으로 대체하였다.

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main2220() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val maxHeap = PriorityQueue<Int>(n, reverseOrder())
    for (i in 2..n) maxHeap.add(i)
    println(maxHeap.joinToString(" ",""," 1"))
}