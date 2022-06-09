##좀 복잡해 보이기는 하지만 다음과 같이 하였다.
##[[7], [3, 8], [8, 1, 0]] 이 주어졌다면.
##top=[7]로 우선 초기화하고 이중for문으로
##[10,15]를 만들고 top에 넣는다.
##[18,max(11,16),15] 즉,[18,16,15]를 만들고 top에 넣고.. 를 반복하고
##return에서 가장 큰 값만을 반환한다.

def solution(triangle):
    top = triangle[0]
    for depth in range(1,len(triangle)):
        bottom = [0 for _ in range(depth+1)]
        for i in range(depth+1):
            if i == 0: bottom[0] = top[0]+triangle[depth][0]
            elif i == depth: bottom[depth] = top[depth-1]+triangle[depth][depth]
            else:
                bottom[i] = max(top[i-1]+triangle[depth][i],top[i]+triangle[depth][i])
        #print(bottom)
        top = bottom
        
    return max(top)

##정확성: 64.3
##효율성: 35.7
##합계: 100.0 / 100.0
