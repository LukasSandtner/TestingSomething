/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>
#include <iomanip>

using namespace std;
int main()
{
	int x[] = {5, 4, 8, 45, 20, 8};
	int velikostPole = sizeof(x)/sizeof(x[0]);
	for(int o = 0; o < velikostPole - 2; o++) {
		if(x[o]%2 == 0) {
			x[o] += 1;
		} else {
			x[o] -= 1;
		}
	}
	for(int zmena : x) {

		if(zmena > 10) {
			continue;
		}
		cout << zmena << " ";
	}
	int pole1[] = {5,4,8,45,65,8};
	int y = 0;
	while(true) {
		if(y == 6) {
			y = 0;
		}

		pole1[y] = pole1[y] + 1;

		if(pole1[y] == 100) {
			break;
		}
		y++;
	}
	cout << endl << "------" << endl;
	for(int zmena1 : pole1) {
		cout << zmena1 << " ";
	}
    
    cout << endl <<"zadej faktorial: ";
    int f;
    cin >> f;
    
    for (int i = f-1; i >= 2; i--) {
        f = f * i;
    }
    cout << f;
}

