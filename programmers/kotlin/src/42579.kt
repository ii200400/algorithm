// 문제 링크 : https://www.welcomekakao.com/learn/courses/30/lessons/42579

// 장르가 가장 많이 재생된 map 변수(genresPlay)와
// 장르별 / 노래 재생 회수별, 곡 고유번호 저장된 map 변수(genresSongList)로 문제를 해결할 예정이다.
// genresPlay로 가장 많이 재생된 장르들을 나열하고
// genresSongList로 장르별 가장 많이 재생된 노래 2가지를 선택한다.

// 문제 링크 : https://www.welcomekakao.com/learn/courses/30/lessons/42579

// 장르가 가장 많이 재생된 map 변수(genresPlay)와
// 장르별 / 노래 재생 회수별, 곡 고유번호 저장된 map 변수(genresSongList)로 문제를 해결할 예정이다.
// genresPlay로 가장 많이 재생된 장르들을 나열하고
// genresSongList로 장르별 가장 많이 재생된 노래 2가지를 선택한다.

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        // 변수 초기화
        val genresPlay = mutableMapOf<String, Int>()
        val genresSongList = mutableMapOf<String, MutableMap<Int, ArrayList<Int>>>()

        for (idx in genres.indices){
            genresPlay[genres[idx]] = genresPlay.getOrDefault(genres[idx], 0) + plays[idx]

            if(genresSongList[genres[idx]] != null){
                if (genresSongList[genres[idx]]!![plays[idx]] != null)
                // 장르도 재생된 회수도 같은 노래가 있는 경우
                    genresSongList[genres[idx]]!![plays[idx]]!!.add(idx)
                else // 장르는 있지만 재생된 회수가 같은 경우는 없는 경우
                    genresSongList[genres[idx]]!![plays[idx]] = arrayListOf(idx)
            }else{ // 장르부터 없는 경우
                genresSongList[genres[idx]] = mutableMapOf(plays[idx] to arrayListOf(idx))
            }
        }
        var answer = arrayListOf<Int>()

        fun pickSongs(genre: String){
            var cnt = 0
            for ((play, songIndexes) in genresSongList[genre]!!.toSortedMap(reverseOrder())){
                for (songIdx in songIndexes){
                    answer.add(songIdx)
                    cnt += 1

                    if (cnt == 2) return
                }
            }
        }

        // 가장 많이 불린 장르 순으로 정렬
        for ((genre, _) in genresPlay.toList().sortedByDescending { it.second }){
            // 각 장르 내 가장 많이 불린 노래 2개 선택
            pickSongs(genre)
        }

        return answer.toIntArray()
    }
}

//결과
//정확성  테스트
//테스트 1 〉	통과 (18.19ms, 60.5MB)
//테스트 2 〉	통과 (17.26ms, 60MB)
//테스트 3 〉	통과 (9.96ms, 57.5MB)
//테스트 4 〉	통과 (10.06ms, 57.4MB)
//테스트 5 〉	통과 (20.62ms, 60.3MB)
//테스트 6 〉	통과 (17.72ms, 60.1MB)
//테스트 7 〉	통과 (17.58ms, 60MB)
//테스트 8 〉	통과 (17.63ms, 60.5MB)
//테스트 9 〉	통과 (22.60ms, 60MB)
//테스트 10 〉	통과 (22.36ms, 59.5MB)
//테스트 11 〉	통과 (18.01ms, 59.8MB)
//테스트 12 〉	통과 (17.88ms, 60.5MB)
//테스트 13 〉	통과 (23.13ms, 60.4MB)
//테스트 14 〉	통과 (17.91ms, 60.6MB)
//테스트 15 〉	통과 (17.27ms, 60.1MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0