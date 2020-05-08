#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include "dGraph.cpp"

#define g vector<vector<Edge *>>

using namespace std;

void topologicalSort(g graph, int v, stack<int> &st, bool vis[])
{
    //mark
    //call dfs on unvisited nodes
    //push to stack
    vis[v] = true;
    for (Edge *e : graph[v])
    {
        if (!vis[e->v])
            topologicalSort(graph, e->v, st, vis);
    }
    st.push(v);
}

bool khansAlgo(g graph)
{
    int incomingEdges[graph.size()] = {0};
    int topArr[graph.size()];
    fill_n(topArr, graph.size(), -1);

    for (vector<Edge *> v : graph)
    {
        for (Edge *e : v)
        {
            incomingEdges[e->v]++;
        }
    }

    queue<int> q;
    for (int v = 0; v < graph.size(); v++)
    {
        if (incomingEdges[v] == 0)
            q.push(v);
    }

    int index = 0;
    while (q.size() > 0)
    {
        int rVertex = q.front();
        q.pop();
        topArr[index] = rVertex;
        index++;

        for (Edge *e : graph[rVertex])
        {
            incomingEdges[e->v]--;
            if (incomingEdges[e->v] == 0)
                q.push(e->v);
        }
    }
    if (topArr[graph.size() - 1] != -1)
    {
        for (int v = 0; v < graph.size(); v++)
        {
            cout << topArr[v] << " ";
        }
        return true;
    }
    return false;
}

int main()
{
    int n = 8;
    g graph(n, vector<Edge *>());
    addEdge(0, 1, 10, graph);
    addEdge(1, 2, 20, graph);
    addEdge(2, 3, 16, graph);
    addEdge(2, 7, 30, graph);
    addEdge(3, 5, 60, graph);
    addEdge(4, 3, 2, graph);
    addEdge(6, 3, 8, graph);
    addEdge(0, 3, 10, graph);

    // bool vis[n] = {false};
    // stack<int> st;
    // for (int i = 0; i < n; i++)
    // {
    //     if (!vis[i])
    //         topologicalSort(graph, i, st, vis);
    // }
    // while (st.size() > 0)
    // {
    //     cout << st.top() << " ";
    //     st.pop();
    // }

    khansAlgo(graph);
}