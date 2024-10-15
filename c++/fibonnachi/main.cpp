/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>
#include <conio.h>

using namespace std;
int main()
{   
    bool balls = true;
    do {  
        int length;
        int counter = 0;
        cout << "\nPočet prvků: ";
        cin >> length;
        int c = 0;
        int a = 0;
        int b = 1;
        while(counter < length) {
            c = a + b;
            a = b;
            b = c;
            counter++;
            cout << "\t" << b;
        }
    } while (balls == true);
    getch();
}