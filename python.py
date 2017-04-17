
import math


prev=0
for i in range(10):
	x = math.sin(i)
	print abs(x-prev)
	prev = x



