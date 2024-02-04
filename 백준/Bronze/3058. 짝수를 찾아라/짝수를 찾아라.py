times = int(input())

for k in range(times):
    sumNums = 0
    minEven = 100
    nums = list(map(int, input().split()))

    for i in range(0, 7):
        if nums[i] % 2 == 0:
            sumNums += nums[i]
            if nums[i] < minEven:
                minEven = nums[i]
    print(sumNums, minEven)

