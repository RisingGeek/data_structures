#include <iostream>
#include <vector>
#include <queue>
#include "graph.cpp"

#define g vector<vector<Edge *>>

using namespace std;

class Vertex
{
public:
    int v, par, w, wsf;
    Vertex(int v, int par, int w, int wsf)
    {
        this->v = v;
        this->par = par;
        this->w = w;
        this->wsf = wsf;
    }

    //in c++, default priority queue is max. But, internally min priority queue is implemented
    bool operator<(Vertex const &p1) const
    {
        return this->wsf > p1.wsf;
    }
};

void bfs(g graph, g &newGraph)
{
    priority_queue<Vertex> que;
    que.push({0, -1, 0, 0});
    bool vis[graph.size()] = {false};

    while (que.size() > 0)
    {
        Vertex rVertex = que.top();
        que.pop();
        // cout << rVertex.v << " " << rVertex.par << endl;

        if (vis[rVertex.v])
        {
            //cycle
            continue;
        }
        vis[rVertex.v] = true;
        if (rVertex.par != -1)
        {
            addEdge(rVertex.v, rVertex.par, rVertex.w, newGraph);
        }

        for (Edge *e : graph[rVertex.v])
        {
            if (!vis[e->v])
            {
                que.push({e->v, rVertex.v, e->w, rVertex.wsf + e->w});
            }
        }
    }
}
int main()
{
    int n = 9;
    g graph(n, vector<Edge *>());
    addEdge(0, 1, 4, graph);
    addEdge(0, 7, 8, graph);
    addEdge(1, 2, 8, graph);
    addEdge(1, 7, 4, graph);
    addEdge(2, 3, 7, graph);
    addEdge(2, 5, 4, graph);
    addEdge(2, 8, 2, graph);
    addEdge(3, 4, 9, graph);
    addEdge(3, 5, 14, graph);
    addEdge(4, 5, 10, graph);
    addEdge(5, 6, 2, graph);
    addEdge(6, 7, 1, graph);
    addEdge(6, 8, 6, graph);
    addEdge(7, 8, 7, graph);

    g newGraph(graph.size(), vector<Edge *>());
    bfs(graph, newGraph);
    display(newGraph);
}