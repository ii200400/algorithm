##나는 정말 스텍을 이용하는 방법을 택했다. for문 1번을 사용하는 대신 while문을 한번 더 썼다.
##다른 사람들은 이중 for문 돌려서
##자신의 높이보다 높은 탑 이 나오면 바로 braek하도록 만들었다.

def solution(heights):
    answer = [0 for i in range(len(heights))]
    li = []
    
    for i in range(len(heights)-1,-1,-1):
        while(True):
            l = len(li)
            if l == 0 or heights[i] <= li[l-1][0]: 
                li.append([heights[i],i+1])
                break
            else: 
                answer[li[l-1][1]-1] = i+1
                li.pop()
    
    return answer

##정확성: 100.0
##합계: 100.0 / 100.0
