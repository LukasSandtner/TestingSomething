#include <iostream>

using namespace std;
int main()
{
	int f = 1;
	int e = 1;
	do {
		cout << "\nZADEJ FAKTORIAL (0 pro KONEC): ";
		cin >> f;
		cin >> e;
		if (f < 0 || e < 0) {
		    cout << ("\nNESMI BYT ZAPORNE");
		    continue;
		}else{
		   for(int i = f - 1; i >= 2; i--){
		        f *= i;
		    }   
		    cout << f;
		    
		    int fac2 = 1;
		    for(int j = 2; j <= e; j++){
		        fac2 *= j;
		    }
		    cout <<  endl << fac2;
		}
		
	    /*int a = f;
		while(f > 2) {
			f = f - 1;
			a = f * a;
		}*/
		

	} while (f != 0 && e != 0);
	cout << "\n-----" << "\nKONEC";

}
