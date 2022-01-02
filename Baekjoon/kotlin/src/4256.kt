// 문제 링크 : https://www.acmicpc.net/problem/4256
// 제출 공유 링크 1 : http://boj.kr/0453aece1c1f4bfdac74c556746ca8d5
// 제출 공유 링크 2 (블로그 참고) : http://boj.kr/71af77b8d2c94f4fbccc52d222b536e0
// 참고 블로그 : https://seokjin2.tistory.com/56

// 전위와 중위 순회로 후위 순회를 유추하는 문제로, 각 순회의 특징을 잘 이해하게 되는 문제이다.
// 언제나 부모부터 탐색하는 전위 순회를 활용하여 중위 순회를
// 왼쪽 서브트리와 오른쪽 서브트리로 나눌 수 있다는 점을 활용하면 쉽게 풀 수 있다.
// 위의 특징으로 분할정복 알고리즘으로 분류되는 문제이기도 하다.

// 왜 인지는 모르겠으나 본인은 입력값을 받을 때 trim() 함수를 사용해야만 런타임 에러 (NumberFormat)가 발생하지 않았다.
// 이런 경우가 없어서 시간을 많이 빼앗겼다..

// 처음으로는 생각나는대로 코딩을 하였는데 메모리와 실행시간이 많이 쓰일 것을 알았으나 일단 진행하고
// 블로그로 다른 사람의 코드를 참고하여서 한 번 더 풀었다.
// 풀이 방식은 비슷하였고 메모리는 블로그를 참고해서 한 것이 스스로 한것의 1/3 정도였지만, 의외로 시간차이는 생각보다 크게 나지 않았다.

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var cnt = 0 // preOrder의 숫자를 순서대로 가져오기 위해 쓰는 변수
    var preOrder = arrayOf(1)
    var inOrder = arrayOf(1)

    // 스스로 간단하게 만든 코드, 메모리가 많이 들어간다는 것은 알고 있었는데 귀찮아서 그대로 진행하였다.
    fun printPostOrderWithLargeMemory(subInOrder: Array<Int>){
        // 서브 트리에 아무것도 없으면 되돌아간다.
        if (subInOrder.isEmpty()) return

        // preOrder 다음 숫자를 가져오고 inOrder에서 해당 숫자를 탐색
        cnt += 1
        val saveCnt = cnt
        val numIndex = subInOrder.indexOf(preOrder[cnt])
        if (numIndex == -1) return // 예외처리, 없어도 되는 코드

        // 왼쪽 서브 트리 탐색
        printPostOrderWithLargeMemory(subInOrder.sliceArray(0 until numIndex))
        // 오른쪽 서브 트리 탐색
        printPostOrderWithLargeMemory(subInOrder.sliceArray(numIndex+1 until subInOrder.size))
        print("${preOrder[saveCnt]} ")
    }

    // 다른 블로그를 참고해서 만든 코드
    fun printPostOrder(parentIndex: Int, from: Int, to: Int){
        // preOrder 특정 인덱스에 있는 숫자를 가져오고 inOrder에서 해당 숫자를 탐색
        for (i in from..to){
            if (inOrder[i] == preOrder[parentIndex]){
                // 왼쪽 서브 트리 탐색
                printPostOrder(parentIndex+1, from, i-1)
                // 오른쪽 서브 트리 탐색
                printPostOrder(parentIndex+(i-from)+1, i+1, to)
                print("${preOrder[parentIndex]} ")
                break
            }
        }
    }

    // 테스트 캐이스만큼 반복
    for (t in 0 until readLine().toInt()) {
        val n = readLine().toInt()
        preOrder = readLine().trim().split(" ").map { it.toInt() }.toTypedArray()
        inOrder = readLine().trim().split(" ").map { it.toInt() }.toTypedArray()

//        cnt = -1
//        printPostOrderWithLargeMemory(preOrder, inOrder)

        printPostOrder(0,0, inOrder.size-1)
        println()
    }
}
