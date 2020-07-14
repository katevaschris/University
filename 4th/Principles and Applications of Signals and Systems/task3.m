%Cliff Burton's bass solo "Anesthisia Pulling Teeth" (Metallica from album "Kill 'Em All")
 
 t1=0:1/8000:0.25;
 p=sin(0*2*pi*t1); % pause
 
 t2=0.25:1/8000:0.5;
 c=sin(220*2^(3/12)*2*pi*t2); %c
 
 
 c1=sin(220*2^(15/12)*2*pi*t2); %c1 octave higher
 t3=2.50:1/8000:2.75;
 c2=sin(220*2^(3/12)*2*pi*t3); %c1 octave higher
 
 d=sin(220*2^(5/12)*2*pi*t2); %d
 
 
 e=sin(220*2^(7/12)*2*pi*t2); %e
 
 
 g=sin(220*2^(10/12)*2*pi*t2); %g
 
 
 f=sin(220*2^(8/12)*2*pi*t2); %f
 
 
 a=sin(220*2^(11/12)*2*pi*t2); %a
 

 b=sin(220*2^(2/12)*2*pi*t2); %b
 b1=sin(220*2^(14/12)*2*pi*t2); %b1 octave higher
 
 t4=3.25:1/8000:4.50;
 i=sin(220*2^(11/12)*2*pi*t4); %AA
 t5=3.50:1/8000:5.0;
 j=sin(220*2^(10/12)*2*pi*t5); %GG
 

q = [p c p c1 p c2  d f a  d f a  d f a  d f a  d f a  p c e g  c e g  c e g  c e g  c e g  d f a  d f a  d f a  d f a  d f a  c e g  c e g  c e g  c e g  c e g  d f a  d f a  d f a  d f a  d f a  e g b1  e g b1  e g b1  e g b1  e g b1  f a c1  f a c1  f a c1  f a c1  e g b1  e g b1  e g b1  i  j]
soundsc(q)