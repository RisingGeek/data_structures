#include <iostream>
#include <vector>

using namespace std;

int burstBallon(vector<int> &arr, int st, int en, vector<vector<int>> &dp)
{
    if (dp[st][en] != 0)
        return dp[st][en];

    int l = st - 1 == -1 ? 1 : arr[st - 1];
    int r = en + 1 == arr.size() ? 1 : arr[en + 1];
    int maxAns = 0;
    
    for (int i = st; i <= en; i++)
    {
        int left = i == st ? 0 : burstBallon(arr, st, i - 1, dp);
        int right = i == en ? 0 : burstBallon(arr, i + 1, en, dp);

        int myCost = left + l * arr[i] * r + right;
        if (myCost > maxAns)
            maxAns = myCost;
    }

    dp[st][en] = maxAns;

    return maxAns;
}

int main()
{
    vector<int> arr = {3, 1, 5, 8};
    vector<vector<int>> dp(4, vector<int>(4));
    int points = burstBallon(arr, 0, 3, dp);
    cout << points;
}