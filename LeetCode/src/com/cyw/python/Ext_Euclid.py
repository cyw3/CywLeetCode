#扩展欧几里得算法，即辗转相除法
#ax+by=gcb(a, b)
#返回：x,y, gcb(a, b)
#gcb(a, b) ，要不是1，要不是a
def Ext_Euclid ( a , b ):
    if (b == 0):
        return 1 , 0 , a
    else:
        x , y , q=Ext_Euclid( b , a % b )
        x , y = y,( x - (a // b) * y )
        print(q)
        return x , y , q
    
a = Ext_Euclid(47,30)