times = int(input())
a = set()

for i in range(times):
    name = input().split()[0]

    if name in a:
        a.remove(name)
    else:
        a.add(name)
a = sorted(a, reverse=True)
for i in a:
    print(i)
