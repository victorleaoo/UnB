#include <stdio.h>
#include <stdlib.h>

#define key(A) (A)
#define less(A,B) (key(A) < key(B))
#define exch(A,B) {int t=A; A=B; B=t;}
#define cmpexch(A,B) {if(less(B,A)) exch(A,B);}

int separa(int *v,int l, int r){
  int aux = v[r], i, j = l;

  for(i = l; i < r; i++){
    if(less(v[i], aux)){
      exch(v[i], v[j]);
      j++;
    }
  }    
  
  exch(v[j], v[r]);

  return j;
}

void quicksort(int *v,int l, int r){
  if (l >= r) return; // Critério de parada

  cmpexch(v[(l+r)/2], v[r]);
  cmpexch(v[l], v[(l+r)/2]);
  cmpexch(v[r], v[(l+r)/2]);

  int j = separa(v, l, r);
  quicksort(v, l, j-1);
  quicksort(v, j+1, r);
}

int main(void){
  int j, n;

  scanf("%d", &n);

  int *v = malloc(n * sizeof(int));

  for(int i = 0; i < n; i++){
    scanf("%d", &v[i]);
  }

  quicksort(v, 0, n-1);

  for(j = 0; j < n-1; j ++){
    printf("%d ", v[j]);
  }
        
  printf("%d\n", v[j]);

  free(v);

  return 0;
}