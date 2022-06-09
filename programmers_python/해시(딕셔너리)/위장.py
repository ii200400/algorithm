def solution(clothes):
    dic = {}
    for i in clothes:
        if dic.get(i[1]) == None: dic[i[1]] = [i[0]]
        else: dic[i[1]].append(i[0])
            
    count = 1
    for i in dic.values():
        count *= len(i)+1
    
    return count-1

##정확성: 100.0
##합계: 100.0 / 100.0

#딕셔너리의 초기화를 더 빠르게 하고 메모리도 더 적게 먹는 방향
#'과거의 나'가 왜 리스트를 써서 시간과 메모리를 많이 잡아먹었는지 의문..
def solution(clothes):    
    dic = {}
    for i in range(len(clothes)):
        dic[clothes[i][1]] = dic.get(clothes[i][1], 0) + 1
        
    answer = 1
    for _,val in dic.items():
        answer *= val+1
        
    return answer - 1
