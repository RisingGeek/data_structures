#include <iostream>
#include <vector>

using namespace std;

vector<int> pq;

void downHeapify(int pi)
{
    int lci = 2 * pi + 1;
    int rci = 2 * pi + 2;
    int maxi = pi;

    if (lci < pq.size() && pq[lci] > pq[maxi])
        maxi = lci;
    if (rci < pq.size() && pq[rci] > pq[maxi])
        maxi = rci;

    if (maxi != pi)
    {
        swap(pq[maxi], pq[pi]);
        downHeapify(maxi);
    }
}

void SetPriorityQueue(vector<int> &arr)
{
    for (int ele : arr)
        pq.push_back(ele);

    for (int i = pq.size() - 1; i >= 0; i--)
        downHeapify(i);
}

int top()
{
    return pq[0];
}

void pop()
{
    int n = pq.size() - 1;
    swap(pq[0], pq[n]);
    pq.erase(pq.begin() + n);
    downHeapify(0);
}

void heapSort(vector<int> &arr)
{
    int n = pq.size();
    int idx = 0;
    while (n-- > 0)
    {
        int el = top();
        pop();
        arr[idx] = el;
        idx++;
    }
}

int main()
{
    vector<int> arr = {2, 34, 2, 4, 1, 56, 3, 6};
    SetPriorityQueue(arr);
    heapSort(arr);
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << " ";
    }
}