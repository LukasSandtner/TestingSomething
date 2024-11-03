#include <iostream>

using namespace std;
int main()
{
	int x[] = {5, 4, 8, 45, 20, 8};
	int velikostPole = sizeof(x)/sizeof(x[0]);
	for(int o = 0; o < velikostPole - 1; o++) {
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
	int length = sizeof(x)/sizeof(pole1[0]);
	int min = pole1[0];
	for (int i = 0; i < length; i++) {
	    if(pole1[i] < min){
	        min = pole1[i];
	    }
	}
	
	int y = 0;
	while(true) {

		min = min + 1;

		if(min == 100) {
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

	int A; // deklarace promennych (celociselny typ)
	cin >> A; // cteni cisl ze vstupu
	while (A<10) { // podmC-nka ukonceni cyklu
		A = A + 1;
		if (A == 8) { // pri dosazeni A==8
			break; // while konci v tomto miste! (cout << A se uz neprovede!!)
		}
		cout << A << " ";
	}
	cout << A;
}


