import sys
input = sys.stdin.readline

N = int(input())
total = 0

lines = [tuple(map(int, input().split())) for _ in range(N)]
lines.sort()

cur_left, cur_right = lines[0]
for left, right in lines:
    if left <= cur_right:
        cur_right = max(right, cur_right)
    else:
        total += cur_right - cur_left
        cur_left, cur_right = left, right

total += cur_right - cur_left
print(total)