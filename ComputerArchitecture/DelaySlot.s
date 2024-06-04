.data 	
X: .word 1,1,1,2,2,3,4,2,1,1,2,3,2,4,8,1
H: .word 1,5,1,4,2,1,1,1
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
			#Next call of X[] array
			dadd R5,R2,R1 # temp = (i + j) 
			dsll R8,R5,3 # temp * 8



			lw R11,0(R8) # load X[] array's value
			lw R12,0(R9) # load H[] array's value
			dmul R11,R11,R12 # temp = X[] * H[]
			dadd R6,R6,R11 # y0 = y0 + temp

			

			daddi R2,R2,1 # i++

			

			
			

		bne R2,R4,Loop2
		#Delay Slot form A
		daddi R9,R9,8 # next cell of H[] array

	
		sw R6,0(R10)
		daddi R10,R10,8 # next cell of Y[] array

		daddi R9,R0,H # load H[] array  again


		daddi R1,R1,1 # j++
	bne R1,R4,Loop1
	
	#Scond Delay slot
	daddi R2,R0,0 # reset i (i = 0)

halt