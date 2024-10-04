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
    char op;
    double a, b, c;
    
    cout << "Zadej opraci, prvni cislo a druhy cislo: ";
    cin >> op;
    cin >> a;
    cin >> b;
    
    /*if(op == '+') {
        c = a + b;
        cout << c;
    } else if(op == '-') {
        c = a - b;
        cout << c;
    } else if(op == '*') {
        c = a * b;
        cout << c;
    } else if(op == '/') {
        if(b != 0) {
            c = a / b;
            cout << c;
        } else {
            cout << "Nedělit nulou!";
        }
    } else {
        cout << "Zadej operátor!";
    }*/
    
    switch(op) {
        case '+':
            c = a + b;
            cout << c;  
            break;
        case '-':
            c = a - b;
            cout << c;
            break;
        case '*':
            c = a * b;
            cout << c;
            break;
        case '/':
            if(b != 0) {
                c = a / b;
                cout << c;
            } else {
                cout << "Nedělit nulou!"
            }
            break;
    }
    return 0;
}