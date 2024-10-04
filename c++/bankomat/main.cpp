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
    int senzor, pin, castka;
    
    cout << "Vložte kartu" << endl << "************" << endl << "Vložena? ANO-1 || NE-0: ";
    cin >> senzor;
    if(senzor == 1) {
        cout << "Zadejte PIN: ";
        cin >> pin;
        if(pin == 1234) {
            cout << "Zadejte částku: ";
            cin >> castka;
            printf("Částka %i vyplacena", castka);
            cout << "\nKonec";
        }else {
            cout << "Chybný PIN!";
        } 
    }else {
        cout << "Konec";
    }

    return 0;
}