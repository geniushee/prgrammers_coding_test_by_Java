import sys

input = sys.stdin.readline
text = input().strip()
if text[0] not in "+-":
    text = "+" + text
    
flag = True
result = []
temp = ""
op = "+"
count = 0
for i in range(len(text)):
    if flag and text[i] in "+-":
        op = text[i]
        flag = False

    elif not flag and text[i] in "+-":
        count += 1
        temp = int(temp) // (count)
        if temp == 1:
            result.append( op + (count * "x"))
        else:
            result.append( op +str(temp)+(count * "x"))
        temp = ""
        count = 0
        op = text[i]
        flag = True

    elif text[i] == 'x':
        count += 1
            
    else:
        temp += text[i]

count += 1
temp = int(temp) // (count)

if len(result) == 0 and temp == 0:
        print("W")
else:
    if temp == 1:
        result.append( op + (count * "x"))
    else:
        result.append( op +str(temp)+(count * "x"))
        
    result.append("+W")
    answer =  "".join(result)
    if answer[0] == "+":
        answer = answer[1:]
    print(answer)