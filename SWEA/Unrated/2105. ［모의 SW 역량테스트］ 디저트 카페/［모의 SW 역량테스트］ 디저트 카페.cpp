#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int map[20][20];
bool visited[20][20];
bool desert[101];

int dy[] = {-1, 1, 1, -1};
int dx[] = {1, 1, -1, -1};

int n;
pair<int, int> start_node;
int result = -1;

void input() {
	memset(map, 0, sizeof(map));
	memset(visited, 0, sizeof(visited));
	memset(desert, 0, sizeof(desert));
	result = -1;
	
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
		}
	}
}

bool validate(int y, int x) {
	return y > -1 && y < n && x > -1 && x < n && !visited[y][x] && !desert[map[y][x]];
}

void dfs(int dir, int y, int x, int cnt) {
	if (dir > 3) return;
	for (int i = 0; i < 2; i++) {
		int ndir = dir + i;
		if (ndir > 3) break;

		int ny = y + dy[ndir];
		int nx = x + dx[ndir];

		if (ny == start_node.first && nx == start_node.second && cnt > 2) {
			result = max(result, cnt + 1);
		}

		if (validate(ny, nx)) {
			visited[ny][nx] = 1;
			desert[map[ny][nx]] = 1;
			dfs(ndir, ny, nx, cnt + 1);
			visited[ny][nx] = 0;
			desert[map[ny][nx]] = 0;
		}
	}
}

void solve(int t) {
	input();
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			start_node = { i, j };
			visited[i][j] = 1;
			desert[map[i][j]] = 1;
			dfs(0, i, j, 0);
			desert[map[i][j]] = 0;
			visited[i][j] = 0;
		}
	}
	cout << "#" << t << " " << result << "\n";
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		solve(i + 1);
	}

	return 0;
}