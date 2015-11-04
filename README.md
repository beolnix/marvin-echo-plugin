## Project description
Example echo plugin for [marvin](https://github.com/beolnix/marvin-core/) bot.
Plugin just sends back received message. It is a demonstration of how the plugins for marvin bot should be created. 

## Project details
| Version | State | Source code | Binaries |
| --- | --- | --- | --- |
| 0.1 | Stable | [0.1-release](https://github.com/beolnix/marvin-echo-plugin/releases/tag/0.1-release) | [echo-plugin-0.1.jar](http://nexus.beolnix.com/service/local/repositories/releases/content/com/beolnix/marvin/echo-plugin/0.1/echo-plugin-0.1.jar) |
| 0.2-SNAPSHOT | In dev | [master](https://github.com/beolnix/marvin-echo-plugin) |  |

## Requirements
#### To run
* JDK 8 only

#### To build
* JDK 8
* Gradle 2.8
* Groovy 2.4.4

## Build from source
Just execute the following command and may the force be with you:
```
gradle clean build
```

If everything is fine, you find **echo-plugin-0.1.jar** in **build/libs/** 

## Usage 
To deploy the plugin simply copy it to the plugins directory of [marvin](https://github.com/beolnix/marvin-core/) bot.
No restart is required, marvin will pick it up on the fly and tell you about it in his **logs/application-main.log**.
Once it is deployed simply send a message directly to the bot or to the conference with it.