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
	int a, b;
	int counter = 0;
	int counter2 = 0;
	int c = 0;
	int x, y, tmp;
	while(true) {
		cout << "\nNSD" << endl << "---";
		cout << "\nZadejte x (0 pro konec): " << endl;
		cin >> a;
		if(a == 0) {
			cout << "KONEC";
			break;
		}
		cout << "\nZadejte y: " << endl;
		cin >> b;
		if(b == 0) {
			cout << "b nesmi byt nula!\n";
			continue;
		}

		while(a != b) {
			if(a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
			counter++;
		}
		cout << "\nNSD: " << a << endl;
		cout << "\nOpakovani: " << counter << endl;
		cout << "----------------";

		while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
			counter2++;
		}
			cout << "\nNSD: " << a << endl;
			cout << "\nOpakovani: " << counter2 << endl;
	}
}