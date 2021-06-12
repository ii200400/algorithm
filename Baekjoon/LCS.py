# 문제 링크 : https://www.acmicpc.net/problem/9251
# 제출 공유 링크 : 
# 도움받은 블로그 링크 : https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence

import sys
input = lambda : sys.stdin.readline().rstrip()

str1 = list(input())
str2 = list(input())
len_1, len_2 = len(str1), len(str2)

lcs = [[0]*(len_2+1) for i in range(len_1+1)]
for i in range(1, len_1+1):
    for j in range(1, len_2+1):
        if str1[i-1] == str2[j-1]: 
            lcs[i][j] = lcs[i-1][j-1]+1
        else:
            lcs[i][j] = max(lcs[i][j-1], lcs[i-1][j])

# print(lcs)
print(lcs[len_1][len_2])