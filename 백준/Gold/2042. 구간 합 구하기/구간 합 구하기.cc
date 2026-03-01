#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// arr: 입력 배열
// tree: 세그먼트 트리 배열
// node: 현재 노드 번호
// start, end: 현재 노드가 담당하는 구간의 시작과 끝 인덱스
long long init(vector<long long>& arr, vector<long long>& tree, int node, int start, int end) {
    if (start == end) {
        return tree[node] = arr[start];
    }
    int mid = (start + end) / 2;
    return tree[node] = init(arr, tree, node * 2, start, mid) + init(arr, tree, node * 2 + 1, mid + 1, end);
}

// index: 변경할 숫자의 인덱스
// diff: 변경된 값과 기존 값의 차이
void update(vector<long long>& tree, int node, int start, int end, int index, long long diff) {
    if (index < start || index > end) return; // 범위 밖이면 무시

    tree[node] += diff; // 차이만큼 현재 노드 갱신

    if (start != end) { // 리프 노드가 아니면 자식들도 갱신
        int mid = (start + end) / 2;
        update(tree, node * 2, start, mid, index, diff);
        update(tree, node * 2 + 1, mid + 1, end, index, diff);
    }
}

// left, right: 합을 구하고자 하는 구간
long long sum(vector<long long>& tree, int node, int start, int end, int left, int right) {
    if (left > end || right < start) return 0; // 겹치는 구간이 없으면 0 반환
    if (left <= start && end <= right) return tree[node]; // 구간이 완전히 포함되면 현재 노드 값 반환

    int mid = (start + end) / 2;
    return sum(tree, node * 2, start, mid, left, right) + sum(tree, node * 2 + 1, mid + 1, end, left, right);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M, K;
    cin >> N >> M >> K;

    vector<long long> arr(N);
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    // 트리의 높이 계산 및 사이즈 할당
    int tree_size = 4 * N;
    vector<long long> tree(tree_size);

    // 트리 초기화
    init(arr, tree, 1, 0, N - 1);

    for (int i = 0; i < M + K; i++) {
        long long a, b, c;
        cin >> a >> b >> c;

        if (a == 1) { // 값 변경 (b번째 수를 c로 변경)
            // 문제에서 인덱스는 1부터 시작하므로 0-based로 맞춤
            int index = (int)b - 1;
            long long diff = c - arr[index];
            arr[index] = c; // 배열 값 갱신
            update(tree, 1, 0, N - 1, index, diff); // 트리 갱신
        }
        else if (a == 2) { // 구간 합 (b번째부터 c번째까지 합)
            cout << sum(tree, 1, 0, N - 1, (int)b - 1, (int)c - 1) << "\n";
        }
    }

    return 0;
}