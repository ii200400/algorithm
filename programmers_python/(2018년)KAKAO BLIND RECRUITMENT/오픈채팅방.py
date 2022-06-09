##딕셔너리를 사용하여 리스트를 만듦.

def solution(record):
    answer = []
    dic = {}
    for massage in record:
        li = massage.split(' ')
        if li[0] == 'Enter':
            answer.append([li[0], li[1]])
            dic[li[1]] = li[2]
        elif li[0] == 'Leave': answer.append([li[0], li[1]])
        else: dic[li[1]] = li[2]
    
    for i in range(len(answer)):
        if answer[i][0] == 'Enter': answer[i] = dic[answer[i][1]] + "님이 들어왔습니다."
        elif answer[i][0] == 'Leave': answer[i] = dic[answer[i][1]] + "님이 나갔습니다."
    
    return answer

##정확성: 100.0
##합계: 100.0 / 100.0
