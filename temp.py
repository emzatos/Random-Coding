file = open("temp.txt", "r")
out = open("Friends.txt", "w")

for line in file:
	temp = line.split(" ")[0] + "\n"
	out.write(temp)
