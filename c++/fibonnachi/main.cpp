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
    int length;
    do {  
        int counter = 0;
        cout << "\nPočet prvků (0 pro konec): ";
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
    } while (length != 0);
}
