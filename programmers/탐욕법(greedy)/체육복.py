##append와 remove쓰기 싫어서 이렇게 했다. 보통은 쓰더라..

def solution(n, lost, reserve):
    answer = n - len(lost)
    
    li=[[0]*32,[0]*31] #학생번호는 1부터 시작, 리스트는 0부터 시작
    for i in lost: li[0][i] = 1
    for i in reserve: li[1][i] = 1

    for i in range (len(li[1])):
        if li[1][i] == 1 and li[0][i] == 1: 
            li[1][i] = 0
            li[0][i] = 0
            answer += 1
            
    for i in range (len(li[1])):
        if li[1][i] == 1:
            if li[0][i-1] == 1: answer+=1
            elif li[0][i+1] == 1:
                li[0][i+1] = 0
                answer += 1
    
    return answer

##a = [1,2,3,4]
##for i in a:
##    a.remove(i)
##print(a)
##
##>>>[2,4]
##가 출력되는 것을 올라서 해매다가 결국 아래 코드를 만들었다.

##def solution(n, lost, reserve):
##    reserve.sort()
##    i = 0
##    while i < len(reserve):
##        if reserve[i] in lost:
##            lost.remove(reserve[i])
##            reserve.pop(i)
##            i -= 1
##        i += 1
##    
##    answer = n - len(lost)
##    print(lost,reserve)
##    
##    for i in reserve:
##        if i-1 in lost: 
##            lost.remove(i-1)
##            answer += 1
##        elif i+1 in lost:
##            lost.remove(i+1)
##            answer += 1
##    
##    return answer

##정확성: 100.0
##합계: 100.0 / 100.0
