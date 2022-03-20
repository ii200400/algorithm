package com.ssafy.swea.java13475;

import java.util.HashMap;

class UserSolution {
    // [가로 위치][세로 위치][pid, 병원 방문 가능 여부(가능:1, 불가능:0)]
    private int[][][] map = new int[10000][10000][2];
    // key: pid, value: 위치
    private HashMap<Integer, int[]> place = new HashMap<>();
    // key: uid, value: 방문 pid들
    private HashMap<Integer, int[]> visited = new HashMap<>();

    private int[] dr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    private int[] dc = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    void init() {

    }

    void addPlace(int pID, int r, int c) {
        System.out.println("add " + pID);
        place.put(pID, new int[]{r, c});
        map[r][c] = new int[] {pID, 1};
    }

    void removePlace(int pID) {
        System.out.println("remove " + pID);
        int[] pos = place.get(pID);
        map[pos[0]][pos[1]][0] = 0;
        place.remove(pID);
    }

    void contactTracing(int uID, int visitNum, int moveInfo[], int visitList[]) {
        visitList[0] = moveInfo[0];

        int[] pos = place.get(moveInfo[0]);
        for (int i = 1; i<visitNum; i++){
            int direction = moveInfo[i];

            while(true){
                pos[0] += dr[direction];
                pos[1] += dc[direction];

                // 방문 가능하다면
                if (map[pos[0]][pos[1]][0] != 0 && map[pos[0]][pos[1]][1] == 1){
                    visitList[i] = map[pos[0]][pos[1]][0];
                    break;
                }
            }
        }

        for (int i = 0; i<visitNum; i++){
            pos = place.get(visitList[i]);
            map[pos[0]][pos[1]][1] = 0;
        }
        visited.put(uID, visitList.clone());
    }

    void disinfectPlaces(int uID) {
        for (int pid: visited.get(uID)){
            int[] pos = place.get(pid);
            if (pos != null) {
                map[pos[0]][pos[1]][1] = 1;
            }
        }
        visited.remove(uID);
    }
}
