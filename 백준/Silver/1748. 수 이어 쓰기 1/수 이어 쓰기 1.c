#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int a = 1;
int b = 0;
int L(long long n) {
	int len = 1;

	if (n / 10 == 0)
		return len;
	else {
		while (n / 10 != 0) {
			n = n / 10;
			len++;
			a = a * 10;
			b = b * 10 + 9;
		}

		return len;
	}
}
int main(void) 
{
	long long n;
	int result = 0, len;

	scanf("%lld", &n);

	len = L(n);
	//printf("%d %d %d\n", len, a, b);
	for (int i = len;i > 0;i--) {
		if (i == len) {
			result += (n - a + 1) * i;
			//printf("%d %d %d %d\n", i, a, b, result);
		}
		else {
			a /= 10;
			result += (b - a + 1) * i;
			//printf("%d %d %d %d\n", i, a, b, result);
			b /= 10;
		}
	}

	printf("%d", result);
	return 0;
}