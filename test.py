def fun(nums):
	total = 0
	for i in nums:
		if i == 6:
			while i != 7:
				continue
		else:
			total += i
	return total

print(fun([2,3,4,6,5,4,3,7,8]))