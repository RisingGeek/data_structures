#include <iostream>
#include <vector>
#include "graph.cpp"

using namespace std;

void dfs(int src, int dest, vector<vector<Edge *>> graph, bool vis[], string ans)
{
    if (src == dest)
    {
        cout << ans << endl;
        return;
    }
    vis[src] = true;
    for (Edge *e : graph[src])
    {
        if (vis[e->v] == false)
            dfs(e->v, dest, graph, vis, ans + to_string(e->v));
    }
}

int main()
{
    vector<vector<Edge *>> graph(7, vector<Edge *>());
    addEdge(0, 1, 10, graph);
    addEdge(0, 3, 20, graph);
    addEdge(1, 2, 16, graph);
    addEdge(2, 3, 60, graph);
    addEdge(3, 4, 30, graph);
    addEdge(4, 5, 2, graph);
    addEdge(4, 6, 8, graph);

    bool vis[graph.size()];
    dfs(0, 6, graph, vis, "");
}