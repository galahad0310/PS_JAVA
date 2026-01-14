#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

string solution(string s) {
    stringstream ss(s);
    int num;
    ss >> num;
    
    int min_val = num;
    int max_val = num;
    
    while(ss >> num){
        min_val = min(min_val, num);
        max_val = max(max_val, num);
    }
    
    return to_string(min_val) + " " + to_string(max_val);
    
}