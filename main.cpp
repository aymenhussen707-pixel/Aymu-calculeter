#include <iostream>
using namespace std;

int main() {
    double a, b;
    char op;

    cout << "AYMU CALCULATOR\n";
    cout << "Enter: number operator number\n";

    cin >> a >> op >> b;

    switch (op) {
        case '+': cout << a + b; break;
        case '-': cout << a - b; break;
        case '*': cout << a * b; break;
        case '/':
            if (b != 0) cout << a / b;
            else cout << "Cannot divide by zero";
            break;
        default: cout << "Invalid operator";
    }

    return 0;
}
