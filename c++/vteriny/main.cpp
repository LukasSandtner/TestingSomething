/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <stdio.h>
#include <iostream>

using namespace std;
int main()
{
    cout << "Zadejte sekundy: ";
    long celkoveSekundy;
    cin >> celkoveSekundy;
        int sekundyZaMinutu = 60;
        int sekundyZaHodinu = sekundyZaMinutu * 60;
        int sekundyZaDen = sekundyZaHodinu * 24;

        // Výpočet
        int dny = celkoveSekundy / sekundyZaDen;
        int zbyvajiciSekundy = celkoveSekundy % sekundyZaDen;

        int hodiny = zbyvajiciSekundy / sekundyZaHodinu;
        zbyvajiciSekundy %= sekundyZaHodinu;

        int minuty = zbyvajiciSekundy / sekundyZaMinutu;
        int sekundy = zbyvajiciSekundy % sekundyZaMinutu;
    
    cout << "Dny: " << dny << endl <<"Hodiny: " << hodiny << endl << "Minuty: " << minuty << endl << "Sekundy: " << sekundy;
    
    return 0;
}