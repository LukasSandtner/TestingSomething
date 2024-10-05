/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <stdio.h>
#include <cmath>
#include <iostream>
#include <conio.h>

using namespace std;

int main()
{
    int volba;
    double a, b, c;

    cout << "Vyberte možnost 1 (Neznáte přeponu) nebo možnost 2 (neznáte odvěsnu): ";
    cin >> volba;
    
    if(volba == 1) {
        cout << "Strana a: ";
        cin >> a;
        cout << "Strana b: ";
        cin >> b;
        if(a != 0 && b != 0) {
            c = sqrt(a * a + b * b);
            cout << "Přepona je: " << c;
        } else {
            printf("Strana nesmí být nulová!");
        }
    } else if(volba == 2) {
        //Názvy proměnných nemusí odpovídat reálným stranám projúhelníku (a != b)
        cout << "Odvěsna: ";
        cin >> a;
        cout << "Přepona: ";
        cin >>  c;
        
        if(a < c && a != 0 && c != 0) {
            b = sqrt(c * c - a * a);
            cout << "Odvěsna je: " << b;
        } else {
            printf("Odvěsna nesmí být větší než přepona nebo nesmí být hodnota nulová!");    
        }
        
    } else if(volba != 1 || volba != 2) {
        printf("Vyberte volbu 1 nebo 2!");
    }
    cout << "Stiskněte klávesu pro konec" << endl;
    getch();
}
