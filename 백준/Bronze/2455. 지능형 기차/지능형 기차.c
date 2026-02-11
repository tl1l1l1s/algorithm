#include <stdio.h>

int main() {
    int mi, pl;
    int temp = 0;
    int res = 0;
    
    for(int i=0; i<4; i++) {
        scanf("%d %d", &mi, &pl);

        temp -= mi;
        temp += pl;
        if(res < temp) res = temp;
    }
    
    printf("%d\n", res);
    return 0;
}