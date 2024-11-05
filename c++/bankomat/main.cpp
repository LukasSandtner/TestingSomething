#include <iostream>

using namespace std;

int main()
{
    int senzor, pin, castka;
    while(true){
        cout << "Vložte kartu" << endl << "************" << endl << "Vložena? ANO-1 || NE-0: ";
        cin >> senzor;
    
        if(senzor == 1) {
            while(true){
            cout << "Zadejte PIN: ";
            cin >> pin;
            if(pin == 1234){
                cout << "Zadejte částku: ";
                cin >> castka;
                printf("Částka %i vyplacena", castka);
                cout << "\nKonec\n";
                break;
            }else{
                cout << "Chybný PIN!\n";
                continue;
            }
            }
        } else {
            cout << "Konec";
            break;
        }
    }
}
