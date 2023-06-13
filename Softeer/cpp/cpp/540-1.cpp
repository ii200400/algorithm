#include<iostream>
#include<vector>
#include<stack>
#include<queue>
#include<algorithm>
#include<string>
#include <cstring>
using namespace std;

int n;
int map[45][15];
int result = 0;

int dy[] = { 0,0,-1,1 };
int dx[] = { 1,-1,0,0 };

void dfs(int cnt, int score) {

	if (cnt == 3) {

		result = max(result, score);
		//cout << "Done!!!!!!!!!!" << endl;
		return;
	}

	bool visited[15][15] = { false, };
	int dup[45][15] = { 0 };

	memcpy(dup, map, sizeof(map));

	for (int i = 2 * n; i < 3 * n; i++) {
		for (int j = 0; j < n; j++) {

			int num = 1;
			int minx = j;
			int maxx = j;
			int miny = i;
			int maxy = i;
			int value = map[i][j];

			if (value != 0 && visited[i - 2 * n][j] == false) {

				visited[i - 2 * n][j] = true;
				map[i][j] = 0;
				queue<pair<int, int>>q;
				q.push({ i,j });

				while (!q.empty()) {

					int y = q.front().first;
					int x = q.front().second;
					q.pop();

					for (int dir = 0; dir < 4; dir++) {

						int ny = y + dy[dir];
						int nx = x + dx[dir];

						if (ny < 2 * n || nx < 0 || ny >= 3 * n || nx >= n || (map[ny][nx] != value)) continue;
						if (visited[ny - 2 * n][nx] == false) {

							visited[ny - 2 * n][nx] = true;
							map[ny][nx] = 0;
							num += 1;
							minx = min(minx, nx);
							maxx = max(maxx, nx);
							miny = min(miny, ny);
							maxy = max(maxy, ny);
							q.push({ ny,nx });

						}
					}
				}

				int len = (maxx + 1 - minx) * (maxy + 1 - miny);
				int add = (num + len);
				//line¹Ð±â
				if (cnt < 2) {

					for (int x = 0; x < n; x++) {
						queue<int>q;
						for (int y = 3 * n - 1; y >= 0; y--) {

							if (map[y][x] != 0) {
								q.push({ map[y][x] });
							}
						}
						int ny = 3 * n - 1;
						while (!q.empty()) {

							int temp = q.front();
							q.pop();
							map[ny][x] = temp;
							ny -= 1;

						}
						for (int y = ny; ny >= 0; ny--) {
							map[ny][x] = 0;
						}
					}
				}

				cout << "cnt: " << cnt << ", add: " << add << endl;
				for (int k = 0; k < 3 * n; k++) {
					for (int l = 0; l < n; l++) {
						cout << map[k][l] << ' ';
					}
					cout << endl;
				}

				dfs(cnt + 1, score + add);
				memcpy(map, dup, sizeof(map));

			}
		}
	}
}


int main() {

	cin >> n;
	for (int i = 0; i < 3 * n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
		}
	}

	dfs(0, 0);

	cout << result << endl;
}