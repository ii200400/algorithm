##zip함수를 쓰는 사람이 많았는데
##아직 이 함수가 뭔지 몰라서 있는지도 모르고 안썼다;;
##이 알고리즘에서 왜 쓰이는지는 잘 모르겠다.. 딱히 안 써도 되는 것 같다.
##이중딕셔너리도 쓰고 여러모로 딕셔너리 조작 연습이 많이 된 문제

import operator

def solution(genres, plays):
    
    def a(dic):
        count = 2 #장르당 최대 2개씩만 들어가므로
        #key기준으로 정렬
        for play, numbers in sorted(dic.items(), key = operator.itemgetter(0), reverse=True):
            for number in numbers:
                answer.append(number)
                count-=1
                if count == 0: return
    
    answer = []
    sum_dic = {} #딕셔너리
    genres_info = {} #2중 딕셔너리로 사용 예정
    for i in range(len(genres)): 
        #딕셔너리에 장르가 있으면 재생 횟수를 기존 값에 더하고 아니면 장르 추가 (삼항연산자 이용)
        sum_dic[genres[i]] = plays[i] if not sum_dic.get(genres[i]) else  sum_dic[genres[i]]+plays[i] 
        #아래는 장르의 정보를 넣는 코드
        if genres_info.get(genres[i]): 
            #장르에 같은 재생횟수의 곡이 이미 있을 때
            if genres_info.get(genres[i]).get(plays[i]): genres_info[genres[i]][plays[i]].append(i)
            #같은 재생횟수를 가지는 곡이 없을 때
            else: genres_info[genres[i]][plays[i]] = [i]
        #장르가 없을 때
        else: genres_info[genres[i]] = {plays[i]:[i]}
    
    #value 기준으로 정렬
    for key, val in sorted(sum_dic.items(), key = operator.itemgetter(1), reverse=True): 
        a(genres_info[key])
            
    return answer
