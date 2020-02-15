#include <iostream>
#include <list>

using namespace std;

int main()
{
    list<int> ll;
    ll.push_back(2);
    ll.push_back(3);
    ll.pop_back();
    cout << ll.front();

    return 0;
}