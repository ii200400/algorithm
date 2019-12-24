import copy

def check():
    global li
    temp=copy.copy(li)
    temp.sort()
    al=''
    for i in temp:
        if i==al:
            return False
        al=i
    return True

def play(lo_r,lo_c,dir):
    if not check():
        return

    global far,li,board
    if far<len(li):
        far=len(li)
    if far==26:
        return
    
    if lo_r>1 and dir!=2:
        li.append(board[lo_r-1][lo_c])
        play(lo_r-1,lo_c,1)
        li.pop()
    if lo_r<len(board)-2 and dir!=1:
        li.append(board[lo_r+1][lo_c])
        play(lo_r+1,lo_c,2)
        li.pop()
    if lo_c>1 and dir!=4 :
        li.append(board[lo_r][lo_c-1])
        play(lo_r,lo_c-1,3)
        li.pop()
    if lo_c<len(board[0])-2 and dir!=3:
        li.append(board[lo_r][lo_c+1])
        play(lo_r,lo_c+1,4)
        li.pop()

row,col=[int(i) for i in input().split(" ")]
#세로 row칸 가로 col칸
board=["0"*(col+2),"0"*(col+2)]
i=1
while i!=row+1:
    add="0"+input()+"0"
    board.insert(i,add)
    i+=1

far=1
li=[board[1][1]]
play(1,1,0)#1남 2북 3서 4동
print(far)
