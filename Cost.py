

# def firstThing(airport, index):
# 	delta_right = 1
# 	found_right = False
# 	delta_left = 1
# 	found_left = False

# 	while(index + delta_right < len(airport)):
# 		if airport[index + delta_right] != airport[index]:
# 			found_right = True
# 			break
# 		delta_right+=1

# 	if not found_right:
# 		delta_right = 9999999999

# 	while(index - delta_left >= 0):
# 		if airport[index - delta_left] != airport[index]:
# 			found_left = True
# 			break
# 		delta_left+=1

# 	if not found_left:
# 		delta_left = 9999999999

# 	return min(delta_right, delta_left)

# def analyze(airport, start, end):
# 	if airport[start] == airport[end]:
# 		return 0
# 	else:
# 		return min(firstThing(airport, start), firstThing(airport, end))

nums = [int(x) for x in input().split(" ")]
size = nums[0]
start = nums[1]-1
end = nums[2]-1
airport = input()

# print(analyze(input(), start, end))

result = 0 if airport[start] == airport[end] else 1
print(result)
































