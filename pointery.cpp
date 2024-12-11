#include <iostream>
using namespace std;

//vrací pomocí odkazu na ;int a; a ;int b; a prohozuje je pomocí & 
void prohod_a_tiskni(int &a, int &b){
    int tmp;
    tmp = a;
    a = b;
    b = tmp;
    
    //std::cout << "a = " << a << " b = " << b <<std::endl;
}

//vrací v indexech + 1 
void inkrementace(int a[]){
    for(int i = 0; i < 5; i++){
        a[i] += 1;
    }
}
//tiskne pole 
void tiskni_pole(int a[], int arrsize){
    for(int i = 0; i < arrsize; i++){
        cout << a[i] << " "; 
    }
}
//vytváří náhodné čísla v poli, srand vynuluje čas a pokáždé budou random čísla
void arr_round(int a[], int arrsize){
    srand(time(NULL));
    for(int i = 0; i < arrsize; i++){
        a[i] = rand() % 101;
    }
}

void arr_roundMatice(int a [][5], int arrsize){
    srand(time(NULL));
    for(int i = 0; i < arrsize; i++){
        for(int j = 0; j <arrsize; j++){
            a[i][j] = rand() % 101;
        }
    }
}

void tiskniMatici(int a [][5], int arrsize){
    srand(time(NULL));
    for(int i = 0; i < arrsize; i++){
        for(int j = 0; j <arrsize; j++){
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

int main()
{
    //práce s void prohod
    /*int a = 10;
    int b = 20;
    
    std::cout << "a = " << a << " b = " << b <<std::endl;
    prohod_a_tiskni(a, b);
    std::cout << "a = " << a << " b = " << b <<std::endl;*/
    
    //práce s polem
    /*int a[] = {1, 2, 3, 4, 5};
    inkrementace(a);
    tiskni_pole(a, 5);*/
    
    //práce s random
    /*int a[] = {1, 2, 3, 4, 5};
    arr_round(a, 5);
    tiskni_pole(a, 5);*/
    
    //práce s maticí
    int a[5][5];
    arr_roundMatice(a, 5);
    tiskniMatici(a, 5);
    
    
    return 0;
}

#include <iostream>
using namespace std;

void arr_round(int a[], int arrsize){
    for(int i = 0; i < arrsize; i++){
        a[i] = rand() % 101;
    }
}

void tiskni_pole(int a[], int arrsize){
    for(int i = 0; i < arrsize; i++){
        cout << a[i] << " "; 
    }
}

int main()
{
    int x;
    std::cout << "Zadej velikost pole" << std::endl;
    cin >> x;
    
    /*int* dynArray = new int[x];
    arr_round(dynArray, x);
    tiskni_pole(dynArray, x);*/
    
    //matice vytvořená poli
    srand(time(NULL));
    int* arr1 = new int[x];
    arr_round(arr1, x);
    int* arr2 = new int[x];
    arr_round(arr2, x);
    int* arr3 = new int[x];
    arr_round(arr3, x);
    int* arr4 = new int[x];
    arr_round(arr4, x);
    
    int* arrMatice[4];
    arrMatice[0] = arr1;
    arrMatice[1] = arr2;
    arrMatice[2] = arr3;
    arrMatice[3] = arr4;
    
    for(int i = 0; i < x; i++){
        for(int j = 0; j <x; j++){
            cout << arrMatice[i][j] << " ";
        }
        cout << endl;
    }
    

    return 0;
}

#include <iostream>
using namespace std;

int main()
{
    /*char arr[] = {'A', 'h', 'o', 'j'};
    
    // výpis pomocí ASCI
    for(int i = 0; i < 4; i++){
        cout << (int)arr[i] << " ";
    }
    //výpis přes char
    for(int i = 0; i < 4; i++){
        cout << arr[i];
    }*/
    
    //'\0'== ukončuje řetězec v ASCI
    //char arr[] = {'A', 'h', 'o', 'j', '\0', 'P'};
    //cout << arr;
    /*for(int i = 0; arr[i] != '\0'; i++){
        cout << arr[i];
    }*/
    
    //slučení dvou charů 
    /*char str[20] = "To be ";
    const char strconst[] = "or not to be.";
    
    for(int i = 0; i < 14; i++){
        str[i+6] = strconst[i];
    }
    
    cout << str;*/
    
    //porovnávání zda jsou stejné
    char str[] = "Aloj";
    char str2[] = "Ahoj";
    
    for(int i =0; str[i] != '\0'; i++){
        if(str[i] != str2[i]){
            cout << "Nejsou stejné." << endl;
            break;
        }
    }

    return 0;
}