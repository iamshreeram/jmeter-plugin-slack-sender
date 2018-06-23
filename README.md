[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.iamshreeram.plugins.jmeter.functions/slack-notifier/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.iamshreeram.plugins.jmeter.functions/slack-notifier)
[![Build Status](https://travis-ci.org/iamshreeram/jmeter-plugin-slack-sender.svg?branch=master)](https://travis-ci.org/iamshreeram/jmeter-plugin-slack-sender)
[![License](https://img.shields.io/badge/License-BSD%202--Clause-orange.svg)](https://opensource.org/licenses/BSD-2-Clause)

# jmeter-plugin : slack-notifier
Jmeter function to send slack notification 

## Dependencies

For Maven,
```xml
<dependency>
  <groupId>com.github.iamshreeram.plugins.jmeter.functions</groupId>
  <artifactId>slack-notifier</artifactId>
  <version>1.0</version>
</dependency>
```

## How to use 
```
__WebHookNotify(Webhook url,Message to be sent)

```


## Purpose
1. Helps in publishing load test status to slack channels
2. Capable of sending attachment reports
3. Can be interactive with other Bots

## Future works
1. Create Interface for Bots 
2. Add few user controls to run load test interactively
