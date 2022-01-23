// 문제 링크 : https://www.acmicpc.net/problem/1406
// 제출 공유 링크 : http://boj.kr/b806e0de7dc346978494e96857f3fb4d

// 두 개의 스택 혹은 링크드리스트로 해결하는 문제였다.
// 처음에는 링크드리스트 하나만 사용해 시간초과가 생겼다.
// 질문검색에서 왜 pop을 안쓰냐는 글에
// 갑자기 스택 2개로 큐를 만드는 방법이 생각나면서
// 스택을 2개 사용하면 된다는 생각에 아래의 코드를 만들게 되었다. (파칭-)

// 참고로 코틀린에서는 스택, 큐, 링크드리스트 자료구조 모두 LinkedList로 구현하므로
// Stack 대신 LinkedList를 사용하였다.

// string : 입력값을 수신
// leftEditor : 커서의 왼쪽 문자들 (링크드리스트)
// rightEditor : 커서의 오른쪽 문자들 (링크드리스트)

package com.baekjoon.problem

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 변수 초기화
    val string = readLine()
    val leftEditor = LinkedList<Char>()
    val rightEditor = LinkedList<Char>()
    for (char in string)
        leftEditor.add(char)

    // 편집기 명령어 수행
    for (i in 0 until readLine().toInt()) {
        val command = readLine()
        when (command[0]) {
            'L' -> {
                if (leftEditor.isEmpty()) continue
                val char = leftEditor.removeLast()
                rightEditor.addFirst(char)
            }
            'D' -> {
                if (rightEditor.isEmpty()) continue
                val char = rightEditor.removeFirst()
                leftEditor.add(char)
            }
            'B' -> {
                if (leftEditor.isEmpty()) continue
                leftEditor.removeLast()
            }
            'P' -> {
                leftEditor.addLast(command[2])
            }
        }
    }
    println(leftEditor.joinToString("") + rightEditor.joinToString(""))
}
// 시간초과로 통과가 되지 못한 코드
// 링크드리스트와 커서의 위치를 저장하는 변수만으로 풀었다.
// 삽입, 삭제의 시간이 생각보다 오래 걸린다는 것을 알았다.

//fun main1406-2() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val string = readLine()
//    val editor = LinkedList<Char>()
//    for (char in string)
//        editor.add(char)
//    var cursor = editor.size
//
//    for (i in 0 until readLine().toInt()){
//        val command = readLine()
//        when(command[0]){
//            'L' -> {
//                if (cursor == 0) continue
//                else cursor -= 1
//            }
//            'D' -> {
//                if (cursor == editor.size) continue
//                else cursor += 1
//            }
//            'B' -> {
//                if (cursor == 0) continue
//                editor.removeAt(cursor-1)
//                cursor -= 1
//            }
//            'P' -> {
//                editor.add(cursor, command[2])
//                cursor += 1
//            }
//        }
//    }
//    println(editor.joinToString(""))
//}

