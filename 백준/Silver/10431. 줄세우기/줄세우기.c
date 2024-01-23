#include<stdio.h>
// 항상 20명
// 맨 앞에 세우고, 그 뒤에 한 명씩 선다
// 자기보다 큰 학생이 있으면 그 중 제일 앞쪽에 있는 애 앞에 섬
// 애들이 총 몇 번 뒤로 움직이는가? == 자리에 서는 건 카운트x
//                          == 움직이는 한 명당 한 발자국으로 카운트를 함

int main() {
    int p, t, sum, temp;
    int nums[21] = {0, };

    scanf("%d", &p);
    while(p-->0) {
        sum = 0;
        scanf("%d", &t);

        for(int i=0; i<20; i++) {
            scanf("%d", &nums[i]);
        }

        for(int i=1; i<20; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i]<nums[j]) {
                    sum++;
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        printf("%d %d\n", t, sum);
    }
    return 0;
}