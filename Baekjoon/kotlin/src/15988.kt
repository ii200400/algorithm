// 문제 링크 : https://www.acmicpc.net/problem/15988
// 제출 공유 링크 : http://boj.kr/d7db613aee174b6eb8b35e53a989e97b

import java.util.*

fun main15988(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val list = MutableList<Long>(1000001) { 0 }
    list[1] = 1
    list[2] = 2
    list[3] = 4
    for (idx in 4..1000000){
        list[idx] = (list[idx-3] + list[idx-2] + list[idx-1]) % 1000000009
    }

    for (i in 0 until sc.nextInt()){
        println(list[sc.nextInt()])
    }
}