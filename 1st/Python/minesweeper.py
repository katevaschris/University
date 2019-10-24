#Author: Chris Katevas
#Pireaus 1/2019
#
#Game: minesweeper
#Give width, height and bombs
#Bombs in random location
#If cell got no bombs, take value from " " up to 8, all depends if there are bombs around this cell
from random import *
import random

#input height, width
flag=True
while(flag):
    w=int(input("Give width: "))
    if(w>0):
        flag=False
flag=True
while(flag):
    h=int(input("Give height: "))
    if(h>0):
        flag=False

#create the mine field    
f=[" "]
c=[0]
emp=[0]
for i in range(1,w*h):
    f.append(" ")
    emp.append(i)
    c.append(0)

#input bombs
flag=True
bombs=int(input("Give bomb's number: "))
while(flag):
    if(bombs<(len(f))):
        flag=False
    else:
        bombs=int(input("Your number is not validate!"))

#It's like Vietnam here...     
for i in range(bombs):
    j=random.choice(emp)
    f[j]="*"
    emp.remove(j)
#if cell is empty check for bombs
j=0
for i in range(h*w):
    if(f[i]==" "):
        c[i]=0
        #first raw first cell
        if(i==0):
            if(f[i+1]=="*"):
                c[i]=c[i]+1
            if(f[i+w]=="*"):
                c[i]=c[i]+1
            if(f[i+w+1]=="*"):
                c[i]=c[i]+1
        #first raw last cell
        elif(i==(w-1)):
            if(f[i-1]=="*"):
                c[i]=c[i]+1
            if(f[i+w]=="*"):
                c[i]=c[i]+1
            if(f[i+w-1]=="*"):
                c[i]=c[i]+1
        #first raw
        elif((i<(w-1))and(i>0)and(j==0)):
            if(f[i+1]=="*"):
                c[i]=c[i]+1
            if(f[i-1]=="*"):
                c[i]=c[i]+1
            if(f[i+w]=="*"):
                c[i]=c[i]+1
            if(f[i+w-1]=="*"):
                c[i]=c[i]+1
            if(f[i+w+1]=="*"):
                c[i]=c[i]+1
        #last raw first cell
        elif(i==((h-1)*w)):
            if(f[i+1]=="*"):
                c[i]=c[i]+1
            if(f[i-w]=="*"):
                c[i]=c[i]+1
            if(f[i-w+1]=="*"):
                c[i]=c[i]+1
        #last raw last cell
        elif(i==(h*w-1)):
            if(f[i-1]=="*"):
                c[i]=c[i]+1
            if(f[i-w]=="*"):
                c[i]=c[i]+1
            if(f[i-w-1]=="*"):
                c[i]=c[i]+1
        #last raw
        elif((j==h-1)and(i<(h*w-1))and(i>((h-1)*w))):
            if(f[i-1]=="*"):
                c[i]=c[i]+1
            if(f[i+1]=="*"):
                c[i]=c[i]+1
            if(f[i-w]=="*"):
                c[i]=c[i]+1
            if(f[i-w+1]=="*"):
                c[i]=c[i]+1
            if(f[i-w-1]=="*"):
                c[i]=c[i]+1
        #left column
        elif((j<h-1)and(j>0)and(i%w)==0):
            if(f[i+1]=="*"):
                c[i]=c[i]+1
            if(f[i+w]=="*"):
                c[i]=c[i]+1
            if(f[i+w+1]=="*"):
                c[i]=c[i]+1
            if(f[i-w+1]=="*"):
                c[i]=c[i]+1
            if(f[i-w]=="*"):
                c[i]=c[i]+1
        #right column
        elif((j<h-1)and(j>0)and((i+1)%w==0)):
            if(f[i-1]=="*"):
                c[i]=c[i]+1
            if(f[i+w]=="*"):
                c[i]=c[i]+1
            if(f[i+w-1]=="*"):
                c[i]=c[i]+1
            if(f[i-w-1]=="*"):
                c[i]=c[i]+1
            if(f[i-w]=="*"):
                c[i]=c[i]+1
        #everything else
        else:
            if(f[i+1]=="*"):
                c[i]=c[i]+1
            if(f[i-1]=="*"):
                c[i]=c[i]+1
            if(f[i+w]=="*"):
                c[i]=c[i]+1
            if(f[i+w+1]=="*"):
                c[i]=c[i]+1
            if(f[i+w-1]=="*"):
                c[i]=c[i]+1
            if(f[i-w]=="*"):
                c[i]=c[i]+1
            if(f[i-w+1]=="*"):
                c[i]=c[i]+1
            if(f[i-w-1]=="*"):
                c[i]=c[i]+1
    #change raw
    if((i+1)%w==0):
        j=j+1
for i in range(h*w):
    if(f[i]!="*"):
        #transfer int elements from list:"c" to list:"f"
        #c counts bombs
        f[i]=c[i]
     #if there are no bombs, go back to space!
    if(f[i]==0):
        f[i]=" "
#Final output
for i in range(h*w):
    if((i+1)%w!=0):
        #Print in one line
        print(" ",f[i],"|",end="");
    else:
        #Print last cell and change line
        print(" ",f[i],end="\n");       
