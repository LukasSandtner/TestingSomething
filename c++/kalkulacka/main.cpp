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
	/*char op;
	double a, b, c;

	cout << "Zadej opraci, prvni cislo a druhy cislo: ";
	cin >> op;
	cin >> a;
	cin >> b;*/

	/*while (a != 0) {

		if(op == '+') {
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
				cout << "NedDlit nulou!";
			}
		} else {
			cout << "Zadej operC!tor!";
		}
	}
	cout << "\nKONEC";*/

	/*do {
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
				cout << "NedDlit nulou!";
			}
			break;
		}
	} while(a != 0);
	cout << "\nKONEC";*/

	float A, B, x;
	char op; // deklarace typu pro znak
	string konec;

	//do {
	while(true){    
		cout << "\nZadej vyraz, napr. 2 + 2 (0 a 0 pro KONEC): ";
		cin >> A >> op >> B;
		if (A == 0 && B == 0) {
		    cout << "\n-----" << "\nKONEC";
			break;
			
		} else {
			switch (op) {
			case '+':
				x=A+B;
				cout << x;
				break;
			case '-':
				x=A-B;
				cout << x;
				break;
			case '*':
				x=A*B;
				cout << x;
				break;
			case '/':
				if (B != 0) { // pridame test nuloveho jmenovatele
					x=A/B;
					cout << x;
				} else {
					cout << "\nDeleni nulou!";
				}
				break;
			default:
				cout << "\nNespravny operator!";
			}
		}
	}//} while (A != 0);
	//cout << "\n-----" << "\nKONEC";
}
