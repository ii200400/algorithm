##remove함수 사용 방식
##def solution(participant, completion):
##    
##    for i in completion:
##        participant.remove(i)
##    answer = participant[0]
##    
##    return answer
##
##정확성: 50.0 (3ms 이하)
##효율성: 0.0
##합계: 50.0 / 100.0

##두 리스트의 내용을 하나씩 비교하면서 completion에 값이 없으면 출력하는 형식
##def solution(participant, completion):
##    answer=''
##    l = len(completion)
##    number = -1
##    
##    for i in range (len(participant)):
##        for o in range (l):
##            if participant[i] == completion[o]:
##                completion[o] = ''
##                break
##            if o == (l-1):
##                number = i
##        if number != -1:
##            break
##            
##    answer = participant[number]
##    return answer
##
##정확성: 50.0 (21ms 이하;;)
##효율성: 0.0
##합계: 50.0 / 100.0

##딕셔너리를 이용한 방법
##
##def solution(participant, completion):
##    answer=''
##    dic = {}
##    
##    for i in completion:
##        if dic.get(i):
##            dic[i] += 1
##        else:
##            dic[i] = 1
##            
##    for i in participant:
##        if dic.get(i):
##            if dic[i] == 0:
##                return  i
##            dic[i] -= 1
##        else:
##            return i
##    
##    return answer
##
##정확성: 50.0 (0.3ms 이하)
##효율성: 50.0 (50ms 이하)
##합계: 100.0 / 100.0
