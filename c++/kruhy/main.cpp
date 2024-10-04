/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <stdio.h>
#include <cmath>
#include <iostream>

using namespace std;
int main()
{
    double polomer;
    double vysledek;

    cout << "Poloměr: ";
    cin >> polomer;
    
    if(polomer != 0) {
        double obvod = M_PI * polomer * 2;
        printf("Obvod: %f\n", obvod);
        double obsah = M_PI * polomer * polomer;
        printf("Obsah: %f", obsah);
    }else {
        cout << "Nesmí být 0!";    
    }
    
    return 0;
}