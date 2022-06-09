##설명도 필요없는 완전탐색..

def solution(answers):
    correct = [0,0,0]
    answer = []
    
    array = [[1, 2, 3, 4, 5],[2, 1, 2, 3, 2, 4, 2, 5],[3, 3, 1, 1, 2, 2, 4, 4, 5, 5],[5,8,10]]
    for i in range (len(answers)):
        for o in range (0,3):
            div = array[3][o]
            if answers[i] == array[o][i%div]:
                correct[o]+=1
    
    temp = max(correct)
    for i in range (0,3):
        if temp == correct[i]: answer.append(i+1)
    
    return answer

##정확성: 100.0
##합계: 100.0 / 100.0
