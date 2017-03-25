import random

cases = 523
print(cases)

for i in range(cases):
	coeff = random.randint(0,10**4)
	goal = random.randint(10**17,10**18)
	print(coeff, goal)
	for i in range(coeff+1):
		print(random.randint(0,10**4), end=" ")

	print()

