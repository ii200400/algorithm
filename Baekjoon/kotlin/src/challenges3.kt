import java.util.*
import kotlin.math.ceil
import kotlin.math.max

class Solution3{
    // carRecords : 차량별 출입 시간
    // carsFee : 차량별 요금
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val carRecords = mutableMapOf<String, LinkedList<String>>()
        for (record in records) {
            val (time, carNum, _) = record.split(" ")
            val carRecord = carRecords.getOrDefault(carNum, LinkedList())
            carRecord.addLast(time)
            carRecords[carNum] = carRecord
        }
        println(carRecords)

        val carsFee = mutableMapOf<String, Int>()
        for ((carNum, times) in carRecords){
            // 출차를 안한 경우 처리
            if (times.size % 2 == 1) times.addLast("23:59")

            var timeSum = 0
            var idx = 0
            while (idx < times.size){
                val (hourIn, minIn) = times[idx].split(":").map { it.toInt() }
                val (hourOut, minOut) = times[idx+1].split(":").map { it.toInt() }
                timeSum += (hourOut * 60 + minOut) - (hourIn * 60 + minIn)
                idx += 2
            }
            carsFee[carNum] = fees[1] + max(ceil(((timeSum.toDouble() - fees[0]) / fees[2])).toInt() * fees[3], 0)
        }

        val carsFeeList = carsFee.toSortedMap().toList()
        return IntArray(carsFee.size){ carsFeeList[it].second }
    }
}

//fun main() {
//    var fees = intArrayOf(180, 5000, 10, 600)
//    var records = arrayOf("05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT")
//    println(Solution3().solution(fees, records).contentToString())
//
//    fees = intArrayOf(120, 0, 60, 591)
//    records = arrayOf("16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN")
//    println(Solution3().solution(fees, records).contentToString())
//}