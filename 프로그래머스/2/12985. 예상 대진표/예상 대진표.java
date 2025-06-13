class Solution
{
    public int solution(int n, int a, int b)
    {
        int cnt = 1;
        int t1 = (a+1) / 2;
        int t2 = (b+1) / 2;
        while(t1!=t2){
            cnt++;
            t1 = (t1+1) / 2;
            t2 = (t2+1) / 2;
        }
        return cnt;
    }
}