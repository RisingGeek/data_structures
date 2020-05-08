#include <iostream>
#include <vector>
#include "graph.cpp"

using namespace std;

bool hasPath(int src, int dest, vector<vector<Edge *>> graph, bool vis[])
{
    if (src == dest)
    {
        return true;
    }

    vis[src] = true;
    for (Edge *e : graph[src])
    {
        if (vis[e->v] == false)
        {
            bool res = hasPath(e->v, dest, graph, vis);
            if (res)
                return true;
        }
    }
    return false;
}

void allPath(int src, int dest, vector<vector<Edge *>> graph, bool vis[], string ans)
{
    if (src == dest)
    {
        ans += to_string(src);
        cout << ans << endl;
        return;
    }
    //mark
    vis[src] = true;
    //go to unvisited neighbours
    for (Edge *e : graph[src])
    {
        if (vis[e->v] == false)
            allPath(e->v, dest, graph, vis, ans + to_string(src) + "->");
    }
    //unmark
    vis[src] = false;
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
    bool vis[graph.size()]={false};

    // cout << hasPath(2, 5, graph, vis);
    allPath(1, 2, graph, vis, "");
}