#include <iostream>

using namespace std;

char getParent(int i, char parent[])
{
    if ('a' + i == parent[i])
        return parent[i];

    char p = getParent(parent[i] - 'a', parent);
    parent[i] = p;
    return p;
}
string lexicographicallySmallestEqui(string a, string b, string s)
{
    char parent[26];
    for (int i = 0; i < 26; i++)
    {
        parent[i] = 'a' + i;
    }

    for (int i = 0; i < a.length(); i++)
    {
        char p1 = getParent(a[i] - 'a', parent);
        char p2 = getParent(b[i] - 'a', parent);

        if (p1 < p2)
        {
            parent[p2-'a'] = p1;
        }
        else if (p2 < p1)
        {
            parent[p1-'a'] = p2;
        }
    }

    string ans;
    for (int i = 0; i < s.length(); i++)
    {
        ans += parent[s[i] - 'a'];
    }
    return ans;
}
int main()
{
    string ans = lexicographicallySmallestEqui("leetcode", "programs", "sourcecode");
    cout << ans;
}