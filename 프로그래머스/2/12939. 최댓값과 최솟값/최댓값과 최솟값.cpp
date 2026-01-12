#include <string>
#include <vector>
#include <algorithm>
#include <sstream>

using namespace std;

string solution(string s) {
    stringstream ss(s); //c++은 이렇게, 객체를 stack에 저장할 수 있다.
    int next;
    ss >> next;
    
    int min_val = next;
    int max_val = next;
    
    while(ss >> next){
        min_val = min(min_val, next);
        max_val = max(max_val, next);
    }
    
    return to_string(min_val) + " " + to_string(max_val);
}
