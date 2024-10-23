/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>

using namespace std;

int main()
{
    int penize;
    cout << "Zadej penize: ";
    cin >> penize;
    
    for (int platidlo: {5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1}) {
        int pocet = penize / platidlo;
        penize = penize % platidlo;
        cout << platidlo << ": " << pocet << endl;
    }
    
    
}