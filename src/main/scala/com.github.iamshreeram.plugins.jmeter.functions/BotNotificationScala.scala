package com.github.iamshreeram.plugins.jmeter.functions

import java.util
import org.apache.jmeter.engine.util.CompoundVariable
import org.apache.jmeter.functions.AbstractFunction
import org.apache.jmeter.functions.InvalidVariableException
import org.apache.jmeter.samplers.SampleResult
import org.apache.jmeter.samplers.Sampler
import org.apache.jmeter.threads.JMeterVariables
import net.gpedro.integrations.slack.SlackApi
import net.gpedro.integrations.slack.SlackMessage

import collection.JavaConverters._

object BotNotificationScala {
  private val MyFunctionName = "__BotScalaNotify"
  private val desc = new util.LinkedList[String]
  try desc.add("Bot URL")
  desc.add("Bot Token")
  desc.add("Message to post")
}

class BotNotificationScala extends AbstractFunction {
  private var values = null

  override def getArgumentDesc: util.List[String] = BotNotificationScala.desc

  @throws[InvalidVariableException]
  override def execute(arg0: SampleResult, arg1: Sampler): String = {
    /*
           JMeterVariables vars = getVariables();
           String webhookUrl = ((CompoundVariable) values[0]).execute();
           String message = ((CompoundVariable) values[0]).execute();
           SlackApi api = new SlackApi(webhookUrl);
           api.call(new SlackMessage(message));
           */ "Yet to enable bot notification"
  }

  override def getReferenceKey: String = BotNotificationScala.MyFunctionName

  @throws[InvalidVariableException]
  override def setParameters(parameters: util.Collection[CompoundVariable]): Any =
    {
      // This is not working when we build. Need to check
      // Need to return Array instead of Any

      return parameters.asScala
      //return parameters.size()
      //values = parameters.toArray
    }
}
