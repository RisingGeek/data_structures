#include <iostream>
#include <vector>

using namespace std;

class Edge
{
public:
    int v;
    int w;
    Edge(int v, int w)
    {
        this->v = v;
        this->w = w;
    }
};

void addEdge(int u, int v, int w, vector<vector<Edge *>>& graph)
{
    graph[u].push_back(new Edge(v, w));
}

void display(vector<vector<Edge *>>& graph)
{
    for (int i = 0; i < graph.size(); i++)
    {
        cout << i << "-> ";
        for (Edge *e : graph[i])
        {
            cout << "(" << e->v << ", " << e->w << ") ";
        }
        cout << endl;
    }
}