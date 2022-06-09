##에라토스테네스의 체를 사용하지 않고 맨땅에 헤딩한 결과
##그냥 쓰고하자.. 너무 느리고 길다;;

##import math
##import collections
##
##def solution(numbers):
##    answer = 0
##    prime_numbers = [2]
##    dic = {'0':0,'1':0,'2':0,'3':0,'4':0,'5':0,'6':0,'7':0,'8':0,'9':0}
##    for i in numbers: dic[i] += 1
##    if dic['2'] >= 1: answer += 1
##    
##    #종이의 갯수만큼의 n자리수 내에서 소수를 찾는다.
##    for i in range(3,10**len(numbers)):
##        for j in prime_numbers:
##            if j**2 > i: #소수가 맞다면 prime_numbers에 추가하고 가진 종이로 만들 수 있는 수인지 확인
##                prime_numbers.append(i)
##                answer +=1 #우선 1을 더하고 만들 수 없다면 -1을 하는 방식
##                for key, val in dict(collections.Counter(str(i))).items():
##                    if dic[key] < val: 
##                        answer -=1
##                        break
##                break
##                
##            elif i%j == 0: break #현 숫자가 소수가 아니면 다음 수 검별 시작
##                
##    return answer

##정확성: 83.3 (시간초과로 인하여 실패)
##합계: 83.3 / 100.0

##에라토스테네스의 체 사용
##모든 조합을 튜플들이 있는 리스트로 반환하는 permutations 활용

from itertools import permutations

def solution(numbers):
    #n번째 숫자까지 에라토스테네스의 체를 사용하여 소수를 탐색
    n = 10**(len(numbers)+1)
    prime_numbers = [False, False] + [True] * (n - 1) 
    for k in range(2, int(n ** 0.5 + 1.5)):
        if prime_numbers[k]:
            #https://stackoverflow.com/questions/9027862/what-does-listxy-do
            prime_numbers[k*2::k] = [False] * ((n - k) // k)

    #주어진 숫자로 만들 수 있는 모든 숫자들을 만든다. permutations을 활용함.
    answer = 0
    for i in range(1,len(numbers)+1):
        li = list(permutations(numbers, i))
        for j in li:
            num = int(''.join(j))
            if prime_numbers[num]:  #만들 수 있는 숫자가 소수로 판명된 수 일때
                answer += 1
                prime_numbers[num] = False #중복방지를 위해 False로 바꾸어 준다.
                
                
    return answer

##다른 사람의 코드인데 깔끔하고 잘했다. 그런데 너무 전문적이고 설명이 없는게..
##덕분에 공부 잘 되었다 헿

##from itertools import permutations
##
##def solution(n):
##    a = set()
##    for i in range(len(n)):
##        a |= set(map(int, map("".join, permutations(list(n), i + 1))))
##    a -= set(range(0, 2))
##    for i in range(2, int(max(a) ** 0.5) + 1):
##        a -= set(range(i * 2, max(a) + 1, i))
##    return len(a)
