"""original matrix can be written as product of upper and lower matrix"""

print("Enter a 3*3 matrix")
matrix = []

for i in range(3):
	a = []
	for j in range(3):
		a.append(int(input()))
	matrix.append(a)

for i in range(3):
	for j in range(3):
		print(matrix[i][j], end = " ")
	print()

print()
	
l_21 = matrix[1][0] / matrix[0][0]
l_31 = matrix[2][0] / matrix[0][0]

for i in range(3):
	matrix[1][i] = matrix[1][i] - (matrix[0][i] * l_21)
	matrix[2][i] = matrix[2][i] - (matrix[0][i] * l_31)

l_32 = matrix[2][1] / matrix[1][1]

for i in range(3):
	matrix[2][i] = matrix[2][i] - (matrix[1][i] * l_32)

print("Upper matrix(U)")
print()
for i in range(3):
	for j in range(3):
		print(matrix[i][j], end = " ")
	print()

for i in range(3):
	for j in range(3):
		if(i == j):
			matrix[i][j] = 1
		
		elif(j > i):
			matrix[i][j] = 0
		
		elif(i == 1 and j == 0):
			matrix[i][j] = l_21
		
		elif(i == 2 and j == 0):
			matrix[i][j] = l_31
		
		elif(i == 2 and j == 1):
			matrix[i][j] = l_32

print()
print("Lower matrix(l)")
print()
for i in range(3):
	for j in range(3):
		print(matrix[i][j], end = " ")
	print()
