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
	int f, a;
	do {
		cout << "\nZADEJ FAKTORIAL: ";
		cin >> f;
		a = f;
		while(f > 2) {
			f = f - 1;
			a = f * a;
		}
		cout << a;
	} while (f != 0);
	cout << "\n-----" << "\nKONEC";

}