#include <string>
#include <vector>
#include <algorithm> //max, min 함수 사용
#include <sstream> // 문자열파싱을 위해 사용 
#include <climits> // INT_MAX, INT_MIN 사용

using namespace std;

string solution(string s) {
    int maxVal = INT_MIN;
    int minVal = INT_MAX;
    
    stringstream ss(s);
    string temp;
    
    while(ss >> temp){
        int num = stoi(temp);
        
        maxVal = max(maxVal, num);
        minVal = min(minVal, num);
    }
    
    return to_string(minVal) + " " + to_string(maxVal);
}