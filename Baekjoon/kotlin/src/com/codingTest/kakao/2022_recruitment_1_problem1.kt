class Solution1 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        // 변수 초기화
        // userMailMap: id별 메일 받은 회수 저장
        // reportMap : 신고당한 id을 key로 신고한 id 저장
        val userMailMap = mutableMapOf<String, Int>()
        val reportMap = mutableMapOf<String, MutableSet<String>>()

        for (id in id_list) userMailMap[id] = 0
        for (content in report){
            val (user, reported) = content.split(" ")
            val set = reportMap.getOrDefault(reported, mutableSetOf())
            set.add(user)
            reportMap[reported] = set
        }

        // 신고 회수가 일정 이상이면 신고자의 메일 발송 횟수 증가
        for ((reported, users) in reportMap){
            if (users.size >= k) {
                for (user in users)
                    userMailMap[user] = userMailMap.getOrDefault(user, 0) + 1
            }
        }

        // id_list에 쓰여진 id 순서에 따라서 userMailMap을 IntArray형식으로 변경
        val answer = IntArray(id_list.size){ 0 }
        for (idx in id_list.indices)
            answer[idx] = userMailMap[id_list[idx]]!!

        return answer
    }
}

//fun main(){
//    var idList = arrayOf("muzi", "frodo", "apeach", "neo")
//    var report = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi")
//    var k = 2
//    println(Solution1().solution(idList, report, k).contentToString())
//
//    idList = arrayOf("con", "ryan")
//    report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con")
//    k = 3
//    println(Solution1().solution(idList, report, k).contentToString())
//}