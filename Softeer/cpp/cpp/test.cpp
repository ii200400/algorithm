#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

class Road {
public:
    int goTo;   // 향하는 도시
    int time;   // 도로를 지나는데 걸리는 시간
    int num;    // 도로 번호
    Road(int pGoTo, int pTime, int pNum) {
        goTo = pGoTo;
        time = pTime;
        num = pNum;
    }
};

class Path {
public:
    int city;
    int cost = 0; // 특정 도시까지의 걸리는 시간
    vector<int> roads;  // 특정 도시까지 지나는 도로
    Path(int pCity, int pCost, vector<int> pRoads) {
        city = pCity;
        cost = pCost;
        roads = pRoads;
    }

    bool operator<(const Path p) const {
        if (this->cost > p.cost) {
            return true;
        }
        else if (this->cost == p.cost) {
            for (int i = 0; ; i++) {
                if (this->roads[i] == p.roads[i]) {
                    continue;
                }
                else {
                    return this->roads[i] > p.roads[i];
                }
            }
        }
        return false;
    }
};

bool compare(int* a, int* b) {
    if (a[0] > b[0]) {
        return true;
    }
    else if (a[0] == b[0]) {
        return a[1] < b[1];
    }
    return false;
}

vector<int> solution(int n, int m, vector<int> x, vector<int> y, vector<int> z) {
    // 인접한 도로
    vector<vector<Road>> adj;
    for (int i = 0; i < n + 1; i++) {
        adj.push_back(vector<Road>());
    }

    for (int i = 0; i < m; i++) {
        adj[x[i]].push_back(Road(y[i], z[i], i));
        adj[y[i]].push_back(Road(x[i], z[i], i));
    }

    // 도로가 최단경로에 포함된 회수
    vector<int*> roadCnt;
    for (int i = 0; i < m; i++) {
        roadCnt.push_back(new int[2] {0, i + 1});
    }

    // 한 도시부터 다른 도시까지 최단경로를 찾아본다. (도시 번호는 1부터 시작)
    for (int i = 1; i < n + 1; i++) {

        // 다익스트라 사용을 위한 pq와 경로 저장을 위한 Path
        priority_queue<Path> pq = priority_queue<Path>();
        pq.push(Path(i, 0, vector<int>()));

        // 도시 방문 여부
        bool* visited = new bool[n + 1];
        for (int j = 0; j < n + 1; j++) {
            visited[j] = false;
        }
        // 다른 도시 방문마다 +1하는 변수
        int cnt = 0;

        // 다익스트라를 사용한다.
        while (true) {
            Path path = pq.top(); pq.pop();

            // 각 도로를 통해서 도시를 살펴보는데
            // 이미 방문했었다면 생략
            if (visited[path.city])
                continue;

            // 방문처리를 한다.
            visited[path.city] = true;
            cnt++;

            // 현재 도시까지의 경로상 도로들의 방문을 기록한다.
            //cout << i << " -> " << path.city << " ";
            for (int k = 0; k < (int)path.roads.size(); k++) {
                roadCnt[path.roads[k]][0]++;
                //cout << path.roads[k] << " ";
            }
            //cout << endl;

            if (cnt == n)
                break;

            int size = adj[path.city].size();
            for (int j = 0; j < size; j++) {
                Road r = adj[path.city][j];

                // 이미 방문한 도시와 연결되어 있는 도로라면 생략
                if (visited[r.goTo])
                    continue;

                vector<int> v;
                for (int k = 0; k < (int)path.roads.size(); k++) {
                    v.push_back(path.roads[k]);
                }
                v.push_back(r.num);

                pq.push(Path(r.goTo, path.cost + r.time, v));
            }
        }

        delete[] visited;
    }

    sort(roadCnt.begin(), roadCnt.end(), compare);

    vector<int> answer;
    for (int i = 0; i < m; i++) {
        // cout << roadCnt[i][1] << " " << roadCnt[i][0] << endl;
        answer.push_back(roadCnt[i][1]);
    }

    return answer;
}

void main() {
    vector<int> ans = solution(3, 3, vector<int> {1, 1, 2}, vector<int> {3, 2, 3}, vector<int> {1, 5, 2});
    cout << ans[0] << endl;
}