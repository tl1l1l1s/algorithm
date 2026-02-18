#include <stdio.h>

int main() {

    int H; // H m
    int W; // W m
    scanf("%d", &H);
    scanf("%d", &W);

    printf("%d\n", H > W ? (W * 50) : (H * 50));
    return 0;
}