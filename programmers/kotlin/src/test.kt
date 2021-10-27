class Solution1 {
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