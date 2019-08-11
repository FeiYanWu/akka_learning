package com.wyf.chapter1.sample;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**************************************
 * @Author : WYF
 * @Date   : 2019/8/9 0:20
 * @Version 1.0
 *************************************/
public class ApplicationMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("MyActorSystem");
        ActorRef pingActor = system.actorOf(PingActor.props(), "pingActor");
        pingActor.tell(new PingActor.Initialize(), null);
        // This example app will ping pong 3 times and thereafter terminate the ActorSystem -
        // see counter logic in PingActor
        system.awaitTermination();
    }
}