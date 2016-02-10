# CodeClicker
===========
This project was a small side project I was doing while simultaneously taking the Intro to Programming course at The University of Texas at Austin. It's essentially a cookie clicker code. 

### How To Access
It is available on the google play store. Currently the java backend code is all there, but the project is missing visual assets. 
https://play.google.com/store/apps/details?id=com.kevintyang.codeclicker.codeclicker&hl=en

### Contribution
If you would like to contribute to this project, just let me know! If you look through the code there are a lot of upgrades that can be immediately added once I have visual assets. 

### Information
Code Clicker now has two branches (Master and Fragment). 

The fragment branch is a branch that is trying to integrate swipe functionality onto the screen. The master banch is the current working branch with the Code Clicker back end. 

### Master Branch: 
The button clicks, animates and provides haptic feedback. 
The code capacity and money capactiy has been implemented. 
The Money capacity is untested, but mirrors the Code capacity. 
The Ticker class for the second thread is unneeded and it currently is using a "Handler" instead. 
Inside the handler is the code/money per second class running at 990 ms (gives time to process it) as well as the Text View that updates at 100 ms. This may be too fast and we may have to look into slowing it down. 
The Code Upgrades and Sell Upgrades have been implmeneted into the Per Second calculator as well as actualized Per Second. 
The bssic class to upgrade capacity has also been created, but they have not been propagated. 
We will also need to re-evaluate adding value to the click .

### Fragment Branch: 
Has two screen swipe functionality. 
Does not include screen updating capacity. 

We are looking to merge the two together ASAP
