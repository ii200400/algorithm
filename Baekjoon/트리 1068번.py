# 문제 링크 : https://www.acmicpc.net/problem/4256
# 제출 공유 링크 : 
# 

node_number = input()
list_ = list(map(int, input().split()))
cut_index = int(input())

list_[cut_index] = -2
# -2 삭제 -1 루트
for i in range(1, len(list_)):
    if (list_[list_[i]] == -2): list_[i] = -2

answer = 0
for i in range(len(list_)-1, 0, -1):
    if (list_[list_[i]] != -2): 
        list_[list_[i]] = -2
        answer += 1

print(answer)