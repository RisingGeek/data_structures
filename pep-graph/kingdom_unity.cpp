#include <iostream>
#include <vector>
#define g vector<vector<int>>

using namespace std;

void addEdge(int u, int v, g &graph)
{
    graph[u].push_back(v);
    graph[v].push_back(u);
}

int timer, rootCalls;
g graph;
vector<bool> vis;
vector<int> lowest;
vector<int> discovery;

int dfs(int v, int par)
{
    vis[v] = true;
    int articulationCount = 0;
    bool isArticulation = false;

    lowest[v] = discovery[v] = timer;
    timer++;

    for (int e : graph[v])
    {
        if (!vis[e])
        {
            if (par == -1)
                rootCalls++;
            articulationCount += dfs(e, v);
            // dfs(e, v);

            if (discovery[v] <= lowest[e])
            {
                //articulation point
                if (par != -1 && !isArticulation)
                {
                    articulationCount++;
                    isArticulation = true;
                }
                // ap[v]++;
            }
            lowest[v] = min(lowest[v], lowest[e]);
        }
        else if (e != par) //visited and not root
        {
            lowest[v] = min(lowest[v], discovery[e]);
        }
    }
    return articulationCount;
}

int main()
{
    // your code goes here
    int t;
    cin >> t;
    for (int it = 0; it < t; it++)
    {
        int n, m, k;
        cin >> n >> m >> k;
        timer = 0;
        rootCalls = 0;
        graph.clear();
        vis.clear();
        lowest.clear();
        discovery.clear();
        graph.resize(n);
        vis.resize(n);
        lowest.resize(n);
        discovery.resize(n);
        for (int i = 0; i < m; i++)
        {
            int a, b;
            cin >> a >> b;
            addEdge(a, b, graph);
        }
        // int articulationCount = dfs(0, -1, graph, vis, lowest, discovery);
        int articulationCount = dfs(0, -1);
        if (rootCalls > 1)
            articulationCount++;
        int ans = articulationCount * k;
        cout << ans << endl;
    }
}
