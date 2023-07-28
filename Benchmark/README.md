
  

# GinDroid: Benchmark
rk

This directory contains the benchmarks used to evaluate GinDroid
  

## Applications
The applications are listed by there short names, a key for these short names is shown below:
  
  
 Name | Application | Commit 
--|--|--
FB1|Frozen Bubble|e9f6a51be9f7c4ad9f11d8712b06cb906e9ddf28 
FBN|Frozen Bubble| https://github.com/videogameboy76/frozenbubbleandroid
FD1|Fdroid| e44ca193dd0adcbc5e240410aec4c681f5053dae 
FD2|Fdroid|bf8aa30a576144524e83731a1bad20a1dab3f1bc 
FDN|Fdroid| https://github.com/f-droid/fdroidclient
FS1|Fosdem Companion | b79e29a67c29699b9b8d4ad9c09a3349ce32c59f 
FSN|Fosdem Companion | https://github.com/cbeyls/fosdem-companion-android
GB1|Gadgetbridge| c75362c5ea489247cc00b473a0ef91dbb1cc1569
GBN|Gadgetbridge| https://github.com/Freeyourgadget/Gadgetbridge
LB1|Lightning Browser| 460da386ec10cb82b97bd2def2724fe41f709a88 
LBN|Lightning Browser| https://github.com/vaginessa/lightningbrowser
PA1|PortAuthority | e0163e20d1a67c22c2f7ed0f0345206ce1a050f0
PA2|PortAuthority | e37a1a522a15773710f051d9fff5c0ce68ade5cb
PA3|PortAuthority | 3a1329297881aff069cdbc80c92de386ac952d77
PA4|PortAuthority | adc73aac9c7dba5c61e1e18a96dfe7dd9712d100
PA5|PortAuthority | 3e6846b6a377c35780ddb49e21eeab5749381bf2
PA6|PortAuthority | a02a0170a38ec257e1f390388e4b5d1414b3cf36
PAN|PortAuthority | https://github.com/aaronjwood/PortAuthority
TC1|Tower Collector| 956ea2213c1f7f012d6ab1388536a0c6d5202bd9
TC2|Tower Collector| 0632608d26667e3a1864bf436086cf9422a913cb
TCN|Tower Collector| https://github.com/zamojski/TowerCollector

  

## Using the benchmarks with GinDroid

To use an app from this benchmark, you must provide the location of your Android Sdk in the local.properties file in the root of the application.
This can be done automatically by opening the app in Android Studio.

Then ensure that the application can be built and tested.
This can be done in Android studio by opening the application, navigating to the test file and clicking on the arrows in the gutter next to the class declaration.

Alternatively, it can be done using gradle with the command.

```
gradle test{flavor}debugUnitTest
```

the flavor for each app can be found in the config.properties file


### Running GinDroid
Simply copy the config .properties file from the app you wish to run into your working directory and update the paths in the config file to point to the application and run

```
java -jar gin.jar
```

