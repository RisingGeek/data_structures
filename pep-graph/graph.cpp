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

// int n = 7;
// vector<vector<Edge *>> graph(7, vector<Edge *>());

void addEdge(int u, int v, int w, vector<vector<Edge *>>& graph)
{
    graph[u].push_back(new Edge(v, w));
    graph[v].push_back(new Edge(u, w));
}

int findIndex(int u, int v, vector<vector<Edge *>>& graph)
{
    int index = -1;
    for (int i = 0; i < graph[u].size(); i++)
    {
        if (graph[u][i]->v == v)
        {
            return i;
        }
    }
    return index;
}

void removeEdge(int u, int v, vector<vector<Edge *>>& graph)
{
    int vIdx = findIndex(u, v, graph);
    int uIdx = findIndex(v, u, graph);
    graph[u].erase(graph[u].begin() + vIdx);
    graph[v].erase(graph[v].begin() + uIdx);
}

// void removeVertex(int u)
// {
//     for (int i = 0; i < graph[u].size(); i++)
//     {
//         int v = graph[u][i]->v;
//         int index = -1;
//         for (int j = 0; j < graph[v].size(); j++)
//         {
//             if (graph[v][j]->v == u)
//             {
//                 index = j;
//                 break;
//             }
//         }
//         graph[v].erase(graph[v].begin() + index);
//     }
//     graph[u].clear();
// }

void removeVertex(int vertex, vector<vector<Edge *>>& graph)
{
    for (int i = graph[vertex].size() - 1; i >= 0; i--)
    {
        removeEdge(graph[vertex][i]->v, vertex, graph);
    }
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

// void hamiltonian(int src, int dest, bool vis[], string ans, int origSrc)
// {
//     if (src == dest)
//     {
//         if (ans.length() == n)
//         {
//             cout << ans << " ";
//             for (int i = 0; i < graph[origSrc].size(); i++)
//             {
//                 if (graph[origSrc][i]->v == dest)
//                 {
//                     cout << "isCycle";
//                     break;
//                 }
//             }
//         }
//         return;
//     }

//     //mark
//     vis[src] = true;
//     for (Edge *e : graph[src])
//     {
//         hamiltonian(e->v, dest, vis, ans + to_string(e->v), origSrc);
//     }
//     //unmark
//     vis[src] = false;
// }

// int main()
// {
//     addEdge(0, 1, 10);
//     addEdge(0, 3, 20);
//     addEdge(1, 2, 16);
//     addEdge(2, 3, 60);
//     addEdge(3, 4, 30);
//     addEdge(4, 5, 2);
//     addEdge(4, 6, 8);
//     display();
//     // removeEdge(3, 2);
//     // removeVertex(3);
//     // cout << endl;
//     // display();

//     bool vis[7];
//     // hamiltonian(0, 6, vis, "", 0);
//     return 0;
// }