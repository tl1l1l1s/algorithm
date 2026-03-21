#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int count;
void pick(int* list, int listSize, int* bucket, int bucketSize, int k) 
{
	int num;

	if (k == 0) {
		num = bucketSize;
		for (int i = 0; i < bucketSize; i++)
			num -= bucket[i];

		if (num == 0){
			//for (int i = 0; i < bucketSize; i++)
				//printf("%d ", bucket[i]);
			//printf("\n");
			count++;
		}
		return 0;
	}

	int lastIndex = bucketSize - k - 1;
	int item;

	for (int item = 0; item < listSize; item++) {
		num = bucketSize;
		for (int j = 0; j <= lastIndex; j++)
			num -= bucket[j];

		if (num == 0){
			//for (int i = 0; i <= lastIndex; i++)
				//printf("%d ", bucket[i]);
			//printf("\n");
			count++;
			break;
		} else {
			bucket[lastIndex + 1] = list[item];
			pick(list, listSize, bucket, bucketSize, k - 1);
		}
	}
}
int main(void)
{
	int list[] = { 1, 2, 3 };
	int A, num, i;
	int* bucket;

	scanf("%d", &A);

	for (i = 0;i < A;i++) {
		count = 0;
		scanf("%d", &num);

		bucket = (int*)malloc(sizeof(int) * num);

		pick(list, 3, bucket, num, num);

		printf("%d\n", count);

		free(bucket);
	}

	return 0;
}