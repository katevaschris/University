#Author: Chris Katevas
#Pireaus 1/2019
#
#Python Function
#Input a list and a number
#Function returns the sum (list's elements) up until the upper limit (the givven number)

def maxDistance(dist, num):
    #length
    doesnotmatter=len(dist)
    # Sorry for the bubble sort
    for i in range(2, doesnotmatter, 1):
        for j in range(doesnotmatter-1, 0, -1):
            if (dist[j-1]>dist[j]):
                rev=dist[j]
                dist[j]=dist[j-1]
                dist[j-1]=rev
    #Main part
    #upper: List's elements added // couneter
    if(dist[0]<=num):
        upper=0
        counter=0
        while((upper<=num) and (counter<doesnotmatter)):
            upper=upper+dist[counter]
            counter=counter+1
            if(counter>=doesnotmatter):
                break
        #If upper is greater or eq than the givven number we need to go one element back
        if(upper>=num):
            print("Max",upper-dist[counter-1])
        else:
            print("Max",upper)
        
    else:
        print("You are out of range")





#in case you want to run as a separate program
#Rmove comments
#num=int(input("Give a number: "))
#while(num<=0.0):
    #num=int(input("Give a number: "))
#dist=[int(x) for x in input().split()]
#maxDistance(dist, num)
