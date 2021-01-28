# 문제 예시 입출력
words = ["frodo", "front", "frost", "frozen", "frame", "kakao"]
queries = ["fro??", "????o", "fr???", "fro???", "pro?"]
# [3, 2, 4, 1, 0]

# 첫번째 시도 (정규표현식)
import re

def solution(words, queries):
    answer = [0 for i in range(len(queries))]
    for i in range(len(queries)):
        p = re.compile(queries[i].replace("?",".")+"$")
        
        count = 0
        for word in words:
            m = p.match(word)
            if (m != None): count += 1
        answer[i] = count
        
    print (answer)
    return answer

solution(words, queries)

# =============================================================================
# 채점 결과
# 정확성: 25.0
# 효율성: 30.0
# 합계: 55.0 / 100.0
# =============================================================================

# 두번째 시도 (Trie)
import sys
sys.setrecursionlimit(20003)

class root_edge:
    def __init__(self):
        self.node = {}
    
    def put(self, word):
        length = len(word)
        if not self.node.get(length, False): self.node[length] = edge()
        self.node[length].put(word)
        
    def search(self, word):
        length = len(word)
        return (0 if not self.node.get(length, False) else self.node[length].search(word))
        
class edge:
    def __init__(self):
        self.node = {}
        self.count = 0
        
    def put(self, word):
        self.count += 1
        
        if (len(word) == 0): return
        else:
            spell = word[0]
            if not self.node.get(spell, False): self.node[spell] = edge()
            self.node[spell].put(word[1:])
            
    def search(self, word):
        spell = word[0]
        if (spell == "?"): return self.count
        elif self.node.get(spell, False): return self.node[spell].search(word[1:])
        else: return 0
    
def solution(words, queries):
    #answer_dic = {}
    answer = [0 for i in range(len(queries))]
    root = root_edge()
    rev_root = root_edge()
    
    for word in words:
        root.put(word)
        rev_root.put(word[::-1])
        
    for i in range(len(queries)):
        #if answer_dic.get(queries[i], False):
            #answer[i] = answer_dic[queries[i]]
        #else:
        if queries[i][0] != "?": answer[i] = root.search(queries[i])
            #answer_dic[queries[i]] = answer[i]
        else: answer[i] = rev_root.search(queries[i][::-1])
            #answer_dic[queries[i]] = answer[i]
            
    return answer
    
solution(words, queries)

# =============================================================================
# 채점 결과
# 정확성: 25.0
# 효율성: 45.0
# 합계: 70.0 / 100.0
# =============================================================================
