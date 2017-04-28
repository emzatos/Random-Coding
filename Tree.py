trees = int(input())

for i in range(trees):
	vertices, edges = [int(x) for x in input().split(' ')]
	nums = []
	for i in range(vertices):
		nums.append(i+1)

	for i in range(edges):
		x, y = [int(x) for x in input().split(' ')]
		if x in nums:
			nums.remove(x)
		if y in nums:
			nums.remove(y)

	if len(nums) > 0:
		print("NO")
	else:
		print("YES")