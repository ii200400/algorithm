##이름은 이중우선순위큐인데 이중우선순위큐가 뭔지도 검색이 안되는데
##아래와 같이 그냥 min,max로도 풀린다...
##정확성 테스트만 조금 있고 그 마저도 6개밖에 없다..;

def solution(operations):
    l = []
    for i in operations:
        op, num = i.split()
        
        if op == 'I':
            l.append(int(num))
        elif op == 'D' and len(l) > 0:
            if num == '1': l.remove(max(l))
            else: l.remove(min(l))
    
    return [max(l, default = 0), min(l, default = 0)]

##정확성: 100.0
##합계: 100.0 / 100.0

##heapq로 한번 풀고싶어서 시도해보았다.
