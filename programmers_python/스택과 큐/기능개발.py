##그냥 가장 앞에있는 기능이 언제 끝날지 계산하고
##뒤에있는 작업도 계산해서 이미 끝나있으면 count에 작업 갯수를 +1해준다.
##answer에 같이 배포되는 작업이 몇 개인지 넣어주는게 전부...

import math

def solution(progresses, speeds):
    answer = []
    day = 0     #끝나는 기간 저장
    count = 0   #기간 내에 진도가 완료된 작업이 몇개인지 저장
    i = 0   	#배열의 위치를 탐색할 때 쓰이는 것
    
    leng = len(progresses)
    while i < leng:
        day = math.ceil((100 - progresses[i])/speeds[i]) #끝나는 기간 계산
        while i < leng:
            if progresses[i] + speeds[i]*day >= 100:  
                count += 1  
                i += 1
            else:  break
            
        answer.append(count)
        count = 0
    
    return answer
