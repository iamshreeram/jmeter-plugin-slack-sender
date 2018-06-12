package com.github.iamshreeram.plugins.jmeter.functions;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;
import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;
import org.apache.jmeter.threads.JMeterVariables;

public class WebhookNotification extends AbstractFunction {

    private static final String MyFunctionName = "__WebHookNotify";
    private static final List < String > desc = new LinkedList < String > ();
    private Object[] values;

    //public WebhookNotification() {}
    static {
        desc.add("Incoming Webhook URL");
        desc.add("Message to post");
    }

    public List < String > getArgumentDesc() {
        return desc;
    }


    @Override
    public String execute(SampleResult arg0, Sampler arg1) throws InvalidVariableException {
        JMeterVariables vars = getVariables();
        String webhookUrl = ((CompoundVariable) values[0]).execute();
        String message = ((CompoundVariable) values[1]).execute();
        SlackApi api = new SlackApi(webhookUrl);
        api.call(new SlackMessage(message));
        return arg0+"+"+arg1;
    }

    @Override
    public String getReferenceKey() {
        return MyFunctionName;
    }

    @Override
    public void setParameters(Collection < CompoundVariable > parameters) throws InvalidVariableException {
        values = parameters.toArray();
    }
}
