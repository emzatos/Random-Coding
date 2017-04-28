cases = int(input())
for i in range(cases):
	a, b = [int(x) for x in input().split(' ')]
	c, d = [int(x) for x in input().split(' ')]

	if (a+c == b and b==d) or (b+d == a and a==c):
		print("YES")
	else:
		print("NO")