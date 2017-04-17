def compress(n, xor):
	if len(n) == 1:
		return n[0]
	if not xor:
		x = []
		for i in range(0, len(n), 2):
			x.append(n[i] | n[i+1])
		return compress(x, not xor)
	else:
		x = []
		for i in range(0, len(n), 2):
			x.append(n[i] ^ n[i+1])
		return compress(x, not xor)

def change(i, x, arr):
	arr[i] = x
	return arr

nums, queries = [int(x) for x in input().split(' ')]
arr = [int(x) for x in input().split(' ')]

for i in range(queries):
	i, n = [int(x) for x in input().split(' ')]
	print(compress(change(i-1, n, arr), False))
