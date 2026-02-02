#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>

using namespace std;

#define MAX_N 10

int n, m, c;
int map[MAX_N][MAX_N];
int mem[MAX_N][MAX_N];


void dfs(int row, int col, int depth, int sum, int profit, int& max_local) {
	if (sum > c) return;
	max_local = max(max_local, profit);

	if (depth == m) return;

	dfs(row, col, depth + 1, sum, profit, max_local);
	int val = map[row][col + depth];
	dfs(row, col, depth + 1, sum + val, profit + (val * val), max_local);
}

void input() {
	cin >> n >> m >> c;
	memset(map, 0, sizeof(map));
	memset(mem, 0, sizeof(mem));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j <= n - m; j++) {
			int max_local = 0;
			dfs(i, j, 0, 0, 0, max_local);
			mem[i][j] = max_local;
		}
	}
}

int search() {
	int result = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <= n - m; j++) {
			for (int r = i; r < n; r++) {
				int start_c = r == i ? j + m : 0;
				for (int c = start_c; c <= n - m; c++) {
					result = max(result, mem[i][j] + mem[r][c]);
				}
			}
		}
	}
	return result;
}

void solve(int t) {
	input();
	int result = search();
	cout << "#" << t << " " << result << "\n";
}

int main() {
	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		solve(i + 1);
	}
	return 0;
}