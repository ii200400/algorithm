# 문제 링크 : https://www.acmicpc.net/problem/10942
# 제출 공유 링크 : http://boj.kr/e5995326d6ea4c90866d4ec4da71b960
# 어.. 2번 방법으로 풀렸다. 팰림드롬인지 확인할 때 연산을 1번씩 더 하게되는데 그것때문에 느려서 실패했나보다..

# 1 시간초과
# input()
# nums = list(map(int, input().split()))
# even_pal = [-1 for _ in range(len(nums))] # 짝수 갯수의 팰린드롬
# odd_pal = [0 for _ in range(len(nums))] # 홀수 갯수의 팰린드롬, 숫자 하나는 ex[1] 무조건 팰린드롬이기 때문에 초기값이 0
# for _ in range(int(input())):
#     start, end = map(int, input().split())
#     start -= 1 # 인덱스는 0부터 시작하므로
#     end -= 1

#     sum_ = start+end
#     mid = int(sum_/2) 
#     if sum_%2 == 1:
#         temp = even_pal[mid] 
#         for i in range(temp+1, mid-start):
#             if nums[mid-i] == nums[mid+i+1]:
#                 even_pal[mid] = i

#         if even_pal[mid] >= end-mid: print(1)
#         else: print(0)
        
#     else:
#         temp = odd_pal[mid] 
#         for i in range(temp+1, mid-start):
#             if nums[mid-i] == nums[mid+i]:
#                 odd_pal[mid] = i
            
#         if odd_pal[mid] >= end-mid: print(1)
#         else: print(0)

# print(odd_pal)
# print(even_pal)

# 2
import sys
input = sys.stdin.readline
sys.setrecursionlimit(1005)

# 팰린드롬 여부 확인 및 기록
def get_pal(start, end):
    if pal[start][end] != None:
        return pal[start][end]
    
    if get_pal(start+1, end-1) == True and nums[start] == nums[end]:
        pal[start][end] = True
        return True
    else:
        pal[start][end] = False
        return False

input()
nums = list(map(int, input().split()))
len_ = len(nums)
# start(i)~end(j) 팰린드롬 여부
pal = [[None for j in range(len_)] for i in range(len_)]

# n~n, n~n+1이 팰린드롬인지 확인
for i in range(len_-1):
    pal[i][i] = True
    if (nums[i] == nums[i+1]): pal[i][i+1] = True
    else: pal[i][i+1] = False
pal[len_-1][len_-1] = True

for _ in range(int(input())):
    start, end = map(int, input().split())
    start -= 1 # 인덱스는 0부터 시작하므로
    end -= 1

    print(1) if get_pal(start, end) else print(0)