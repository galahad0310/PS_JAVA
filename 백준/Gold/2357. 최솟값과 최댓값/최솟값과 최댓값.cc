#include <iostream>
#include <vector>
#include <algorithm> 
#include <climits>

using namespace std;

// pair의 첫 번째: 최솟값 (min)
// pair의 두 번째: 최댓값 (max)
typedef pair<long long, long long> Node;

// 초기화 함수 (바닥부터 위로 min/max 채우기)
Node init(vector<long long>& arr, vector<Node>& tree, int node, int start, int end) {
    if (start == end) {
        // 리프 노드: 자기 자신이 최소이자 최대
        return tree[node] = { arr[start], arr[start] };
    }

    int mid = (start + end) / 2;
    Node left_val = init(arr, tree, node * 2, start, mid);
    Node right_val = init(arr, tree, node * 2 + 1, mid + 1, end);

    // 부모는 두 자식 중 더 작은 값과, 더 큰 값을 가짐
    return tree[node] = {
        min(left_val.first, right_val.first),
        max(left_val.second, right_val.second)
    };
}

// 구간 조회 함수 (Query)
Node query(vector<Node>& tree, int node, int start, int end, int left, int right) {
    // 1. 범위 밖인 경우 (영향을 주지 않는 값 리턴)
    if (left > end || right < start) {
        return { LLONG_MAX, 0 }; // min은 제일 큰 값으로, max는 제일 작은 값으로
    }

    // 2. 범위 안에 완전히 들어온 경우
    if (left <= start && end <= right) {
        return tree[node];
    }

    // 3. 걸쳐 있는 경우
    int mid = (start + end) / 2;
    Node left_val = query(tree, node * 2, start, mid, left, right);
    Node right_val = query(tree, node * 2 + 1, mid + 1, end, left, right);

    return {
        min(left_val.first, right_val.first),
        max(left_val.second, right_val.second)
    };
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    vector<long long> arr(N);
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    vector<Node> tree(N * 4);

    // 트리 초기화
    init(arr, tree, 1, 0, N - 1);

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;

        // 문제 범위가 1-based이므로 0-based로 변환
        Node result = query(tree, 1, 0, N - 1, a - 1, b - 1);
        cout << result.first << " " << result.second << "\n";
    }

    return 0;
}