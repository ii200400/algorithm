
class Solution4 {
    fun solution(n: Int, info: IntArray): IntArray {
        var maxDiff = 0
        var pickedScore: BooleanArray? = null
        val winInfo = Array(11){ info[it]+1 }
        var answer: IntArray? = null

        fun search(idx: Int, arrow: Int, picked: BooleanArray){
            if (arrow > n) return
            if (idx == -1){
                var scoreA = 0
                var scoreR = 0
                for (i in 0..10) {
                    if (picked[i]) scoreR += 10 - i
                    else if (info[i] == 0) continue
                    else scoreA += 10 - i
                }
                if ((scoreR - scoreA) > maxDiff) {
                    maxDiff = scoreR - scoreA
                    pickedScore = picked.clone()
                }

                return
            }

            val pickedCopy = picked.clone()
            pickedCopy[idx] = true
            search(idx-1, arrow+winInfo[idx], pickedCopy)
            pickedCopy[idx] = false
            search(idx-1, arrow, pickedCopy)
        }
        search(10, 0, BooleanArray(11){ false })

        if (pickedScore != null){
            answer = IntArray(11){ if (pickedScore!![it]) winInfo[it] else 0 }

            var arrowCount = 0
            for (num in answer)
                arrowCount += num
            if (arrowCount < n) answer[10] += n - arrowCount
        }
        return answer ?: intArrayOf(-1)
    }
}

//fun main() {
//    println(Solution4().solution(5, intArrayOf(2,1,1,1,0,0,0,0,0,0,0)).contentToString())
//    println(Solution4().solution(5, intArrayOf(4,1,0,0,0,0,0,0,0,0,0)).contentToString())
//}