perms = int(input())

words = []
for i in range(perms):
	words.append(input())


pw = ""
for i in words:
	temp = words
	temp.remove(i)
	pw+=i
	for j in temp:
		if j[0:2] == i[1:]:

		""" 
	look at the values that arent mine
	compare the last two values, if they 'match' then build the word, keep going. if not then try again

		"""