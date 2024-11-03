#include <iostream>
#include <cmath>

using namespace std;
int main()
{
	while(true) {
		double a, b, c;
		double x1, x2, diskriminant, i;
		cout << "Zadejte koeficienty a, b, c:";
		cin >> a;
		cin >> b;
		
		if(a == 0 && b == 0) {
			cout << "Nema reseni!";
			break;
		}
		cin >> c;
		if(a == 0) {
			x1 = -c/b;
			printf("Linearni rovnice: %.2f\n", x1);
			continue;
		}
		diskriminant = b * b - 4 * a * c;
		if(diskriminant > 0) {
			x1 = (-b + sqrt(diskriminant)) / (2 * a);
			x2 = (-b - sqrt(diskriminant)) / (2 * a);
			printf("Prvni koren: %.2f\nDruhy koren: %.2f\n", x1, x2);
		} else if(diskriminant == 0) {
			x1 = -(b) / (2 * a);
			printf("Koren: %.2f\n", x1);
		} else if(diskriminant < 0) {
			i = sqrt(-diskriminant) / (2 * a);
			x1 = -(b) / (2 * a);
			printf("Prvni koren: %.2f + %.2fi\n", x1, i);
			printf("Druhy koren: %.2f - %.2fi\n", x1, i);
		}

	}
}
