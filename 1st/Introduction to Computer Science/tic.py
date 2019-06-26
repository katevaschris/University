#Author: Chris Katevas
#Pireaus 1/2019
#
#Game: Tic Tac Toe
#Choose your symbol X or 0(zero)
#Give cordinates from 0 up to 8
#Computer's move is a random choice
import random
from random import randint

def dandd(f):
    for i in range(0,9,3):
        print(f[i],"|",f[i+1],"|",f[i+2])
    print("__________")


#skyrim=search for strike function        
def skyrim(f,ashen):
    if((f[0]==f[1])and(f[0]==f[2])and(f[0]==ashen)):
        skyrim=True
    elif((f[3]==f[4])and(f[3]==f[5])and(f[3]==ashen)):
        skyrim=True
    elif((f[6]==f[7])and(f[6]==f[8])and(f[6]==ashen)):
        skyrim=True
    elif((f[0]==f[3])and(f[0]==f[6])and(f[0]==ashen)):
        skyrim=True
    elif((f[1]==f[4])and(f[1]==f[7])and(f[1]==ashen)):
        skyrim=True
    elif((f[2]==f[5])and(f[2]==f[8])and(f[2]==ashen)):
        skyrim=True
    elif((f[0]==f[4])and(f[0]==f[8])and(f[0]==ashen)):
        skyrim=True
    elif((f[2]==f[4])and(f[2]==f[6])and(f[2]==ashen)):
        skyrim=True
    else:
        skyrim=False
    return skyrim

f=[" "," "," "," "," "," "," "," "," "]
#Symmbols
flag=True
while(flag):
    ashen1=input("Choose X or 0: ")
    if(ashen1=="X"):
        ashen2="0"
        flag=False
    elif(ashen1=="0"):
        ashen2="X"
        flag=False
    else:
        print("Do not f*ck with us.")
flag=True
print("Give cordinates from 0 up to 8")
round=0
while((flag)and(round<9)):
    cor=int(input("Give cordinates ashenone: "))
    if(f[cor]==" "):
        f[cor]=ashen1
        round=round+1
        dandd(f)
        if(skyrim(f,ashen1)):
            print("Ride and Shine mr")
            flag=False
            dandd(f)
        else:
            flag=True
            while(flag):
                cor=randint(0,8)
                if(f[cor]==" "):
                    print("Give cordinates Hal 9000: ",cor)
                    f[cor]=ashen2
                    round=round+1
                    flag=False
                    dandd(f)
            flag=True
            if(skyrim(f,ashen2)):
                print("YOU DIED")
                flag=False
                dandd(f)
if(round==9):
    print("WASTED")
