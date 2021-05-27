# 문제 링크 : https://www.acmicpc.net/problem/14891
# 제출 공유 링크 : http://boj.kr/55c96ca9677442bfa44344caf633b0ab

gear_l = [list(map(int, list(input()))) for _ in range(4)]
# print(gear_l)
gear_12 = [0 for _ in range(4)]
for _ in range(int(input())):
    selected_gear, rot = map(int, input().split())
    selected_gear -= 1 # 인덱스 순서에 맞추기 위해
    rot *= -1 # 시계방향으로 돌면 -1, 반시계는 1을 더하기 위함

    gear_rot = [0 for _ in range(4)]
    gear_rot[selected_gear] = rot
    
    
    # 선택된 기어의 오른쪽에 있는 기어를 움직임
    temp_rot = rot
    for index in range(selected_gear, 3):
        if (gear_l[index][(gear_12[index]+2)%8] != gear_l[index+1][(gear_12[index+1]-2)%8]):
            temp_rot *= -1
            gear_rot[index+1] = temp_rot
        else: break

    # 선택된 기어의 왼쪽에 있는 기어를 움직임
    temp_rot = rot
    for index in range(selected_gear, 0, -1):
        if (gear_l[index-1][(gear_12[index-1]+2)%8] != gear_l[index][(gear_12[index]-2)%8]):
            temp_rot *= -1
            gear_rot[index-1] = temp_rot
        else: break

    for i in range(4):
        gear_12[i] = (gear_12[i]+gear_rot[i])%8
    # print(gear_12)

ans = 0
for i in range(4):
    ans += gear_l[i][gear_12[i]] * 2**i
print(ans)