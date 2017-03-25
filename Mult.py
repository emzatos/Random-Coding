nums = [int(x) for x in input().split(" ")]

total = []

for i in range(1, nums[0]+1):
	for j in range(1, nums[1]+1):
		total.append(i*j)

print(sorted(total))
print(sorted(total)[nums[2]-1])