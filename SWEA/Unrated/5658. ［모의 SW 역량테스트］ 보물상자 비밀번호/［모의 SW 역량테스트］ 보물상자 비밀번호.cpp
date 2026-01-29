/*
	설계
	1. N/4는 한변의 길이, 그 길이 만큼만 회전 
		회전은 뒤에서 1글자 추출, 앞으로 삽입
	2. 중복 방지를 위해 set을 사용한다.
	3. iterator로 k까지 순회 후 출력한다.
*/

#include <iostream>
#include <set>
#include <cmath>
#include <string>

using namespace std;

int n, k;
string s;

void solve(int tc) {
	cin >> n >> k >> s;
	set<int, greater<int>> nums;

	int len = n / 4;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j += len) {
			string sub = s.substr(j, len);
			int val = stoll(sub, nullptr, 16);
			nums.insert(val);
		}

		char last = s.back();
		s.pop_back();
		s.insert(0, 1, last);
	}

	auto it = nums.begin();
	for (int i = 0; i < k - 1; i++) {
		it++;
	}

	cout << "#" << tc << " " << *it << "\n";
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int t = 1;
	cin >> t;

	for (int i = 1; i <= t; i++) {
		solve(i);
	}

	return 0;
}