_start:
	la $a0, input
	lw $t1, 0($a0)
	li $t0 0xFC0001FF    #4 8421   1010

	ror $t2, $t1, 9

	srl $t2, $t2, 17

	ror $t2, $t2, 6

#	and $t2, $t1, $t0

	li$v0, 10
	syscall

	.data
input:    .word 0xFFFFFFFF