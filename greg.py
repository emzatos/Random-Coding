
class Op:
	def __init__(self, arr):
		self.l = arr[0]-1
		self.r = arr[1]
		self.d = arr[2]


def apply(op, arr):
	for i in range(op.l, op.r):
		arr[i]+=op.d
	return arr



arr = [int(x) for x in input().split(' ')]
size = arr[0]
ops = arr[1]
queries = arr[2]
op_arr = []
times = {}
for i in range(ops):
	times[i] = 0

arr = [int(x) for x in input().split(' ')]

for i in range(ops):
	op_arr.append(Op([int(x) for x in input().split(' ')]))

for i in range(queries):
	l, r = [int(x) for x in input().split(' ')]
	for j in range(l-1, r):
		times[j]+=1

for i in range(ops):
	op_arr[i].d*=times[i]
	arr = apply(op_arr[i], arr)

print(' '.join(map(str, arr)))
