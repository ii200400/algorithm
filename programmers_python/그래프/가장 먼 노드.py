##1. 시작 노드를 1로 잡고 그 노드의 거리를 0으로 한 상태로 시작
##2. 해당 노드는 주변의 거리가 측정되지 않은(한번도 방문한 적이 없는) 노드들에게 거리 저장 및 리스트(큐)에 저장
##3. 리스트에서 다음 노드를 가져온다.
##(만약 리스트에서 0을 가져왔다면 깊이를 증가시키고 다시 0을 넣는다.)
##4. 2~3을 반복한다.

def solution(n, edge):
    edges = [[] for _ in range(n+1)] #노드의 번호가 1부터 이므로 +1 추가, 해당 숫자의 노드와 연결이 된 노드 리스트
    shortest = [-1 for _ in range(n+1)] #해당 숫자의 노드까지의 최단거리 저장
    shortest[1] = 0
    for i in edge:
        edges[i[0]].append(i[1])
        edges[i[1]].append(i[0])

    depth = 0
    fifo = [1,0] #노드 방문 순서를 리스트에 저장, 숫자 0 으로 깊이가 얼마나 되는지 구별
    while(True):
        p = fifo.pop(0)
        if p == 0: 
            if len(fifo) == 0: break
            else:
                depth += 1
                fifo.append(0)
                continue
        
        for j in edges[p]:
            if shortest[j] == -1: 
                fifo.append(j)
                shortest[j] = depth+1

    return shortest.count(depth)
