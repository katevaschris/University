x = 1:5;                                      
Dt = -0.3:0.003:0.3;                          
T = 100;                                      
for i = 1:length(x)
cmap = hsv(length(x));
s = 1;                                         
K = s*abs(sin(x(i)*T*Dt/2)./(x(i)*T*Dt/2));  
plot(Dt,K,'color',cmap(i,:)); 
%print
title(['Linear Velocity = ' num2str(x(i))]);
hold on
%time lapse
pause(0.5)
end

