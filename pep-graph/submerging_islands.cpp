#include <iostream>
#include <vector>
#define g vector<vector<int>>

using namespace std;

int timer, rootCalls;
g graph;
vector<bool> vis;
vector<int> lowest;
vector<int> discovery;

void addEdge(int u, int v, g &graph)
{
    graph[u].push_back(v);
    graph[v].push_back(u);
}

int dfs(int v, int par)
{
    vis[v] = true;
    lowest[v] = discovery[v] = timer;
    timer++;

    int articulationPoint = 0;
    bool isArticulation = false;

    for (int e : graph[v])
    {
        if (!vis[e])
        { //unvisited
            if (par == -1)
                rootCalls++;
            articulationPoint += dfs(e, v);
            if (discovery[v] <= lowest[e])
            {
                //articulation point
                if (par != -1 && !isArticulation)
                {
                    articulationPoint++;
                    isArticulation = true;
                }
            }
            lowest[v] = min(lowest[v], lowest[e]);
        }
        else if (e != par)
        { //visited
            lowest[v] = min(lowest[v], discovery[e]);
        }
    }
    return articulationPoint;
}

int main()
{
    // your code goes here
    int n, m;
    cin >> n >> m;
    while (n != 0 && m != 0)
    {
        timer = 0;
        rootCalls = 0;
        graph.clear();
        vis.clear();
        lowest.clear();
        discovery.clear();
        graph.resize(n + 1);
        vis.resize(n + 1);
        lowest.resize(n + 1);
        discovery.resize(n + 1);
        for (int i = 0; i < m; i++)
        {
            int a, b;
            cin >> a >> b;
            addEdge(a, b, graph);
        }
        int articulationPoint = dfs(1, -1);
        if (rootCalls > 1)
            articulationPoint++;
        cout << articulationPoint << endl;

        cin >> n >> m;
    }
    return 0;
}