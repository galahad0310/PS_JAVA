#include <iostream>
#include <vector>

using namespace std;

int N, M, K;
vector<long long> tree;
vector<long long> arr;

long long init(vector<long long>& arr, vector<long long>& tree, int node, int left, int right) {
	if (left == right) return tree[node] = arr[left];
	int mid = (left + right) / 2;
	return tree[node] = init(arr, tree, node * 2, left, mid) + init(arr, tree, node * 2 + 1, mid + 1, right);
}

long long query(vector<long long>& tree, int node, int left, int right, int start, int end) {
	if (left > end || right < start) return 0;
	if (start <= left && right <= end) return tree[node];
	int mid = (left + right) / 2;
	return query(tree, node * 2, left, mid, start, end) + query(tree, node * 2 + 1, mid + 1, right, start, end);
}

void update(vector<long long>& tree, int node, int left, int right, int target, long long diff) {
	if (left > target || right < target) return; //완전히 벗어난 경우
	tree[node] += diff;  //겹치는 경우
	if (left != right) {
		int mid = (left + right) / 2;
		update(tree, node * 2, left, mid, target, diff);
		update(tree, node * 2 + 1, mid + 1, right, target, diff);
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> N >> M >> K;
	tree.assign(4 * N, 0);
	arr.assign(N, 0);

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	init(arr, tree, 1, 0, arr.size() - 1);

	for (int i = 0; i < M + K; i++) {
		long long a, b, c;
		cin >> a >> b >> c;

		if (a == 1) {
			long long temp = arr[b-1];
			arr[b-1] = c;
			update(tree, 1, 0, arr.size() - 1, b - 1, c - temp);
		}
		else if (a == 2) {
			cout << query(tree, 1, 0, arr.size() - 1, b - 1, c - 1) << "\n";
		}
	}

	return 0;
}