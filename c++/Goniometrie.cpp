#include <iostream>

using namespace std;

// Funkce pro výpočet sinu pomocí Taylorovy řady
double calculateSine(double x, int terms) {
    double sin_x = x;    // Začínáme s prvním členem (x)
    double term = x;     // Inicializace prvního členu řady
    int sign = -1;       // Znaménko pro střídání členů (-1 pro záporné, 1 pro kladné)

    for (int i = 1; i < terms; i++) {
        term *= x * x / ((2 * i) * (2 * i + 1)); // Iterativní výpočet dalšího členu
        sin_x += sign * term;                   // Přičteme člen se správným znaménkem
        sign *= -1;                             // Změníme znaménko
    }

    return sin_x;
}

// Funkce pro výpočet kosinu pomocí Taylorovy řady
double calculateCosine(double x, int terms) {
    double cos_x = 1;    // Začínáme s prvním členem (1)
    double term = 1;     // Inicializace prvního členu řady
    int sign = -1;       // Znaménko pro střídání členů (-1 pro záporné, 1 pro kladné)

    for (int i = 1; i < terms; i++) {
        term *= x * x / ((2 * i - 1) * (2 * i)); // Iterativní výpočet dalšího členu
        cos_x += sign * term;                   // Přičteme člen se správným znaménkem
        sign *= -1;                             // Změníme znaménko
    }

    return cos_x;
}

// Hlavní metoda pro vstup uživatele
int main() {
    double x;
    int terms;

    cout << "Zadejte úhel v radiánech: ";
    cin >> x;

    cout << "Zadejte počet členů Taylorovy řady: ";
    cin >> terms;

    double sineResult = calculateSine(x, terms);   // Výpočet sinu
    double cosineResult = calculateCosine(x, terms); // Výpočet kosinu

    cout << "Sinus (" << x << ") = " << sineResult << endl;
    cout << "Cosinus (" << x << ") = " << cosineResult << endl;

    return 0;
}


