#include <iostream>
#include <vector>
#include "graph.cpp"

using namespace std;

void dfs(int v, vector<vector<Edge *>> graph, bool vis[])
{
    cout << v << endl;

    vis[v] = true;
    for (Edge *e : graph[v])
    {
        if (vis[e->v] == false)
            dfs(e->v, graph, vis);
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
    dfs(2, graph, vis);
}