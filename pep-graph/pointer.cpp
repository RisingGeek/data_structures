#include <iostream>

using namespace std;

int* test() {
    int*ar = new int[10];
    cout<<sizeof(ar)<<endl;
    cout<<sizeof(int)<<endl;
    cout<<sizeof(ar)/sizeof(ar[0])<<endl;
    return ar;
}

int* test2() {
    int a=10;
    return &a;
}
int main()
{
    // int a = 10;
    // int *b = &a;
    // int *c = new int(10);
    // cout<<*c;
    // (b - c > 0) ? cout << "stack is on top" : cout << "stack is on bottom";

    // int* arr = new int[10];

    // for(int i=0;i<10;i++) {
    //     cout<<*(arr+i)<<" ";
    // }
    // cout<<endl;
    // int*ar = test();
    // cout<<sizeof(ar)/sizeof(int)<<endl;
    int*b = test2();
    cout<<*b;
}