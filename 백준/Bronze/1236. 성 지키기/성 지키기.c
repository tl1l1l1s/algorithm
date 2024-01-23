#include<stdio.h>

int main(void) {
    char castle[50][50] = {0, };
    int n, m;

    scanf("%d %d", &n, &m);

    for(int i=0; i<n; i++) {
        scanf("%s", castle[i]);
    }

    int row = n, column = m;

    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(castle[i][j]=='X') {
                row--;
                break;
            }
        }
    }


    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            if(castle[j][i]=='X') {
                column--;
                break;
            }
        }
    }

    if(n == 1) {
        printf("%d\n", column);
    } else if(m == 1) {
        printf("%d\n", row);
    } else {
        printf("%d\n", row>column ? row : column);
    }

    return 0;
}