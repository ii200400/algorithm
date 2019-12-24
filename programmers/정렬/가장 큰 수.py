##시간을 버리고 편리성을 가졌다.

def solution(numbers):
    answer = ''
    #내가 만들었지만 이게 무슨 내용인지 모르겠다..
    for i in sorted([str(i) for i in numbers],key=lambda x: ((str(x)*3)[0:8], len(x)), reverse = True):
        answer += i
    
    return str(int(answer))

##정확성: 100.0
##합계: 100.0 / 100.0

#for i in sorted([str(i) for i in numbers],key=lambda x: ((str(x)*3)[0:8], len(x)), reverse = True):
#대신에
#for i in sorted([str(i) for i in numbers],key=lambda x: str(x)*3, reverse = True):
#도 가능하다.
