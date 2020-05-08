#include <iostream>
#include <vector>

using namespace std;

int queenpermutation(vector<bool> boxes, int bn, int qpsf, int tnq, string ans)
{
    if (qpsf == tnq)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    for (int i = 0; i < boxes.size(); i++)
    {
        if (!boxes[i])
        {
            boxes[i] = true;
            count += queenpermutation(boxes, i + 1, qpsf + 1, tnq,
                                      ans + "b" + to_string(i) + "q" + to_string(qpsf) + " ");
            boxes[i] = false;
        }
    }

    return count;
}

int main()
{
    int n = 4;
    vector<bool> boxes(n, false);
    cout << queenpermutation(boxes, 0, 0, 2, "");
}