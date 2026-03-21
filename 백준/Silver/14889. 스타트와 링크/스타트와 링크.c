// 축구를 하기 위해 모인 사람 n(짝수)
// n/2명인 스타트팀, 링크팀
// 사람들은 1~n번까지, 능력치 배정
// 능력치 S(i, j) = i와 j 둘의 능력치 합
// 팀원이 i, j면 팀 능력치 = S(i, j) + S(j, i)
// 이 둘의 차이를 최소화하고자 함
#include<stdio.h>
#include<stdlib.h>
#include<stdint.h>

int pick(int n, int* picked, int* unpicked, int** power, int toPick) {
    // 스타트팀에 넣을 3명을 고름
    // 3명을 고른 후 나머지 3명은 자동으로 링크팀이 됨
    // 스타트팀의 합, 링크팀의 합 진행 후 더 작은 수를 리턴
    int i, lastIndex, smallest, tempRet, ret = INT32_MAX;
    
    if(toPick == 0) {
        int j = 0, k = 0, start = 0, link = 0;
        for(i=1; i<=n; i++) {
            if(picked[j]!=i) {
                unpicked[k]=i;
                k++;
            } else j++;
        }

        for(i=0; i<n/2; i++) {
            for(j=0; j<n/2; j++) {
                start += power[picked[i]][picked[j]];
            }
        }
        for(i=0; i<n/2; i++) {
            for(j=0; j<n/2; j++) {
                link += power[unpicked[i]][unpicked[j]];
            }
        }
        return (start > link ? start-link : link-start);
    }

    lastIndex = (n/2) - toPick - 1;
    if(toPick==n/2) {
        smallest = 1;
    } else {
        smallest = picked[lastIndex]+1;
    }

    for(i=smallest; i<=n; i++) {
        picked[lastIndex+1] = i;
        tempRet = pick(n, picked, unpicked, power, toPick-1);
        if(tempRet < ret) {
            ret = tempRet;
        }
    }
    return ret;
}

int main(void) {
    int n, i, j;
    int** power;
    int* picked, *unpicked;

    scanf("%d", &n);
    picked = (int*)malloc(sizeof(int)*n/2);
    unpicked = (int*)malloc(sizeof(int)*n/2);
    power = (int**)malloc(sizeof(int*)*n+1);
    for(i=0; i<=n; i++) {
        power[i] = (int*)malloc(sizeof(int)*n+1);
    }

    for(i=1; i<=n; i++) {
        for(j=1; j<=n; j++) {
            scanf("%d", &power[i][j]);
        }
    }

    picked[0] = 1;
    printf("%d", pick(n, picked, unpicked, power, n/2-1));
    free(picked);
    free(unpicked);
    for(i=0; i<=n; i++) {
        free(power[i]);
    }
    free(power);
    return 0;
}