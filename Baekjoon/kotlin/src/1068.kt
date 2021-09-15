// 문제 링크 : https://www.acmicpc.net/problem/1068
// 제출 공유 링크 : http://boj.kr/365b2835f3ac40249d01f3f1a31181cb

// 예전에 틀렸던 문제들 푸는 중이다.
// 이해가 좀 많이 어려웠는데 어려웠던 점은 다음과 같다.

// 1. 루트노드가 하나 이상일 수 있다. (트리가 하나 이상일 수 있다.)
// 2. 지워진 노드의 하위노드는 모두 같이 사라진다.

// 1번은 문제에서 언급할만하다고 생각하는데 유추를 해야한다.
// 이 문제가 트리 기초문제도 아닌 연습문제로 들어가 있어서 쉽다고 생각했던 것도 한 몫하는 것 같다.

// Node : 노드 데이터 클래스
// parentIndexes : 입력값을 받아 저장하는 변수
// deletedNode : 삭제된 노드
// nodes : 0~(n-1) 노드들
// rootList : nodes 중에서 루트노드들의 인덱스
// leaves : 리프노드 (출력값)

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 노드 데이터 클래스
    data class Node (
        val childrenIdx: LinkedList<Int> = LinkedList<Int>()
    )

    // 변수 초기화
    readLine()
    val parentIndexes = readLine().split(" ").map { it.toInt() }
    val deletedNode = readLine().toInt()
    val nodes = Array(parentIndexes.size) { Node() }
    var rootList = arrayListOf<Int>()
    var leaves = 0

    // 삭제되어 사라지는 노드를 제외하고 정보를 저장
    for (idx in parentIndexes.indices){
        if (idx == deletedNode || parentIndexes[idx] == deletedNode) continue
        if (parentIndexes[idx] == -1) {
            rootList.add(idx)
            continue
        }
        nodes[parentIndexes[idx]].childrenIdx.add(idx)
    }

    fun searchChild(idx: Int){
        // 리프노드라면 leaves + 1
        if (nodes[idx].childrenIdx.isEmpty()) leaves += 1
        else {
            // idx번째 노드의 하위 노드들 모두 탐색
            for (childIdx in nodes[idx].childrenIdx)
                searchChild(childIdx)
        }
    }
    // 루트노드들과 하위 노드들 모두 탐색
    for (root in rootList) searchChild(root)
    println(leaves)
}