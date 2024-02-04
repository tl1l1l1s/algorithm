times = int(input())

for i in range(times):
    room = 0
    h, w, n = map(int, input().split())
    floor = n % h
    room = n // h + 1

    if n % h == 0:
        floor = h
        room = room - 1
    print(floor*100 + room)
