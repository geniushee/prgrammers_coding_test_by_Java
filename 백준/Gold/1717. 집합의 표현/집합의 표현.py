N, M = map(int, input().split())
parents = []
for i in range(N+1):
    parents.append(i)
    
def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
    return parents[x]
#합치기
def union(x,y):
    sx = find(x)
    sy = find(y)
    if sx == sy:
        return 
    elif sx < sy:
        parents[sx] = sy
    else:
        parents[sy] = sx

    # 동일한 집합인가?
def equal_set(x, y):
    if find(x) == find(y):
        print("yes")
    else:
        print("no")

for _ in range(M):
    a, b, c = map(int, input().split())
    if a == 0:
        union(b,c)
    else:
        equal_set(b,c)