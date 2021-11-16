// 문제 링크 : https://www.acmicpc.net/problem/15662
// 제출 공유 링크 : http://boj.kr/e183d8f0aa85444b8ea3dca03425d561

import java.util.*

fun main15662(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()
    // 각 기어의 n/s극을 기억하는 리스트 초기화
    val gearL = Array(t) {
        val inputGear = sc.next()
        Array(8) { i -> Character.getNumericValue(inputGear[i]) }

    }
    // for (i in 0 until t){
    // 	println(gearL[i].contentToString())
    // }

    // 각 기어의 가장 위의(12시 방향의) 인덱스를 기억하는 리스트
    val gear12 = Array(t) { 0 }
    for (i in 0 until sc.nextInt()){
        // 리스트의 인덱스에 맞추기 위해 -1
        val selectedGear = sc.nextInt() - 1
        // 시계방향으로 돌면 -1, 반시계는 1을 더하기 위함
        val rot = sc.nextInt() * - 1
        // 각 기어가 어느 방향으로 돌았는지 기록하는 리스트
        val gearRot = MutableList(t) { 0 }
        gearRot[selectedGear] = rot

        // 선택된 기어의 오른쪽에 있는 기어를 움직임
        var tempRot = rot
        for (idx in selectedGear until t-1) {
            if (gearL[idx][(gear12[idx]+2)%8] != gearL[idx+1][(gear12[idx+1]+6)%8]){
                tempRot *= -1
                gearRot[idx+1] = tempRot
            }
            else break
        }

        // 선택된 기어의 왼쪽에 있는 기어를 움직임
        tempRot = rot
        for (idx in selectedGear downTo 1){
            if (gearL[idx-1][(gear12[idx-1]+2)%8] != gearL[idx][(gear12[idx]+6)%8]){
                tempRot *= -1
                gearRot[idx-1] = tempRot
            }
            else break
        }

        for (idx in 0 until t){
            gear12[idx] = (gear12[idx] + gearRot[idx] + 8)%8
        }
        // println(gear12.contentToString())
    }

    var answer = 0
    for (idx in 0 until t){
        answer += gearL[idx][gear12[idx]]
    }
    println(answer)
}