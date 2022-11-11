# 문제 링크 : https://www.acmicpc.net/problem/1120
# 제출 공유 링크 : http://boj.kr/a3eafee8321f4453ab124de0f1a997f6

a, b = input().split()
answer = 50

len_dif = len(b)-len(a)
for d in range(len_dif+1):
    temp = 0
    for i in range(len(a)):
        if a[i] != b[d+i]: temp += 1
    
    if temp < answer: answer = temp

print(answer)