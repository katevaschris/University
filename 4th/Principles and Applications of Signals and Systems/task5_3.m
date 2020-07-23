image = 'bb.jpg';
output = 'bb_blurred.jpg';
c = 1;
T = 30;
Input = imread(image)
P = 1/(c*T)*ones(1,c*T+1);      %formula for blurring image
Blurred_image = imfilter(Input,P,'replicate');
imwrite(Blurred_image, output); 
figure('Name','Processed Image','NumberTitle','off');
subplot 121; imshow(Input); title('Original image');
subplot 122; imshow(Blurred_image); title(['Blurred image']);