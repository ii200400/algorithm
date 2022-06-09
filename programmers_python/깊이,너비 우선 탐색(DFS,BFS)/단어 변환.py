##이전에 했던 A에서B까지 가는데 몇개의 간선을 거쳐야 하는지 묻는 문제와
##거의 똑같이 했다.
##물론 bfs로 했다.
##다른 사람들 중 나의 compare함수대신 zip과 sum을 이용한 사람도 있다. 좋은 풀이!
##if sum([x!=y for x, y in zip(word_1, word_2)]) == 1:

def solution(begin, target, words):
    answer = 1
    steps = [0 for _ in range(len(words))] #해당 단어까지 최단 단계
    que = [begin,0]
    length = len(words)
    
    def compare(s1,s2):
        diff = False
        for i in range(len(s1)):
            if s1[i] != s2[i]:
                if diff: return False #서로 바꿀 수 있는 단어가 아님
                else: diff = True
                    
        return diff
    
    while len(que) > 1:
        #print(que, steps)
        p = que.pop(0)
        if p == 0: 
            answer += 1
            que.append(0)
            continue
        
        for i in range(length):
            if not steps[i] and compare(p,words[i]): 
                if words[i] == target: return answer
                steps[i] = answer
                que.append(words[i])
    
    return 0

##정확성: 100.0
##합계: 100.0 / 100.0
