#include <iostream>
#include <vector>
#include <algorithm>
#include <climits> // INT_MAX 사용

using namespace std;

// 좌표를 저장할 구조체
struct Point {
    int r, c;
};

int N;
int map[12][12];
vector<Point> cores; // 가장자리가 아닌, 연결해야 할 코어들
int maxCores;        // 최대 연결 코어 수
int minLen;          // 최소 전선 길이 (최대 연결 코어 수일 때)

// 상, 하, 좌, 우 델타 배열
int dr[] = {-1, 1, 0, 0};
int dc[] = {0, 0, -1, 1};

// 맵 초기화 및 입력 처리에서 가장자리 코어 제외 로직 필요
// (main 함수에서 처리)

/**
 * 전선 설치 가능 여부 확인 및 길이 반환 함수
 * dir: 방향 (0:상, 1:하, 2:좌, 3:우)
 * return: 설치 가능한 전선 길이 (불가능하면 0 반환)
 */
int getWireLength(int r, int c, int dir) {
    int len = 0;
    int nr = r + dr[dir];
    int nc = c + dc[dir];

    while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
        if (map[nr][nc] != 0) { // 1:코어, 2:전선 -> 장애물 만남
            return 0; 
        }
        len++;
        nr += dr[dir];
        nc += dc[dir];
    }
    return len;
}

/**
 * 전선 설치 또는 제거 함수
 * type: 2 (설치), 0 (제거)
 */
void setWire(int r, int c, int dir, int len, int type) {
    int nr = r;
    int nc = c;
    for (int i = 0; i < len; i++) {
        nr += dr[dir];
        nc += dc[dir];
        map[nr][nc] = type;
    }
}

/**
 * DFS 탐색
 * idx: 현재 검토 중인 코어 인덱스
 * cnt: 현재까지 연결된 코어 수
 * len: 현재까지 설치된 전선 길이 합
 */
void dfs(int idx, int cnt, int len) {
    // [가지치기 - Pruning]
    // 남은 코어를 다 연결해도 현재 찾은 최대 코어 수(maxCores)를 못 넘는다면 중단
    if (cnt + (cores.size() - idx) < maxCores) return;

    // [기저 조건 - Base Case]
    if (idx == cores.size()) {
        if (cnt > maxCores) {
            maxCores = cnt;
            minLen = len;
        } else if (cnt == maxCores) {
            if (len < minLen) {
                minLen = len;
            }
        }
        return;
    }

    // [재귀 단계]
    int r = cores[idx].r;
    int c = cores[idx].c;

    // 1. 4방향으로 전선 연결 시도
    for (int i = 0; i < 4; i++) {
        int wireLen = getWireLength(r, c, i);
        
        if (wireLen > 0) {
            // 전선 설치
            setWire(r, c, i, wireLen, 2); 
            // 다음 코어로 이동
            dfs(idx + 1, cnt + 1, len + wireLen);
            // 원상 복구 (Backtracking)
            setWire(r, c, i, wireLen, 0);
        }
    }

    // 2. 해당 코어를 연결하지 않고 건너뛰는 경우
    // (연결 가능했더라도 다른 코어를 위해 포기하는 경우 포함)
    dfs(idx + 1, cnt, len);
}

int main() {
    // 입출력 속도 향상
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    for (int test_case = 1; test_case <= T; test_case++) {
        cin >> N;
        
        cores.clear(); // 벡터 초기화
        map[12][12] = {0, }; // 맵 초기화는 루프 돌며 직접 입력받음
        
        // 초기화
        maxCores = 0;
        minLen = INT_MAX;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cin >> map[i][j];
                // 가장자리(전원이 이미 연결됨)가 아닌 코어만 리스트에 추가
                if (map[i][j] == 1) {
                    if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                        continue; 
                    }
                    cores.push_back({i, j});
                }
            }
        }

        dfs(0, 0, 0);

        cout << "#" << test_case << " " << minLen << "\n";
    }
    return 0;
}