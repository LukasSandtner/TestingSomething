#include <iostream>

using namespace std;

int main() {
	int n;

	do {
		double pi = 0.0;
		cout << "Zadejte pocet iteraci (0 pro konec): ";
		cin >> n;

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				pi += 4.0 / (2.0 * i + 1.0);
			} else {
				pi -= 4.0 / (2.0 * i + 1.0);
			}
		}
		cout << "Priblizna hodnota pi je: " << pi << endl;
	} while(n != 0);
	
    cout << "KONEC";


	return 0;
}