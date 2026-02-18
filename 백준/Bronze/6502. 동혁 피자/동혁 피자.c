#include <stdio.h>
#include <math.h>

int main() {

    int n = 1;
    int r;

    while (scanf("%d", &r) == 1 && r != 0) {
        int w; int l;
        scanf("%d %d", &w, &l);

        long long ww = 1LL*w*w, ll = 1LL*l*l;
        if(sqrt(ww + ll) <= r*2) {
            printf("Pizza %d fits on the table.\n", n);
        } else {
            printf("Pizza %d does not fit on the table.\n", n);
        }

        n++;
    }
    return 0;
}