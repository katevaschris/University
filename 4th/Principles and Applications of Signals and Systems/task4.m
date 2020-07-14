pic=imread('C:\Users\c\Desktop\bb.jpg');
imshow(pic)
G=dct2(pic);
inpt=input('Give a random number:')
G(abs(G)<inpt)=0;
g=idct2(G)/255;
imshow(g)