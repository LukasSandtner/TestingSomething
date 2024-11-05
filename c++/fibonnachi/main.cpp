#include <iostream>

using namespace std;
int main()
{   
    int length;
    do {  
        int counter = 0;
        cout << "\nPočet prvků (0 pro konec): ";
        cin >> length;
        int a = 0;
        int b = 1;
        while(counter < length) {
            int c = a + b;
            cout << "\t" << c;
            a = b;
            b = c;
            counter++;
            
        }
        
        cout << endl;
        int x = 0;
        int y = 1;
        for (int i = 0; i < length; i++) {
            int z =  x  + y;
            cout << "\t" << y;
            x = y;
            y = z;
        }
        
        cout <<endl;
        int pole[length];
        pole[0] = 0;
        pole[1] = 1;
        for (int i = 2; i < length; i++) {
            pole[i] = pole[i - 2] + pole[i - 1];
        }
        for(int prvek = length-1; prvek >= 0; prvek--){
            cout << "\t" << pole[prvek];
        }
    } while (length != 0);
}
