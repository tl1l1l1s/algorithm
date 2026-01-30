#include <stdio.h>

int main() {

    // 3개의 자연수 x, y, z
    // a.z+b.x , a.y*b.y, a.x+b.z

    // a(cake)b = c

    int ax, ay, az;
    int cx, cy, cz;
    scanf("%d %d %d", &ax, &ay, &az);
    scanf("%d %d %d", &cx, &cy, &cz);

    printf("%d %d %d\n", (cx - az), (cy / ay), (cz - ax));
    return 0;
}