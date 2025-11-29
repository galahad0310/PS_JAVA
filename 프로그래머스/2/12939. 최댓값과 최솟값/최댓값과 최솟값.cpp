#include <string>
#include <vector>
#include <algorithm>
#include <sstream>

using namespace std;

string solution(string s) {
    string answer = "";
    
    stringstream ss(s);
    int num;
    vector<int> v; 
    
    while(ss >> num){
        v.push_back(num);
    }
    
    sort(v.begin(), v.end());
    
    return to_string(v.front()) + " " + to_string(v.back());
}