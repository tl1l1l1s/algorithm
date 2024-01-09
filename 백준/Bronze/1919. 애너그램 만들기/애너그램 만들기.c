#include<stdio.h>
#include<string.h>
// ascii a 97

int main() {
    char a[1001] = {};
    char b[1001] = {};
    
    // 아무 위치나 제거 가능
    // 그러면 같은 건 빼고 남은 것만 제거해야함
    // 그러면 1157번 풀었던 것처럼 알파벳만 떼어서?

    int aNum[26] = {0, };
    int bNum[26] = {0, };
    int diff = 0;

    scanf("%s", a);
    scanf("%s", b);
    for(int i=0; i<=strlen(a); i++) {
        aNum[a[i]-'a']++;
    }
    
    for(int i=0; i<=strlen(b); i++) {
        bNum[b[i]-'a']++;
    }
    // 알파벳 개수만 떼어서 배열에 입력
    // 이제 각자 다른 부분만 빼면 됨
    // 예시 1번 abcde edbax
    // a1b1c1d1e1 a1b1d1e1x1
    // abde > 2
    // 예시 2번 aabbcx zdkaob
    // a2b2c1x1 a1b1d1o1k1z1
    // ab > 8

    for(int i=0; i<26; i++) {
        if(aNum[i] != bNum[i]) {
            if(aNum[i] > bNum[i]) diff += aNum[i]-bNum[i];
            else diff += bNum[i]-aNum[i];
        }
    }

    printf("%d", diff);
    return 0;
}