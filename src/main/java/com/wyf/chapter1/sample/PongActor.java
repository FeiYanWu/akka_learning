package com.wyf.chapter1.sample;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**************************************
 * @Author : WYF
 * @Date   : 2019/8/9 0:19
 * @Version 1.0
 *************************************/
public class PongActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public static Props props() {
        return Props.create(PongActor.class);
    }

    public static class PongMessage {
        private final String text;

        public PongMessage(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof PingActor.PingMessage) {
            PingActor.PingMessage ping = (PingActor.PingMessage) message;
            log.info("In PongActor - received message: {}", ping.getText());
            getSender().tell(new PongMessage("pong"), getSelf());
        } else {
            unhandled(message);
        }
    }
}