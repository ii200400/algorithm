class Sort{
    fun bubbleSort(A: Array<Int>){
        var flag = 0
        for (i in 0 until A.size - 1) {
            flag = 0
            for (j in 0 until  A.size - (i+1)) {
                if (A[j] > A[j + 1]) {
                    flag = 1
                    val temp = A[j]
                    A[j] = A[j + 1]
                    A[j + 1] = temp
                }
            }
            if (flag == 0) break
        }
    }

    fun selectionSort(A: Array<Int>){
        var indexMin: Int
        var temp: Int

        for (i in 0 until A.size - 1) {
            indexMin = i
            for (j in i + 1 until A.size)
                if (A[j] < A[indexMin]) indexMin = j
            temp = A[indexMin]
            A[indexMin] = A[i]
            A[i] = temp
        }
    }

    fun insertSort(A: Array<Int>){
        for (index in 1 until A.size) {
            val temp: Int = A[index]
            var aux = index - 1
            while (aux >= 0 && A[aux] > temp) {
                A[aux + 1] = A[aux]
                aux--
            }
            A[aux + 1] = temp
        }
    }

    // A 정렬하고 싶은 리스트, tempA A리스트의 복사본, low/high 정렬하고 싶은 범위(low와 high 포함)
    // A 리스트 자체를 정렬시킨다.
    fun mergeSort(A: Array<Int>, tempA: Array<Int>, low: Int, high: Int){
        if (low >= high) return

        val mid = (low + high) / 2
        mergeSort(A, tempA, low, mid)
        mergeSort(A, tempA, mid+1, high)

        var leftIdx = low
        var rightIdx = mid+1
        var tempIdx = low
        while (tempIdx <= high){
            when {
                leftIdx > mid -> {
                    tempA[tempIdx] = A[rightIdx]
                    rightIdx += 1
                }
                rightIdx > high -> {
                    tempA[tempIdx] = A[leftIdx]
                    leftIdx += 1
                }
                A[leftIdx] <= A[rightIdx] -> {
                    tempA[tempIdx] = A[leftIdx]
                    leftIdx += 1
                }
                else -> {
                    tempA[tempIdx] = A[rightIdx]
                    rightIdx += 1
                }
            }

            tempIdx += 1
        }

        for (i in low..high) A[i] = tempA[i]
    }

    // A 정렬하고 싶은 리스트
    // A를 정렬시킨 새로운 리스트를 반환한다.
    // 위의 공간 복잡도는 O(n)인 반면 이것은 O(n^2)이다.
    fun mergeSortNeedLargeMemory(A: Array<Int>): Array<Int>{
        if (A.size <= 1) return A

        fun merge(a1: Array<Int>, a2: Array<Int>): Array<Int>{
            if (a1.isEmpty()) return a2
            if (a2.isEmpty()) return a1

            return if (a1[0] <= a2[0]) arrayOf(a1[0]) + merge(a1.sliceArray(1 until a1.size), a2)
            else arrayOf(a2[0]) + merge(a1, a2.sliceArray(1 until a2.size))
        }

        return merge(mergeSortNeedLargeMemory(A.sliceArray(0 until A.size/2)), mergeSortNeedLargeMemory(A.sliceArray(A.size/2 until A.size)))
    }

    // A: 정렬하고 싶은 리스트, start/end: 정렬하고 싶은 범위(start와 end 포함)
    // A 리스트 자체를 정렬시킨다.
    // while문 내부를 일반적인 퀵 소트 알고리즘과 약간 다르게 만들었으나 크게 다르지 않다.
    fun quickSort(A: Array<Int>, start: Int, end: Int){
        val pivot = A[start]
        var left = start+1
        var right = end

        while (true){
            while (left <= right && A[left] <= pivot) left += 1
            while (left <= right && pivot <= A[right]) right -= 1

            if (left > right) break
            val temp = A[left]
            A[left] = A[right]
            A[right] = temp
        }

        A[start] = A[right]
        A[right] = pivot

        // 숫자 하나만 남아있다면 정렬된 것과 같으므로
        if (right - start > 2) quickSort(A, start, right-1)
        if (end - right > 2) quickSort(A, right+1, end)
    }
}

fun main(){
    val a = arrayOf(3,2,1,3,2,1,3,2,1)
    println(a.contentToString())
    Sort().quickSort(a, 0, a.size-1)
    println(a.contentToString())
}