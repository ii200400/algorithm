## 조금 복잡하며 큐를 기반으로 작성하였다.
def solution(priorities, location):
    answer = 0
    li = [0,0,0,0,0,0,0,0,0,0] #대기 중요도별 작업 수
    location_number = priorities[location]
    current_number = 10 
    l = len(priorities)
    point = -1 #대기 숫자중 가장 늦게 인쇄 되는 것을 탐색해서 저장
    
    for i in priorities:
        li[i] += 1
    current_number = a(li,current_number)
    #해당 작업 이상의 중요도를 가지는 작업들을 세고 마지막 작업의 위치 저장(point-이것에 따라서 같은 중요도라도 작업 순서가 달라져서 중요하다.)
    while(current_number != location_number):
        point -= 1
        if point < 0:
            point = l-1
            
        if priorities[point] != current_number:
            continue
            
        else:
            answer += li[current_number]
            li[current_number] = 0
            current_number = a(li,current_number)
            
    while(True):
        point += 1
        if point > l-1:
            point = 0
            
        if priorities[point] == location_number:
            answer += 1
        if point == location:
            break
    
    return answer

def a(li,current_number):
    for i in range (current_number-1,0,-1):
        if li[i] > 0:
            return i

##정확성: 100.0 (0.05ms이하)
##합계: 100.0 / 100.0
