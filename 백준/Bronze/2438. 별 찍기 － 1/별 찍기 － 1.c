#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    char *stars = "****************************************************************************************************";
    for(int i=1; i<=n; i++) {
        printf("%.*s\n", i, stars);
    }
    return 0;
}