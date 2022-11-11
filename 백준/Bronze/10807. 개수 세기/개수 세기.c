#include <stdio.h>

int main(){
  int n;
  int cnt[201] = {0};
  scanf("%d", &n);

  int num;
  for(int i = 0; i<n; i++){
    scanf("%d", &num);
    cnt[num+100] += 1;
  }

  int v;
  scanf("%d", &v);
  printf("%d\n", cnt[v+100]);

  return 0;
}