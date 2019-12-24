##어렸을 때 배웠던 수학문제이다. 방법만 알면 level3치고 상당히 쉬운편이다.
##해당 칸의 왼쪽과 위의 수를 더하고 그 수를 넣으며 진행하면 된다.
##물론 웅덩이는 0으로 고정시키고 계산을 해야한다.
##원래는 학생이 아래나 오른쪽으로만 갈 수 있다는 조건이 있어야하는데 없어진 듯 하다.

def solution(m, n, puddles):
    l = [[1 if i==0 and j==0 else -1 for j in range(m)] for i in range(n)]
    for j,i in puddles: l[i-1][j-1] = 0
    print(l)
    for i in range(n):
        for j in range(m):
            if (i == 0 and j == 0) or l[i][j] == 0: continue
            elif i == 0: l[i][j] = l[i][j-1]
            elif j == 0: l[i][j] = l[i-1][j]
            else: l[i][j] = l[i-1][j]+l[i][j-1]
    #print(l)

    return l[n-1][m-1]%1000000007
    #1000000007로 나누는 것을 깜빡해서 계속 틀렸다고 한다..

##정확성: 50.0
##효율성: 50.0
##합계: 100.0 / 100.0
