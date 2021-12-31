// 문제 링크 : https://www.acmicpc.net/problem/1991
// 제출 공유 링크 : http://boj.kr/e29052fb5ff44b208b7d5d818d246449

// 주어지는 트리는 무조건 2진 트리이므로 간단한 배열을 활용하여 문제를 해결하였다.
// tree 라는 배열에 [[A의 왼쪽 자식, A의 오른쪽 자식], [B의..]..] 방식으로 연결된 노드에 대한 정보를 저장하고
// 각 순회를 진행하여 문제를 해결하였다.

// 문제를 해결하고나서 다른 사람의 풀이를 보았는데 구조체로 한 것을 빼고 본인과 비슷하게 푼 사람이 많아서
// 다 비슷하게 푸는구나 싶었다.

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val tree = Array(N){ arrayOf('.','.') }
    for (i in 0 until N) {
        val nodes = readLine().split(" ").map { it[0] }.toTypedArray()
        tree[nodes[0].toInt()-65] = arrayOf(nodes[1], nodes[2])
    }

    fun preOrder(node: Char){ // 전위 순회
        print(node)
        if (tree[node.toInt()-65][0] != '.') preOrder(tree[node.toInt()-65][0])
        if (tree[node.toInt()-65][1] != '.') preOrder(tree[node.toInt()-65][1])
    }

    fun inOrder(node: Char){ // 중위 순회
        if (tree[node.toInt()-65][0] != '.') inOrder(tree[node.toInt()-65][0])
        print(node)
        if (tree[node.toInt()-65][1] != '.') inOrder(tree[node.toInt()-65][1])
    }

    fun postOrder(node: Char){ // 후위 순회
        if (tree[node.toInt()-65][0] != '.') postOrder(tree[node.toInt()-65][0])
        if (tree[node.toInt()-65][1] != '.') postOrder(tree[node.toInt()-65][1])
        print(node)
    }

    preOrder('A')
    println()
    inOrder('A')
    println()
    postOrder('A')
}