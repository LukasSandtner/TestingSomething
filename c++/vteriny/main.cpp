#include <stdio.h>
#include <iostream>

using namespace std;
int main()
{
	while(true) {
		cout << "Zadejte sekundy (0 pro konec): ";
		long celkoveSekundy;
		cin >> celkoveSekundy;
		if(celkoveSekundy == 0){
		    break;
		}
		int sekundyZaMinutu = 60;
		int sekundyZaHodinu = sekundyZaMinutu * 60;
		int sekundyZaDen = sekundyZaHodinu * 24;

		int dny = celkoveSekundy / sekundyZaDen;
		int zbyvajiciSekundy = celkoveSekundy % sekundyZaDen;

		int hodiny = zbyvajiciSekundy / sekundyZaHodinu;
		zbyvajiciSekundy %= sekundyZaHodinu;

		int minuty = zbyvajiciSekundy / sekundyZaMinutu;
		int secs = zbyvajiciSekundy % sekundyZaMinutu;

		cout << "Dny: " << dny << endl <<"Hodiny: " << hodiny << endl << "Minuty: " << minuty << endl << "Sekundy: " << secs << endl;


		cout << "Zadejte pocet sekund: ";
        int sekundy;
		cin >> sekundy;

		dny = 0, hodiny = 0, minuty = 0;

		while (sekundy >= sekundyZaDen) {
			sekundy -= sekundyZaDen;
			dny++;
		}

		while (sekundy >= sekundyZaHodinu) { 
			sekundy -= sekundyZaHodinu;
			hodiny++;
		}

		while (sekundy >= sekundyZaMinutu) {
			sekundy -= sekundyZaMinutu;
			minuty++;
		}

		cout << "Dny: " << dny << endl;
		cout << "Hodiny: " << hodiny << endl;
		cout << "Minuty: " << minuty << endl;
		cout << "Sekundy: " << sekundy << endl;

	}
}
