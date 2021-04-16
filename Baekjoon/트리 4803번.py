# 문제 링크 : https://www.acmicpc.net/problem/4803
# 제출 공유 링크 : http://boj.kr/c16cef4305f64f6d828613e2dc6e83da
# 유니온 파인드 참고 : https://hellominchan.tistory.com/259

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

union_list = []
def find_root(num):
    if union_list[num] == num: return num

    union_list[num] = find_root(union_list[num])
    return union_list[num]

def union(n1, n2):
    n1, n2 = find_root(n1), find_root(n2)

    if n1 < n2: union_list[n2] = n1
    elif n1 > n2: union_list[n1] = n2
    else: union_list[n1] = 0

case_cnt = 0
while(True):
    case_cnt += 1
    n, m = map(int, input().split())
    if (n==0 and m==0): break

    # 값을 +1 하기 싫어서 리스트 한 칸을 더 만듦
    # union_list[0]은 대신 트리가 아닌 것들의 루트가 되도록 만듦
    union_list = [i for i in range(n+1)]
    for _ in range(m):
        n1, n2 = map(int, input().split())
        union(n1, n2)

    answer = 0
    for i in range(1,n+1):
        if union_list[i] == i: answer += 1
        
    if answer == 0: print("Case {0}: No trees.".format(case_cnt))
    elif answer == 1: print("Case {0}: There is one tree.".format(case_cnt))
    else: print("Case {0}: A forest of {1} trees.".format(case_cnt, answer))
