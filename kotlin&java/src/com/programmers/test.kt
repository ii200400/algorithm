class Solution_1 {
    fun solution(A: IntArray): Int {
        val haveNumber = Array(100002){ false }
        haveNumber[0] = true
        for (idx in A) if (idx in 1..100000) haveNumber[idx] = true
        return haveNumber.indexOfFirst { !it }
    }
}

class Solution0 {
    fun solution1(S: String): Int {
        var answer = 201

        for (first in 0..S.length - 2) {
            for (end in first + 1 until S.length) {
                val slicedString = S.slice(first..end)
                val lowSet = mutableSetOf<Char>()
                val upperSet = mutableSetOf<Char>()
                for (s in slicedString) {
                    if (s.isLowerCase()) lowSet.add(s)
                    else upperSet.add(s)
                }

                if (lowSet.containsAll(upperSet.map { it.toLowerCase() }) && upperSet.containsAll(lowSet.map { it.toUpperCase() })) {
                    println(slicedString)
                    if (answer > end - first + 1) answer = end - first + 1
                }
            }
        }
        return if (answer == 201) -1 else answer
    }

    //    class University(private val repository: Repository<Student>) {
//        fun getPaidCoursesWithTheNumbersOfSubscribedStudents(coursesCount: Int): Map<Course, Int> =
//            {
//                println(repository.subscribedCourses)
//                mapof(Course("Math") to 2))
//            }
//    }
    fun solution3(A: IntArray): Int {
        var answer = 0
        val a = Array(60001) { 0 }
        for (idx in 1..60000) a[idx] = a[idx - 1] + idx

        var start = 0
        var end = 1
        var vel = 0
        while (true){
            println("$start, $end")
            start = end - 1
            vel = A[end] - A[start]
            if (start >= A.size-2) break

            while (end < A.size){
                if (A[end] - A[end-1] != vel) break
                end += 1
            }
            if (end-start >= 3) answer += a[end-start-2]
        }

        return answer
    }
}

fun main() {
    val test2 = intArrayOf(1, 9, 8, 3, 6, 3, 9, 5, 1, 4, 2)
    val test = intArrayOf(98, 2, 37, 5, 12)
    val a = intArrayOf(23, 32, 12, 98, 3, 2, 1, 9, 6, 2, 12, 32, 12, 3, 2, 8, 45, 2, 3, 21)
    val b = intArrayOf(32, 12, 98, 3, 86, 42, 23, 12, 2, 1, 9, 6, 2, 12, 32, 12, 3, 2, 8, 45, 2, 3, 21, 37, 92, 53, 68, 49, 13, 87)

    fun LIS(array:IntArray): IntArray{
        val sol = IntArray(array.size){ 1 }

        array.forEachIndexed { idx, num ->
            var max = 0
            for (solIdx in 0 until idx){
                if (array[solIdx] < num) {
                    max = maxOf(max, sol[solIdx])
                }
            }

            sol[idx] = max + 1
        }
        println(sol.contentToString())
        return sol
    }

    fun plusArray(a:IntArray, b:IntArray): IntArray{
        val pluedArray = IntArray(a.size){0}
        for (idx in a.indices){
            pluedArray[idx] = a[idx] + b[idx]
        }
        return pluedArray
    }

    val plustest2 = plusArray(LIS(test2), LIS(test2.reversedArray()).reversedArray())
    val plusTest = plusArray(LIS(test), LIS(test.reversedArray()).reversedArray())
    val plusA = plusArray(LIS(a), LIS(a.reversedArray()).reversedArray())
    val plusB = plusArray(LIS(b), LIS(b.reversedArray()).reversedArray())
    println(plustest2.contentToString())
    println((plustest2.maxOrNull() ?: 1) -1)
    println(plusTest.contentToString())
    println((plusTest.maxOrNull() ?: 1) -1)
    println(plusA.contentToString())
    println((plusA.maxOrNull() ?: 1) -1)
    println(plusB.contentToString())
    println((plusB.maxOrNull() ?: 1) -1)
}