# 문제 예시 입출력
# =============================================================================
# abcd
# 3
# P x
# L
# P y
# =============================================================================

class node:
    def __init__(self, head, tail, char):
        self.head = head
        self.tail = tail
        self.char = char
  
string = input()
head = node(None, None, None)
curser = head
for char in string:
    curser.tail = node(curser, None, char)
    curser = curser.tail

for i in range(int(input())):
#     temp = head
#     string = ''
#     while temp.tail != None:
#         temp = temp.tail
#         string += temp.char
#     print(string)
    
    string = input()
    if string[0] == 'L' and curser.head != None: curser = curser.head
    elif string[0] == 'D' and curser.tail != None: curser = curser.tail
    elif string[0] == 'B': 
        if curser.char == None: continue
        curser.head.tail = curser.tail
        curser = curser.head
        if curser.tail == None: continue
        curser.tail.head = curser
    elif string[0] == 'P':
        if curser.tail == None:
            curser.tail = node(curser, None, string[2])
            curser = curser.tail
        else:
            curser = node(curser, curser.tail, string[2])
            curser.head.tail = curser
            curser.tail.head = curser
       
temp = head
string = ''
while temp.tail != None:
    temp = temp.tail
    string += temp.char
print(string)