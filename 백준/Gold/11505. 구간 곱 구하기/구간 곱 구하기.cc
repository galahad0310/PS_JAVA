#include <iostream>
#include <vector>

using namespace std;

#define MOD 1000000007

int N, M, K;
vector<long long> arr;
vector<long long> tree;

void input() {
	cin >> N >> M >> K;
	arr.assign(N, 0);
	tree.assign(N * 4, 0);
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
}

long long init(vector<long long>& arr, vector<long long>& tree, int node, int start, int end) {
	if (start == end) return tree[node] = arr[start];
	int mid = (start + end) / 2;
	return tree[node] = (init(arr, tree, node * 2, start, mid) * init(arr, tree, node * 2 + 1, mid + 1, end)) % MOD;
}

long long query(vector<long long>& tree, int node, int start, int end, int left, int right) {
	if (left > end || right < start) return 1;
	if (left <= start && end <= right) return tree[node];
	int mid = (start + end) / 2;
	return (query(tree, node * 2, start, mid, left, right) * query(tree, node * 2 + 1, mid + 1, end, left, right)) % MOD;
}

void update(vector<long long>& tree, int node, int start, int end, int target, int next) {
	if (target < start || target > end) return;
	if (start == end) {
		tree[node] = next;
		return;
	}
	int mid = (start + end) / 2;
	update(tree, node * 2, start, mid, target, next);
	update(tree, node * 2 + 1, mid + 1, end, target, next);
	tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD;
}

void solve() {
	input();
	init(arr, tree, 1, 0, arr.size() - 1);
	for (int i = 0; i < M + K; i++) {
		long long a, b, c;
		cin >> a >> b >> c;
		if (a == 1) {
			arr[b - 1] = c;
			update(tree, 1, 0, arr.size() - 1, b - 1, c);
		}
		else if (a == 2) {
			cout << query(tree, 1, 0, arr.size() - 1, b - 1, c - 1) << "\n";
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);
	solve();
	return 0;
}

