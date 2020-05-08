#include <iostream>
#include <vector>
#include "graph.cpp"

#define g vector<vector<Edge *>>

using namespace std;

int getParent(int u, vector<int> &par)
{
    if (u == par[u])
        return par[u];

    par[u] = getParent(par[u], par);
    return par[u];
}

void kruskals(int u, int v, int w, vector<int> &par, vector<int> &size, g &newGraph)
{
    int p1 = getParent(u, par);
    int p2 = getParent(v, par);

    if (p1 != p2)
    {
        //merge
        if (size[p1] < size[p2])
        {
            par[p1] = par[p2];
            size[p2] += size[p1];
        }
        else
        {
            par[p2] = par[p1];
            size[p1] += size[p2];
        }
        addEdge(u, v, w, newGraph);
    }
}
int main()
{
    int n = 9;
    g newGraph(n, vector<Edge *>());
    vector<int> par(n);
    vector<int> size(n);
    for (int i = 0; i < n; i++)
    {
        par[i] = i;
        size[i] = 1;
    }

    kruskals(6, 7, 1, par, size, newGraph);
    kruskals(2, 8, 2, par, size, newGraph);
    kruskals(5, 6, 2, par, size, newGraph);
    kruskals(0, 1, 4, par, size, newGraph);
    kruskals(1, 7, 4, par, size, newGraph);
    kruskals(2, 5, 4, par, size, newGraph);
    kruskals(6, 8, 6, par, size, newGraph);
    kruskals(2, 3, 7, par, size, newGraph);
    kruskals(7, 8, 7, par, size, newGraph);
    kruskals(0, 7, 8, par, size, newGraph);
    kruskals(1, 2, 8, par, size, newGraph);
    kruskals(3, 4, 9, par, size, newGraph);
    kruskals(4, 5, 10, par, size, newGraph);
    kruskals(3, 5, 14, par, size, newGraph);

    display(newGraph);
}