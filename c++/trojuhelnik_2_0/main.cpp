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

    cout << "Vyberte moznost 1 (Neznate preponu) nebo moznost 2 (neznate odvesnu): ";
    cin >> volba;
    
    if(volba == 1) {
        cout << "Strana a: ";
        cin >> a;
        cout << "Strana b: ";
        cin >> b;
        if(a != 0 && b != 0) {
            c = sqrt(a * a + b * b);
            cout << "Prepona je: " << c;
        } else {
            printf("Strana nesmi byt nulova!");
        }
    } else if(volba == 2) {
        //Názvy proměnných nemusí odpovídat reálným stranám projúhelníku (a != b)
        cout << "Odvesna: ";
        cin >> a;
        cout << "Prepona: ";
        cin >>  c;
        
        if(a < c && a != 0 && c != 0) {
            b = sqrt(c * c - a * a);
            cout << "Odvesna je: " << b;
        } else {
            printf("Odvesna nesmi byt vetsi nez prepona nebo nesmi byt hodnota nulova!");    
        }
        
    } else if(volba != 1 || volba != 2) {
        printf("Vyberte volbu 1 nebo 2!");
    }
    cout << endl << "Stisknete klavesu pro konec" << endl;
    getch();
}
