#include<stdio.h>

int main() {
    int i, w, h, currentW, currentH, resultW, resultH, t;
    scanf("%d %d", &w, &h);
    scanf("%d %d", &currentW, &currentH);
    scanf("%d", &t);

    if(((currentW + t) / w)%2 == 0) {
        resultW = (currentW + t)%w;
    } else resultW = w - (currentW + t)%w;
    if(((currentH + t) / h)%2 == 0) {
        resultH = (currentH + t)%h;
    } else resultH = h - (currentH + t)%h;
    
    printf("%d %d", resultW, resultH);

    return 0;
}