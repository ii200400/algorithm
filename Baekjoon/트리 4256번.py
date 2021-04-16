# 문제 링크 : https://www.acmicpc.net/problem/1068
# 제출 공유 링크 : http://boj.kr/0b6326b59f6b427c9910a1ffa8a4480c
# 음.. 재귀가 1000이 아니라 거의 2000이 필요한 이유를 잘 모르겠다.

import sys
limit_number = 2000 # 1900은 안되고 1999는 되는 것을 확인
sys.setrecursionlimit(limit_number)

# global
index = 0
preorder = None

class node:
    value = "0"
    left_node = None
    right_node = None

    def __init__(self, p_inorder):
        global index
        self.value = preorder[index] # 노드 숫자
        cut_index = p_inorder.index(self.value) # 전위 순회에서 노드 찾기

        left_inorder = p_inorder[:cut_index]
        right_inorder = p_inorder[cut_index+1:]
        index += 1

        # 나뉜 리스트가 비어있지 않으면 노드 생성
        if left_inorder:  self.left_node = node(left_inorder)
        if right_inorder: self.right_node = node(right_inorder)

    def postorder(self):
        save = ""
        # child node가 None이 아니라면
        if self.left_node: save += self.left_node.postorder()
        if self.right_node: save += self.right_node.postorder()
        return save + self.value + " "

case_number = int(input()) # 테스트 케이스 수
for _ in range(case_number):
    input()
    preorder = list(input().split())
    inorder = list(input().split())
    index = 0

    root_node = node(inorder)
    print(root_node.postorder()[:-1])
