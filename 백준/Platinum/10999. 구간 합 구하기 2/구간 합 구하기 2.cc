#include <iostream>
#include <vector>

typedef long long ll;

using namespace std;

vector<ll> arr;
vector<ll> tree;
vector<ll> lazy;

ll init(int node, int start, int end) {
	if (start == end) return tree[node] = arr[start];
	int mid = (start + end) / 2;
	return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
}

void propagate(int node, int start, int end) {
	if (lazy[node] == 0) return;
	tree[node] += (ll)(end - start + 1) * lazy[node];
	if (start != end) {
		lazy[node * 2] += lazy[node];
		lazy[node * 2 + 1] += lazy[node];
	}
	lazy[node] = 0;
}

void update(int node, int start, int end, int left, int right, ll diff) {
	propagate(node, start, end);
	if (left > end || right < start) return;
	if (left <= start && end <= right) {
		lazy[node] += diff;
		propagate(node, start, end);
		return;
	}
	int mid = (start + end) / 2;
	update(node * 2, start, mid, left, right, diff);
	update(node * 2 + 1, mid + 1, end, left, right, diff);
	tree[node] = tree[node * 2] + tree[node * 2 + 1];
}

ll query(int node, int start, int end, int left, int right) {
	propagate(node, start, end);
	if (left > end || right < start) return 0;
	if (left <= start && end <= right) return tree[node];
	int mid = (start + end) / 2;
	return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int N, M, K;
	cin >> N >> M >> K;

	arr.resize(N + 1);
	tree.resize(4 * N + 1);
	lazy.resize(4 * N + 1);

	for (int i = 1; i <= N; i++) cin >> arr[i];
	init(1, 1, N);

	for (int i = 0; i < M + K; i++) {
		int cmd;
		cin >> cmd;

		if (cmd == 1) {
			int l, r;
			ll diff;
			cin >> l >> r >> diff;
			update(1, 1, N, l, r, diff);
		}

		if (cmd == 2) {
			int l, r;
			cin >> l >> r;
			cout << query(1, 1, N, l, r) << "\n";
		}
	}

	return 0;
}