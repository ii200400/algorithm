# 문제 링크 : https://www.acmicpc.net/problem/16947
# 제출 공유 링크 : 

import sys
input = sys.stdin.readline
sys.setrecursionlimit(4000)

class node:
    def __init__(self):
        self.is_visited = False
        self.is_cycle = False
        self.link = []
        self.dis = 0

    def search(self, pre_node):
        if self.is_cycle: return 0
        if self.dis: return self.dis # 이미 거리가 설정 되어있다면 그것을 반환

        for n in self.link:
            if node_list[n] == pre_node: continue
            self.dis = node_list[n].search(self)+1
            return self.dis

    def cycle(self, pre_node):
        if self.is_visited: return self # 사이클을 찾은 경우
        self.is_visited = True

        for n in self.link:
            # 방금 지나온 노드는 생략
            if node_list[n] == pre_node: continue

            temp = node_list[n].cycle(self)
            if temp == None: continue

            self.is_cycle = True
            if temp == self: return None
            else: return temp

        return None # 사이클이 아닌 경우
            
cnt = int(input())
node_list = [node() for _ in range(cnt+1)] # 첫번째 자리는 실질적으로 사용하지 않는다.
for _ in range(cnt):
    n1, n2 = map(int, input().split())
    # 노드 양방향 연결
    node_list[n1].link.append(n2)
    node_list[n2].link.append(n1)

answer = ""
node_list[1].cycle(node_list[0])
for i in range(1, cnt+1):
    answer += str(node_list[i].search(node_list[0])) + " "
print(answer)