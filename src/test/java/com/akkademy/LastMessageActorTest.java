package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import com.akkademy.messages.SetRequest;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by umit on 03/06/2017.
 */
public class LastMessageActorTest {
    ActorSystem system = ActorSystem.create();

    @Test
    public void itShouldSaveLastSetRequestValue(){
        TestActorRef<LastMessageActor> actorRef = TestActorRef.create(system, Props.create(LastMessageActor.class));
        actorRef.tell(new SetRequest("first","firstValue"), ActorRef.noSender());
        actorRef.tell(new SetRequest("second","secondValue"), ActorRef.noSender());

        LastMessageActor myActor = actorRef.underlyingActor();
        assertEquals(myActor.getLastSetRequestValue(),"secondValue");
    }
}
