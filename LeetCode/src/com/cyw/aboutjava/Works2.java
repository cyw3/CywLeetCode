package com.cyw.aboutjava;

/**
#include <iostream>
#include <stdio.h>
#include <string.h>
using namespace std;
typedef long long int LL;
const int N=100005;
struct node{
    int next[2];
}tree[N*41];
int tot;
LL a[N];
LL max(LL a,LL b){ return a>b?a:b; }
void init(int x){
    tree[x].next[0]=-1; tree[x].next[1]=-1;
}
void insert(LL x){
    int i,u=0,id;
    for(i=40; i>=0; i--){
        if( (x&((1LL)<<i) )>0 ) id=1;
        else id=0;
        if(tree[u].next[id]==-1){
            init(tot);
            tree[u].next[id]=tot++;
        }
        u=tree[u].next[id];
    }
}
LL find(LL x){
    int i,u=0,id;
    LL res=0;
    for(i=40; i>=0; i--){
        if( x&((1LL)<<i) ) id=0;
        else id=1;
        if(tree[u].next[id]==-1) id^=1;
        res=res*2+id;
        u=tree[u].next[id];
    }
    return res;
}
int main()
{
    int n,i;
    while(scanf("%d",&n)!=EOF){
        LL cur=0;
        for(i=0; i<n; i++){
            scanf("%lld",&a[i]);
            cur^=a[i];
        }
        init(0);
        tot=1;
        LL ins=0,ans=0;
        insert(0LL);
        for(i=0; i<n; i++){
            ins^=a[i]; cur^=a[i];
            insert(ins);
            ans=max(ans,find(cur)^cur);
        }
        cout<<ans<<endl;
    }
}
 * @author cyw
 *
 */
public class Works2 {

	public static void main(String [] args){
		System.out.println(3^3);
	}
}
