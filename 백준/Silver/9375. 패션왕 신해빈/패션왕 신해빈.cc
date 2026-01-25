#include <map>
#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(NULL);

	int t;
	cin >> t;

	while (t--) {
		int n;
		cin >> n;
		
		map<string, int> map;

		for (int i = 0; i < n; i++) {
			string name, category;
			cin >> name >> category;
			map[category]++;
		}

		int result = 1;
		
		for (auto& [key, value] : map) {
			result *= (value + 1);
		}

		cout << --result << "\n";
	}
}