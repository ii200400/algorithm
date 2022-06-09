##파이썬 재귀 limit가 1000인데 이것을 늘려주어야 한다고 한다;;
##처음으로 클래스 쓰고 푼 것 같다.

import sys
sys.setrecursionlimit(10**6)

def solution(nodeinfo):
    class node:
        def __init__(self,x,num):
            self.x = x
            self.num = num
            
            self.left = None
            self.right = None
            
    def front(node):
        f_list.append(node.num)
        if node.left != None: front(node.left)
        if node.right != None:front(node.right)
        
    def back(node):
        if node.left != None: back(node.left)
        if node.right != None: back(node.right)
        b_list.append(node.num)
    
    nodeinfo = [[loc[0],loc[1],i+1] for i,loc in enumerate(nodeinfo)]
    nodeinfo.sort(key=lambda x: (x[1], -x[0]),reverse = True)
    
    p = nodeinfo.pop(0)
    s_node = node(p[0],p[2])

    for i in nodeinfo:
        c_node = s_node
        while True:
            if i[0] < c_node.x:
                if c_node.left == None: 
                    c_node.left = node(i[0],i[2])
                    break
                else: c_node = c_node.left
                    
            else: #c_node.num < i[0]
                if c_node.right == None: 
                    c_node.right = node(i[0],i[2])
                    break
                else: c_node = c_node.right
                    
    f_list = []
    front(s_node)
    b_list = []
    back(s_node)
    
    return [f_list,b_list]

##정확성: 100.0
##합계: 100.0 / 100.0
