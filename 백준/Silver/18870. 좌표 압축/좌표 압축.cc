#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
vector<int> arr1;
vector<int> arr2;
vector<int> answer;
void init() {
	cin >> N;
	arr1.assign(N, 0);
	answer.assign(N, 0);
	for (int i = 0; i < N; i++) {
		cin >> arr1[i];
	}
}

void compress() {
	arr2 = arr1;
	sort(arr2.begin(), arr2.end());
	arr2.erase(unique(arr2.begin(), arr2.end()), arr2.end());
	for (int i = 0; i < N; i++) {
		answer[i] = lower_bound(arr2.begin(), arr2.end(), arr1[i]) - arr2.begin();
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);
	init();
	compress();
	for (int i : answer) {
		cout << i << " ";
	}

	return 0;
}

