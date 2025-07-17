def back_tracking(cur_chicken : list, idx, max_count):
    if len(cur_chicken) == max_count:
        return total_distance(cur_chicken)
    
    if idx >= len_chicken:
        return float('inf')
    
    min_val = float('inf')

    for i in range(idx, len_chicken):
        cur_chicken.append(chicken[i])
        min_val = min(min_val, back_tracking(cur_chicken, i + 1, max_count))
        cur_chicken.pop()
    return min_val

def total_distance(cur_chicken):
    total = 0
    for h in house:
        total += distance(h, cur_chicken)
    return total

def distance(h, chickens):
    result = float('inf')
    for chicken in chickens:
        result = min(result, abs(h[0] - chicken[0]) + abs(h[1] - chicken[1]))
    return result


N, M =map(int, input().split())
house = []
chicken = []

# 보드 초기화
for i in range(N):
    line = list(map(int, input().split()))
    for j in range(N):
        if line[j] == 1:
            house.append((i,j))
        elif line[j] == 2:
            chicken.append((i,j))

len_chicken = len(chicken)
min_value = back_tracking([],0, M)
print(min_value)