#include <iostream>

using namespace std;
int main()
{
	int a, b, tmp;
	int counter = 0;
	int counter2 = 0;
	
	while(true) {
		cout << "\nNSD" << endl << "---";
		cout << "\nZadejte a (0 pro konec): ";
		cin >> a;
		
		if(a == 0) {
			cout << "KONEC";
			break;
		}
		
		cout << "\nZadejte b: ";
		cin >> b;
		
		if(b <= 0) {
			cout << "b nesmi byt nula a min!\n";
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
