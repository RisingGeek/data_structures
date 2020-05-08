#include <iostream>
#include <vector>
#include "graph.cpp"

// #define vector<vector<Edge*>> vv

using namespace std;

void hamiltonianPath(int src, vector<vector<Edge *>> graph, bool vis[], string ans, int n, int origSrc)
{
    if (n == 1)
    {
        ans += to_string(src);
        // n--; //n was not decremented for dest
        cout << ans;
        for (int i = 0; i < graph[origSrc].size(); i++)
        {
            if (graph[origSrc][i]->v == src)
            {
                cout << " cycle";
                break;
            }
        }
        cout << endl;
        return;
    }

    vis[src] = true;
    for (Edge *e : graph[src])
    {
        if (vis[e->v] == false)
            hamiltonianPath(e->v, graph, vis, ans + to_string(src) + "->", n - 1, origSrc);
    }
    vis[src] = false;
}

int main()
{
    int n = 7;
    vector<vector<Edge *>> graph(n, vector<Edge *>());
    addEdge(0, 1, 10, graph);
    addEdge(0, 3, 20, graph);
    addEdge(1, 2, 16, graph);
    addEdge(2, 3, 60, graph);
    addEdge(3, 4, 30, graph);
    addEdge(4, 5, 2, graph);
    addEdge(4, 6, 8, graph);
    addEdge(5, 6, 50, graph);

    addEdge(0, 6, 50, graph);

    bool vis[n];
    hamiltonianPath(0, graph, vis, "", n, 0);
}