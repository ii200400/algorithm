def solution(new_id):
    dot = False
    answer = ''
    
    for char in new_id:
        ascy = ord(char)
        # 대문자
        if 65<=ascy<=90: 
            dot = False
            answer+= chr(ascy+32)
        # 점
        elif char == '.': 
            if not dot: 
                dot = True
                answer += char
        # - _ 소문자 숫자
        elif char in ('-', '_') or 48<=ord(char)<=57 or 97<=ord(char)<=122: 
            dot = False
            answer += char
    
    # 양 옆 . 제거
    index = len(answer)
    for seq in range(len(answer)):
        if answer[seq] != '.': 
            index = seq
            break 
    answer = answer[index:]

    l = len(answer)
    for re_seq in range(len(answer)):
        if answer[l-1-re_seq] != '.': 
            answer = answer[:l-re_seq]
            break
    # 5,6 단계
    if answer == "": answer = "a"
    elif len(answer) >= 16: answer = answer[:15]
        
    l = len(answer)
    for re_seq in range(len(answer)):
        if answer[l-1-re_seq] != '.': 
            answer = answer[:l-re_seq]
            break
    # 7단계
    if len(answer) <= 2:
        answer += answer[len(answer)-1]*(3-len(answer))
    
    return answer