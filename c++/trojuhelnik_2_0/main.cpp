/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <cmath>
#include <iostream>

using namespace std;

int main()
{
    int volba;
    double a, b, c;
while(true){
    cout << "Vyberte možnost 1 (Neznáte přeponu), možnost 2 (neznáte odvěsnu) nebo 0 pro konec: ";
    cin >> volba;
    if(volba == 0){
        cout << "KONEC";
    }    
    
    if(volba == 1) {
        cout << "Strana a: ";
        cin >> a;
        cout << "Strana b: ";
        cin >> b;
        if(a != 0 && b != 0) {
            c = sqrt(a * a + b * b);
            cout << "Přepona je: " << c << endl;
        } else {
            printf("Strana nesmí být nulová!\n");
        }
    } else if(volba == 2) {
        //Názvy proměnných nemusí odpovídat reálným stranám projúhelníku (a != b)
        cout << "Odvěsna: ";
        cin >> a;
        cout << "Přepona: ";
        cin >>  c;
        
        if(a < c && a != 0 && c != 0) {
            b = sqrt(c * c - a * a);
            cout << "Odvěsna je: " << b << endl;
        } else {
            printf("Odvěsna nesmí být větší než přepona nebo nesmí být hodnota nulová\n!");    
        }
        
    } else if(volba != 1 || volba != 2 || volba != 0) {
        printf("Vyberte volbu 0, 1 nebo 2!\n");
    }
}
}
