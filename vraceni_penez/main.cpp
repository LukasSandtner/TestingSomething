#include <iostream>

using namespace std;

int main()
{
    int penize;
    cout << "Zadej penize (0 pro konec): ";
    cin >> penize;
    
    do{
        for (int platidlo: {5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1}) {
            int pocet = penize / platidlo;
            penize = penize % platidlo;
            cout << platidlo << ": " << pocet << endl;
        }
    } while(penize != 0);
    cout << "KONEC";
}
