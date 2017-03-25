from bisect import *
cases = int(input())

for i in range(cases):
	rocks = int(input())
	r = sorted([int(x) for x in input().split(" ")])
	b = [int(x) for x in input().split(" ")]

	total = 0
	for j in b:
		if j > r[-1]:
			total += r[0]
			r.pop(0)
		else:
			r.pop(bisect_left(r, j))
	print(total)

