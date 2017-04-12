from math import gcd

def gcd_list(n, l, r):
	total = n[l-1]
	for i in range(l-1, r):
		total = gcd(n[i], total)
	return total



cases = int(input())

for i in range(cases):
	temp = [int(x) for x in input().split(' ')]
	nums = temp[0]
	commands = temp[1]
	nums = [int(x) for x in input().split(' ')]

	for _ in range(commands):
		inp = [int(x) for x in input().split(' ')]
		
		if inp[0] == 1:
			nums[inp[1]-1] = inp[2]
		else:
			print(gcd_list(nums, inp[1], inp[2]), end=' ')

