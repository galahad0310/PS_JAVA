#include <iostream>
#include <unordered_map>
#include <cctype>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, m;
	cin >> n >> m;

	unordered_map<int, string> map1;
	unordered_map<string, int> map2;

	for (int i = 1; i <= n; i++) {
		string s;
		cin >> s;
		map1[i] = s;
		map2[s] = i;
	}

	for (int i = 0; i < m; i++) {
		string s;
		cin >> s;

		if (isdigit(s[0])) {
			int num = stoi(s);
			cout << map1[num] << "\n";
		}
		else {
			cout << map2[s] << "\n";
		}
	}

	return 0;
}