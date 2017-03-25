boys = open("Boys.txt", "r")
girls = open("Girls.txt", "r")
friends = open("Friends.txt", "r")

bset = []
gset = []
guys = []
gals = []
unname  = []
count = 0
for line in boys:
	bset.append(line.strip("\n"))

for line in girls:
	gset.append(line.strip("\n"))

for line in friends:
	z = True
	count += 1
	if line.strip("\n") in bset:
		guys.append(line.strip("\n"))
		z = False

	if line.strip("\n") in gset:
		gals.append(line.strip("\n"))
		z = False

	if z == True:
		unname.append(line.strip("\n"))

correction = (len(guys)+len(gals)+len(unname) - count)//2
len_guys = len(guys) - correction
len_gals = len(gals) - correction

print("Total:", count)
print("Male:", len_guys)
print("Female:", len_gals)
print("Unmatched:", len(unname))
print("Matched percentage: " + str(round(((len_guys+len_gals)/count)*100)) + "%")
print("Male percentage: " + str(round((len_guys/(len_guys+len_gals))*100)) + "%")
print("Female percentage: " + str(round((len_gals/(len_guys+len_gals))*100)) + "%")
print(sorted(unname))
