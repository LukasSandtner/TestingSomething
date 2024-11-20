/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>
#include <stdlib.h>
using namespace std;

int main()
{
    int count = 17;
    int pole[] = {2, 9, 10, 5, 5, 2, 7, 6, 111, 0, 525, 0, 0, 0, 0, 3, 0};
    
    cout << "Pole" << endl;
    for (int prvky : pole) {
        cout << prvky << " ";
    }
    
    cout << endl << "Pole pozpatku" << endl;
    for (int i = 0; i < count/2; i++) {
        int tmp = pole[i];
        pole[i] = pole[count - 1 - i];
        pole[count - 1 - i] = tmp;
    }
    
        for (int prvky : pole) {
        cout << prvky << " ";
    }
    
    /*bool serazeno;
    for (int i = 0; i < count - 1; i++) {
        serazeno = false;
        for (int j = 0; j < count - 1 - i; j++) {
            if(pole[j] > pole[j + 1]) {
                int tmp = pole[j];
                pole[j] = pole[j + 1];
                pole[j + 1] = tmp;
                serazeno = true;
            }
        }
        if(!serazeno) {
            break;
        }
    }
    cout << endl << "Bubble sort: " << endl;
    for (int prvky : pole) {
        cout << prvky << " ";
    }*/
    
    for (int i = 1; i < count; ++i) {
        int min = pole[i];
        int j = i - 1;
        for (j = i - 1; j >= 0 && pole[j] >= min; j--) {
            pole[j + 1] = pole[j];
        }
        pole[j + 1] = min;
    }
    
    cout << endl << "Insertion sort: " << endl;
    for (int prvky : pole) {
        cout << prvky << " ";
    }
    
    cout << endl << "Odstraneni duplicit" << endl;
    int n = 0;
    for (int i = 1; i < count - n; i++) {
        if(pole[i - 1] == pole[i]) {
            for (int j = i - 1; j < count; j++) {
                pole[j] = pole[j + 1];
            }
            //pole[count - 1] = 0;
            n++;
        }
    } 
    
    for (int i = 0; i < count - n; i++) {
        cout << pole[i] << " ";
    }
}