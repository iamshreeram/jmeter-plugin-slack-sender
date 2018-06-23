package com.github.iamshreeram.plugins.jmeter.functions;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.github.iamshreeram.plugins.jmeter.slack.SlackApi;
import com.github.iamshreeram.plugins.jmeter.slack.SlackMessage;

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

    private static boolean isNullOrBlank(String s)
    {
        return (s==null || s.trim().equals(""));
    }


    @Override
    public String execute(SampleResult arg0, Sampler arg1) throws InvalidVariableException {
        JMeterVariables vars = getVariables();
        String webhookUrl = ((CompoundVariable) values[0]).execute();
        String message = ((CompoundVariable) values[1]).execute();

        if (isNullOrBlank(webhookUrl) && isNullOrBlank(message)  ) {
            SlackApi api = new SlackApi(webhookUrl);
            try {
                api.call(new SlackMessage(message));
                return "Success";
            } catch (Exception exception) {
                System.out.println("Exception while making slack call : " + exception);
                return "Failed to call webhook";
            }
        } else {
            return "One or more empty sections";
        }
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
