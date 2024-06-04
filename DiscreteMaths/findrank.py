'''
    Main purpose: Find rank of a given (string)/ number
'''
#Functions

#Find factorial
def factorial(n) : 
    f = 1
    while (n >= 1): 
        f = f * n 
        n = n - 1
    return f 

#Find the next smallest element (from current element up to the list's bounds)
def fsmall(num, low, upper) : 
    counter = 0
    i = low + 1
    while(i <= upper):
        #convert string elements back to integers(so that if can works properly) 
        a = int(num[i])
        b = int(num[low])
        if(a < b): 
            counter +=1
        i += 1
    return counter 

#Find Rank
def Rank (num) : 
    length = len(num) 
    #Possible ranks
    r = factorial(length) 
    #current rank every time
    rank = 1
    i = 0 
    while(i < length):
        #How many digits up until the end       
        r = r / (length - i)
        counter = fsmall(num, i, length-1)
        #current rank plus (nextposition times transfer)
        rank = rank + counter * r 
        i += 1
    return rank

#Main program
num = raw_input("Enter Numbers: ").split()
print (Rank(num))
