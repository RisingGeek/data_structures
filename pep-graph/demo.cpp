#include <iostream>
#include <vector>
#include "graph.cpp"

using namespace std;

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

    display(graph);
    // removeEdge(3, 2,graph);
    removeVertex(3, graph);
    display(graph);
}