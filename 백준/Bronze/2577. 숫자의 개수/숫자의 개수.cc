#include<stdio.h>

int main(void) {
    int a, b, c, num;
    int array[10] = {0, };

    scanf("%d", &a);
    scanf("%d", &b);
    scanf("%d", &c);
    num = a*b*c;

    do
    {
        array[num%10]++;
        num /= 10;
    } while (num != 0);
    

    for(int i=0; i<10; i++) {
        printf("%d\n", array[i]);
    }

    return 0;
}