/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <stdio.h>
#include <cmath>
#include <iostream>

using namespace std;

int main()
{
    double a, b, c, diskriminant, x1, x2, i;
    
    cout << "Zadejte koeficienty a, b, c \n";
    cout << "Koeficient a: ";
    cin >> a;
    cout << "Koeficient b: ";
    cin >> b;
    cout << "Koeficient c: ";
    cin >> c;
    
    diskriminant = b * b - 4 * a * c;
    
    if(a != 0) {
        if(diskriminant > 0) {
            x1 = (-b + sqrt(diskriminant)) / (2 * a);
            x2 = (-b - sqrt(diskriminant)) / (2 * a);
            cout << "První kořen: " << x1 << endl; 
            cout << "Druhý kořen: " << x2;
            
        } else if(diskriminant == 0) {
            x1 = -(b) / (2 * a);
            cout << "Kořen: " << x1;
            
        } else if(diskriminant < 0) {
            i = sqrt(-diskriminant) / (2 * a);
            x1 = -(b) / (2 * a);
            x2 = -(b) / (2 * a);
            cout << "První kořen: " << x1 << " + " << i << "i" << endl;
            cout << "Druhý kořen: " << x2 << " - " << i << "i";
        }   
    } else {
        printf("Nejedná se o kvadratickou rovnici! koeficient a je %i", (int)a);
    }
    
    return 0;
}