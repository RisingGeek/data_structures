// https://practice.geeksforgeeks.org/problems/m-coloring-problem/0

#include <iostream>
#include <vector>
#define g vector<vector<int>>

using namespace std;

void addEdge(int u, int v, g &graph)
{
    graph[u].push_back(v);
    graph[v].push_back(u);
}

bool isSafe(int v, g &graph, int c, int colors[])
{
    for (int e : graph[v])
    {
        if (c == colors[e])
            return false;
    }
    return true;
}

bool mColor(int v, g graph, int colors[], int m)
{
    if (v == graph.size())
        return true;
    for (int color = 1; color <= m; color++)
    {
        if (isSafe(v, graph, color, colors))
        {
            colors[v] = color;
            if (mColor(v + 1, graph, colors, m))
                return true;
            colors[v] = 0;
        }
    }
    return false;
}

int main()
{
    // your code goes here
    int t;
    cin >> t;
    for (int it = 0; it < t; it++)
    {
        int n, m, e;
        cin >> n >> m >> e;

        g graph(n + 1, vector<int>());
        bool vis[n + 1] = {false};
        int colors[n + 1] = {0};

        for (int i = 0; i < e; i++)
        {
            int u, v;
            cin >> u >> v;
            addEdge(u, v, graph);
        }
        bool ans = mColor(1, graph, colors, m);
        cout << ans << endl;
    }
}
