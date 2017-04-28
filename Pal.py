size = int(input())

string = input()

def check_pal(n):
	if n == n[::-1]:
		return False
	n = list(n)
	for i in range(len(n)//2):
		if n[i] == n[-i-1]:
			n[i] = ""
			n[-i-1] = ""
		else:
			pass
	n = "".join(n)
	if len(n) == 2 or len(n) == 3:
		return True
	else:
		return False

count = 0
offset = 2
strs = []
while offset < size:
	for i in range(len(string)):

		if i+offset > len(string):
			break


		if check_pal(string[i:i+offset]) and string[i:i+offset] not in strs:
			strs.append(string[i:i+offset])
			count+=1
		else:
			pass
	offset+=1
if check_pal(string):
	count+=1
print(count)

