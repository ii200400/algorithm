#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

class Road {
public:
    int goTo;   // ���ϴ� ����
    int time;   // ���θ� �����µ� �ɸ��� �ð�
    int num;    // ���� ��ȣ
    Road(int pGoTo, int pTime, int pNum) {
        goTo = pGoTo;
        time = pTime;
        num = pNum;
    }
};

class Path {
public:
    int city;
    int cost = 0; // Ư�� ���ñ����� �ɸ��� �ð�
    vector<int> roads;  // Ư�� ���ñ��� ������ ����
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
    // ������ ����
    vector<vector<Road>> adj;
    for (int i = 0; i < n + 1; i++) {
        adj.push_back(vector<Road>());
    }

    for (int i = 0; i < m; i++) {
        adj[x[i]].push_back(Road(y[i], z[i], i));
        adj[y[i]].push_back(Road(x[i], z[i], i));
    }

    // ���ΰ� �ִܰ�ο� ���Ե� ȸ��
    vector<int*> roadCnt;
    for (int i = 0; i < m; i++) {
        roadCnt.push_back(new int[2] {0, i + 1});
    }

    // �� ���ú��� �ٸ� ���ñ��� �ִܰ�θ� ã�ƺ���. (���� ��ȣ�� 1���� ����)
    for (int i = 1; i < n + 1; i++) {

        // ���ͽ�Ʈ�� ����� ���� pq�� ��� ������ ���� Path
        priority_queue<Path> pq = priority_queue<Path>();
        pq.push(Path(i, 0, vector<int>()));

        // ���� �湮 ����
        bool* visited = new bool[n + 1];
        for (int j = 0; j < n + 1; j++) {
            visited[j] = false;
        }
        // �ٸ� ���� �湮���� +1�ϴ� ����
        int cnt = 0;

        // ���ͽ�Ʈ�� ����Ѵ�.
        while (true) {
            Path path = pq.top(); pq.pop();

            // �� ���θ� ���ؼ� ���ø� ���캸�µ�
            // �̹� �湮�߾��ٸ� ����
            if (visited[path.city])
                continue;

            // �湮ó���� �Ѵ�.
            visited[path.city] = true;
            cnt++;

            // ���� ���ñ����� ��λ� ���ε��� �湮�� ����Ѵ�.
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

                // �̹� �湮�� ���ÿ� ����Ǿ� �ִ� ���ζ�� ����
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