package com.akkademy;

import akka.actor.AbstractLoggingActor;
import akka.japi.pf.ReceiveBuilder;
import com.akkademy.messages.SetRequest;


public class LastMessageActor extends AbstractLoggingActor{
    private Object lastSetRequestValue = null;

    {
        receive(ReceiveBuilder
                .match(SetRequest.class,request -> { lastSetRequestValue = request.getValue();}).build()
                );
    }

    public Object getLastSetRequestValue(){
        return lastSetRequestValue;
    }

}
