#include <iostream>
#include <vector>
#include "graph.cpp"
#include <queue>

#define g vector<vector<Edge *>>

using namespace std;

void gcc(g graph, int v, bool vis[])
{
    queue<int> q;
    q.push(v);

    while (q.size() > 0)
    {
        int size = q.size();
        while (size > 0)
        {
            size--;

            int rVertex = q.front();
            q.pop();

            if (vis[rVertex] == true)
                continue;

            vis[rVertex] = true;
            for (Edge *e : graph[rVertex])
            {
                if (!vis[e->v])
                    q.push(e->v);
            }
        }
    }
}
int main()
{
    int n = 7;
    g graph(n, vector<Edge *>());
    addEdge(0, 1, 10, graph);
    addEdge(0, 3, 20, graph);
    addEdge(1, 2, 16, graph);
    addEdge(3, 4, 30, graph);
    addEdge(2, 3, 60, graph);
    addEdge(4, 5, 2, graph);
    addEdge(4, 6, 8, graph);
    addEdge(5, 6, 50, graph);

    bool vis[n] = {false};
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        if (!vis[i])
        {
            gcc(graph, i, vis);
            count++;
        }
    }
    cout<<count;
}