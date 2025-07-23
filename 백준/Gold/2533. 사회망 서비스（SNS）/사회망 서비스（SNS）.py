import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
from collections import defaultdict

def dfs(node, parent, graph, dp):
    dp[node][0] = 1
    dp[node][1] = 0
    
    for next_node in graph[node]:
        if next_node == parent:
            continue
        dfs(next_node, node, graph, dp)
        dp[node][0] += min(dp[next_node][0], dp[next_node][1])
        dp[node][1] += dp[next_node][0]


N = int(input())
graph = defaultdict(list)
dp = []
for _ in range(N+1):
    dp.append([0,0])
for _ in range(N -1):
    u,v = map(int, input().split())
    graph[v].append(u)
    graph[u].append(v)
    
dfs(1,0, graph, dp)
print(min(dp[1]))


