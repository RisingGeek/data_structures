#include <iostream>

using namespace std;

void fn(int &count)
{
    if (count == 2)
        return;
    cout << count;
    count++;
    fn(count);
}
int main()
{
    for (int i = 0; i < 5; i++)
    {
        int count = 0;
        fn(count);
    }
}