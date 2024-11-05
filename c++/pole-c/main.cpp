/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/
#include <iostream>
#include <stdlib.h>

using namespace std;
int main()
{
	int pole[5] = {4, 0, 9, 5, 6};
	//pole[0] = 1;

	cout << '\n';
	for(int prvek: pole) {
		cout << prvek << '\t';
	}

	cout <<"\n";
	int i = 0;
	while(i < 5) {
		pole[i] += 1;
		cout << pole[i] << "\t";
		i++;
	}

	cout << '\n';
	int length = sizeof(pole) / sizeof(pole[0]);
	for (int i = 0; i < length; i++) {
		if(i % 2 == 0) {
			pole[i] += 1;
		} else {
			pole[i] -= 1;
		}
		cout << pole[i] << '\t';
	}

	int j = 0;
	while(true) {
		if(j == 5) {
			j = 0;
		}
		pole[j] += 1;

		if(pole[j] == 50) {
			break;
		}
		j++;
	}
	cout << "\n";
	for(int prvek: pole) {
		cout << prvek << '\t';
	}
    
    cout << "\n";
	int x[11];
	int tmp;
	int len = sizeof(x)/sizeof(x[0]);
	for (int i = 0; i < len; i++) {
		x[i] = rand()%100;
	}
	for(int prvek: x) {
		cout << prvek << '\t';
	}
	cout << "\n";
    for (int i = 0; i < len/2; i++) {
		tmp = x[len -1 - i];
		x[len -1 -i] = x[i];
		x[i] = tmp;
	}
	for(int prvek: x) {
		cout << prvek << '\t';
	}
    



	while(true) {
		cout << "\nZadej pocet prvku: ";
		int n;
		cin >> n;
		if(n == 0) {
			cout << "KONEC";
			break;
		}
		int f[n];
		f[0] = 1;
		f[1] = 1;
		for (int k = 2; k < n; k++) {
			f[k] = f[k-2] + f[k-1];
		}

		for(int prvek: f) {
			cout << prvek << '\t';
		}
	}
    int pole[] = {5, 8, 6, 14, 1, 18, 19, 7, 20}; 
    int b, d, x;
    int c = 4;
    int min = 5;
    int max = 17;
    for(int i = 3; i < 9; i++){
        if(pole[i] > min && pole[i] <= 18){
            x = pole[i];
            cout << x << "\t";
        }
        cout<< pole[i] << "\t";
    } 
    b = x; d = b; x = c;
    d = d + 1;
    cout << endl << x << endl << d;
}
