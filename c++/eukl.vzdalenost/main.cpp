/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>
#include <cmath>

using namespace std;
//VÝPOČET VELIKOSTI VEKTORU V KARTÉZKÉ SOUSTAVĚ 
int main()
{
    //DATA
    int a, b;
    int souradniceX[2];
    int souradniceY[2];
    double vektor;
    //VSTUP
    cout << "[X1;Y1]: " << endl;
    cin >> souradniceX[0];
    cin >> souradniceX[1];
    
    cout << "[X2;Y2]: " << endl;
    cin >> souradniceY[0];
    cin >> souradniceY[1];
    
    a = abs(souradniceY[0] - souradniceX[0]); 
    b = abs(souradniceY[1] - souradniceX[1]);
    vektor = sqrt((a * a) + (b * b));
    cout << "Velikost vektoru: " << vektor;
    return 0;
}
