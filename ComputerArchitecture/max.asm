.data 	
X: .word 1, 1, 1, 2, 2, 3, 4, 2, 1, 1, 2, 3, 2, 4, 8, 1, 1, 1, 1, 2, 2, 3, 4, 2, 1, 1, 2, 3, 2, 4, 8, 1
useless0: .word 0
useless1: .word 0
useless2: .word 0
useless3: .word 0
useless4: .word 0
n: .word 24
useless5: .word 0
useless6: .word 0
useless7: .word 0
Y: .word 0, 1, 2, 3, 4, 5, 6, 7, 8
useless8: .word 0
useless9: .word 0
useless10: .word 0
m: .word 8
useless11: .word 0
useless12: .word 0
H: .word 1, 5, 1, 4, 2, 1, 1, 1, 1, 5, 1, 4, 2, 1, 1, 1, 1, 5, 1, 4, 2, 1, 1, 1




.text
main:
	addi $t0,$zero,0 #j
	addi $t1,$zero,0 #i
	lw $s0,m($t0)
	lw $s1,n($t0)
	
	
	#lw $s3,X($t0)
	#lw $s4,H($t0)
	addi $t7,$zero,0
	Loop1:
		addi $t3,$zero,0
		addi $t6,$zero,0
		Loop2:
			add $t5,$t0,$t1 # i + j
			sll $t5,$t5,2
			lw $s3,X($t5)
			lw $s4,H($t3)
			mul $t5,$s3,$s4
			add $t6,$t6,$t5
			
			
			addi $t3,$t3,4
			addi $t1,$t1,1 
		bne $t1,$s1,Loop2
		sw $t6,Y($t7)
		addi $t7,$t7,4
		addi $t1,$zero,0 # reset i
		
		addi $t0,$t0,1 
	bne $t0,$s0,Loop1
	
	
	addi $t0,$zero,0 #j
	addi $t1,$zero,0 #j
	Loop3:
		lw $s5,Y($t1)
		addi $t1,$t1,4
	
		#Printing results
		li $v0, 1
		move $a0, $s5
		syscall
		
		
		addi $t0,$t0,1
	bne $t0,$s0,Loop3
	

