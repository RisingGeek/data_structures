#include <iostream>
#include <vector>
#define g vector<vector<int>>

using namespace std;

void addEdge(int u, int v, g &graph)
{
    graph[u].push_back(v);
}

int timer;
g graph;
vector<bool> vis;
vector<int> lowest;
vector<int> discovery;
vector<int>ap;

int dfs(int v, int par)
{
    vis[v] = true;
    int articulationCount = 0;
    bool isArticulation = false;

    lowest[v] = discovery[v] = timer;
    timer++;

    for (int e : graph[v])
    {
        if (!vis[e])
        {
            // if (par == -1)
            //     rootCalls++;
            articulationCount += dfs(e, v);
            // dfs(e, v);

            if (discovery[v] <= lowest[e])
            {
                //articulation point
                if (!isArticulation)
                {
                    articulationCount++;
                    ap[v] = 1;
                    isArticulation = true;
                }
                // ap[v]++;
            }
            lowest[v] = min(lowest[v], lowest[e]);
        }
        else if (e != par) //visited and not root
        {
            lowest[v] = min(lowest[v], discovery[e]);
        }
    }
    return articulationCount;
}

int main()
{
    // your code goes here
    for (int it = 0; it < 10; it++)
    {
        int n, m;
        cin >> n >> m;
        timer = 0;
        graph.clear();
        vis.clear();
        lowest.clear();
        discovery.clear();
        ap.clear();
        graph.resize(n+1);
        vis.resize(n+1);
        lowest.resize(n+1);
        discovery.resize(n+1);
        ap.resize(n+1);
        for (int i = 0; i < m; i++)
        {
            int a, b;
            cin >> a >> b;
            addEdge(a, b, graph);
        }
        int articulationCount = dfs(1, -1);
        // if (rootCalls > 1)
        cout<<articulationCount<<endl;
        for(int i=1;i<ap.size();i++) {
        	if(ap[i] == 1) cout<<i<<" ";
        }
        cout<<endl;
    }
}
