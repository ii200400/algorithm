##어렵다..
##중심 알고리즘은 연속된 A가 가장 많은 범위를 찾고
##그 범위 양 옆의 알파벳(당연히 A는 아닌 알파벳) 중에서
##현 위치에서 최단(이것 때문에 탐욕법인가..)으로 갈 수 있는 알파벳을 선택하고
##이동해서 알파벳을 바꾼다. 이후 다시 처음부터 진행하여 알파벳이 모두 A가 될 때까지 한다.

def solution(name):
    answer = 0
    alpha = [i for i in range(13)] + [i for i in range(13,0,-1)]
    for st in name: answer += alpha[ord(st)-65]
    print(answer)
    
    li = []
    l = len(name)
    name = 'A' + name[1:]
    
    while True:
        li.clear()
        for i in range(l):
            st = name[i]
            if st != 'A':
                move = 0
                if i <= l//2: move = i
                else: move = l-i

                As = 0
                for search in [1,-1]:
                    for j in range(1,l):
                        if name[(i-j*search)%l] != 'A': 
                            if As < j : As = j-1
                            break

                li.append([As,move,i])
                #[인접한 A가 연속한 갯수(오른쪽, 왼쪽 중 더 큰 값), 최단 거리, 리스트 위치]

        if len(li) == 0: break
        pick = sorted(li,key=lambda x: (x[0],-x[1]),reverse = True)[0]
        answer += pick[1]
        
        print(pick[1], name)
        loc = pick[2]
        if loc <= l//2: name = 'A' + name[loc+1:] + 'A' * (loc)
        else: name = 'A' * (l-loc) + name[:loc]
            
    return answer
