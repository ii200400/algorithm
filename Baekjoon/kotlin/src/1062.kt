// 문제 링크 : https://www.acmicpc.net/problem/1062
// 제출 공유 링크 : http://boj.kr/b57cd096a921468f99d15eb512f9a28e

// acint 는 필수적으로 배워야 하는 글자임을 착안해서 만든 코드
// acint 글자는 배웠다고 가정하고 배워야하는 글자 후보들을 입력값에서 추려낸다.
// 글자들을 선택하는 방법은 브루트 포스로 모든 경우를 살피고
// 가장 많은 단어를 배우는 경우 answer 변수에 저장하여 풀었다.

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (n, k) = readLine().split(" ").map { it.toInt() }
    // acint - 5글자는 필수적이므로
    if (k < 5) {
        println("0")
        return
    }

    // acint에 해당하는 부분은 false 설정을 하여 연산을 줄인다.
    // 단어를 받아오면서 단어 속의 철자가 쓰이는지 needAlpha에 저장한다.
    val needAlpha = BooleanArray(26){ false }
    val wordsSet = Array(n){
        val word = readLine().toString().replace("[acint]".toRegex(), "")
        for (char in word) needAlpha[char.toInt()-97] = true
        word.toSet()
    }
    k -= 5
//    println(wordsSet.contentDeepToString())
//    println(needAlpha.contentToString())

    // 가르칠 시간이 배울 알파벳 후보의 수 보다 크면 바로 n 출력
    if (k >= needAlpha.sumBy { if (it) 1 else 0 }) {
        println(n)
        return
    }

    // acint - arrayOf(0, 2, 9, 14, 20)
    val learnSet = mutableSetOf<Char>()
    var answer = 0
    fun learnChar(idx: Int){
        // 글자를 모두 배웠다면
        if (learnSet.size == k){
            var count = 0
            for (wordSet in wordsSet){
                if (learnSet.containsAll(wordSet)) count += 1
            }
            
            answer = max(answer, count)
            return
        } else if (idx == 26) return

        // acint 글자는 생략
        if (idx in arrayOf(0, 2, 8, 13, 19)){
            learnChar(idx+1)
        }else{
            learnSet.add((idx+97).toChar())
            learnChar(idx+1)
            learnSet.remove((idx+97).toChar())
            learnChar(idx+1)
        }
    }
    learnChar(0)

    println(answer)
}