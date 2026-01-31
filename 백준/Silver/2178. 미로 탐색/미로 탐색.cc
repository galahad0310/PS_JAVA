#include <iostream>
#include <queue>

using namespace std;

int n, m;
int dy[] = { -1, 1, 0, 0 };
int dx[] = { 0, 0, -1, 1 };
int map[100][100];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		string row;
		cin >> row;
		for (int j = 0; j < m; j++) {
			map[i][j] = row[j] - '0';
		}
	}
	
	queue<pair<int, int>> q;
	
	q.push({ 0, 0 });
	
	while (!q.empty()) {
		pair<int, int> curr = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = curr.first + dy[i];
			int nx = curr.second + dx[i];

			if (ny > -1 && ny < n && nx > -1 && nx < m) {
				if (map[ny][nx] == 1) {
					map[ny][nx] = map[curr.first][curr.second] + 1;
					q.push({ ny, nx });
				}
			}
		}
	}

	cout << map[n - 1][m - 1];
	
}