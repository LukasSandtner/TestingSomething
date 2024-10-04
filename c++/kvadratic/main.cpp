/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    int a, b, c;
    double x1, x2, diskriminant, i;
    
    cout << "Zadejte koeficienty a, b, c:";
    cin >> a;
    cin >> b;
    cin >> c;
    
    if(a == 0 && b == 0) {
        cout << "Není Kvadratická rovnice!";
    } else if(a == 0) {
        x1 = -c/b;
        cout << "Lineární rovnice: " << x1;
    } else {
            diskriminant = b * b - 4 * a * c;
        
            if(diskriminant > 0) {
                x1 = (-b + sqrt(diskriminant)) / (2 * a);
                x2 = (-b - sqrt(diskriminant)) / (2 * a);
                printf("První kořen: %f\nDruhý kořen: %f", x1, x2);
            } else if(diskriminant == 0) {
                x1 = -(b) / (2 * a);
            } else if(diskriminant < 0) {
                i = sqrt(-diskriminant) / (2 * a);
                x1 = -(b) / (2 * a);
                cout << "První kořen: " << x1 << " + " << i << "i" << endl;
                cout << "Druhý kořen: " << x1 << " - " << i << "i";            
            }
    } 
    
    
    

    return 0;
}