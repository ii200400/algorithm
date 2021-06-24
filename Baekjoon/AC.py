# 문제 링크 : https://www.acmicpc.net/problem/5430
# 제출 공유 링크 : http://boj.kr/4cdf9606ab384ec09808192ceee34c9c

# 리스트를 가져올 때, 정규표현식을 사용하고
# D 연산자가 나올 때마다, (역순인지 확인하고) 범위를 한칸씩 줄이다가
# 출력하기 전에 error인지 확인한 후에 위에서 만든 범위를 활용하여
# 결과 리스트를 출력한다.

import sys, re
input = lambda : sys.stdin.readline().rstrip()

# 테스트 케이스 만큼 반복
for i in range(int(input())):
    # 연산자 저장 문자열
    ops = input()
    input()
    # 숫자 저장 문자열
    nums = re.findall('\d+', input())
    # print(nums)
    # 역순 확인 변수, 시작 인덱스, 종료 인덱스 
    reverse, start, end = False, -1, len(nums)
    
    # 연산자 만큼 반복
    for op in ops:
        # 연산자가 R일 때,
        if op == 'R': reverse = not reverse
        # 연산자가 D일 때,
        elif not reverse: start += 1
        else: end -= 1

    # 포함된 숫자보다 더 많은 D가 있던 경우
    if start >= end: 
        print("error")
        continue

    # 결과 리스트를 만드는 부분
    elif not reverse: first, second, step = start+1, end, 1
    else: first, second, step = end-1, start, -1

    string = ""
    for idx in range(first, second, step):
        string += str(nums[idx])+','
    print('['+string[:-1]+']')
