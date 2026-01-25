#include <iostream>
#include <unordered_map>
#include <string>
#include <vector>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int n, m;
	cin >> n >> m;

	unordered_map<string, int> map1;
	vector<string> v;

	string input;

	for (int i = 1; i <= n; i++) {
		cin >> input;
		map1[input] = i;
		v.push_back(input);
	}

	string p;
	for (int i = 0; i < m; i++) {
		cin >> p;
		if (isdigit(p[0])) {
			cout << v[stoi(p) - 1] << "\n";
		}
		else {
			cout << map1[p] << "\n";
		}
	}

}