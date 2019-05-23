# hawkings

Very simple and more or less useful framework to provide a local repository of local Consumers.

# Build Status

|             	| Build Status                                                                                                                                              	| Test Code Coverage                                                                                                                                               	|
|-------------	|-----------------------------------------------------------------------------------------------------------------------------------------------------------	|------------------------------------------------------------------------------------------------------------------------------------------------------------------	|
| Master      	| [![Build Status](https://travis-ci.org/d3adspace/hawkings.svg?branch=master)](https://travis-ci.org/d3adspace/hawkings) 	| [![codecov](https://codecov.io/gh/d3adspace/hawkings/branch/master/graph/badge.svg)](https://codecov.io/gh/d3adspace/hawkings) 	|
| Development 	| [![Build Status](https://travis-ci.org/d3adspace/hawkings.svg?branch=dev)](https://travis-ci.org/d3adspace/hawkings)    	| [![codecov](https://codecov.io/gh/d3adspace/hawkings/branch/dev/graph/badge.svg)](https://codecov.io/gh/d3adspace/hawkings)    	|

# Installation / Usage

- Install [Maven](http://maven.apache.org/download.cgi)
- Clone this repo
- Installh: ```mvn clean install```

**Maven repositories**
```xml
<repositories>
    <repository>
        <id>klauke-enterprises-maven-releases</id>
        <name>Klauke Enterprises Maven Releases</name>
        <url>https://repository.klauke-enterprises.com/repository/maven-releases/</url>
    </repository>

    <repository>
        <id>klauke-enterprises-maven-snapshots</id>
        <name>Klauke Enterprises Maven Snapshots</name>
        <url>https://repository.klauke-enterprises.com/repository/maven-snapshots/</url>
    </repository>
</repositories>
```

**Maven dependencies**

_Hawkings:_
```xml
<dependency>
    <groupId>de.d3adspace</groupId>
    <artifactId>hawkings</artifactId>
    <version>1.1.0-SNAPSHOT</version>
</dependency>
```
