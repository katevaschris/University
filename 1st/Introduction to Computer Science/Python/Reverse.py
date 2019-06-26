#Author: Chris Katevas
#Pireaus 1/2019
#
#Import .txt file convert into list
#Reverse the most appeared alphabet character with the less appeared char
#Then convert list into string and PRINT
import string
f = open("p.txt", "r")
#print(f.read())
alpha=["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
statistics=[0]
for i in range(25):
    statistics.append(0)
p=[]
with open("p.txt", "r") as f:
    for i in f.read():
        p.append(i)
#convert Upper chars into lower
p = [element.lower() for element in p];
#Take number of appers for each alphabetic char
for i in range(len(p)):
    for j in range(len(alpha)):
        if(p[i]==alpha[j]):
            statistics[j]=statistics[j]+1
#Reverse time
i=0
while(i<=len(statistics)):
    if(statistics!=0):
        max=0
        min=i
        break
    else:
        i=i+1
#Find those chars
for i in range(len(statistics)):
    if((statistics[i]>statistics[max])):
        max=i
    if((statistics[i]<statistics[min])and(statistics[i]!=0)):
        min=i
#Most appeared char goes to less appeared char and backwards
for i in range(len(p)):
    if(p[i]==alpha[max]):
        p[i]=alpha[min]
    elif(p[i]==alpha[min]):
        p[i]=alpha[max]
#convert list into string and Print
p = ''.join(p)
print(p.upper())
