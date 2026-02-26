#include <stdio.h>

int main() {

    int n;
    scanf("%d", &n);

    if(n < 425) {
        printf("Violet");
    } else if(n < 450) {
        printf("Indigo");
    } else if(n < 495) {
        printf("Blue");
    } else if(n < 570) {
        printf("Green");
    } else if(n < 590) {
        printf("Yellow");
    } else if(n < 620) {
        printf("Orange");
    } else if(n <= 780) {
        printf("Red");
    }
    
    return 0;
}