.data 	
X: .word 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
H: .word 0,1,2,3,4,5,6,7
Y: .word 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0

.text

main:
	daddi R1,R0,0 # j
	daddi R2,R2,0 # i

	daddi R4,R0,8 # m



	daddi R8,R0,X
	daddi R9,R0,H
	daddi R10,R0,Y

	Loop1:

		daddi R6,R0,0 # y0

		Loop2:
			lw R11,0(R8) # load X[] array's value
			lw R12,0(R9) # load H[] array's value
			dmul R11,R11,R12 # temp = X[] * H[]
			dadd R6,R6,R11 # y0 = y0 + temp

			daddi R8,R0,X #load X[] array  again

			daddi R2,R2,1 # i++

			daddi R9,R9,8 # next cell of H[] array

			#Next call of X[] array
			dadd R5,R2,R1 # temp = (i + j) 
			dsll R8,R5,3 # temp * 8


		bne R2,R4,Loop2
	

		sw R6,0(R10)
		daddi R10,R10,8 # next cell of Y[] array


		daddi R2,R0,0 # reset i (i = 0)
		daddi R9,R0,0 # load H[] array  again


		daddi R1,R1,1 # j++
	bne R1,R4,Loop1

halt
