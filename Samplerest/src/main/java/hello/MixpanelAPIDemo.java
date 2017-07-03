package hello;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.json.JSONObject;

import com.mixpanel.mixpanelapi.ClientDelivery;
import com.mixpanel.mixpanelapi.MessageBuilder;
import com.mixpanel.mixpanelapi.MixpanelAPI;

/**
 * This is a simple demonstration of how you might use the Mixpanel
 * Java API in your programs.
 *
 */
public class MixpanelAPIDemo {

    public static String PROJECT_TOKEN = "d013495cd2146d70afdc9b1e86846bf2"; // "YOUR TOKEN";
    public static long MILLIS_TO_WAIT = 10 * 1000;

    private static class DeliveryThread extends Thread {
        public DeliveryThread(Queue<JSONObject> messages) {
            mMixpanel = new MixpanelAPI();
            mMessageQueue = messages;
        }

        @Override
        public void run() {
            try {
                while(true) {
                    int messageCount = 0;
                    ClientDelivery delivery = new ClientDelivery();
                    JSONObject message = null;
                    do {
                        message = mMessageQueue.poll();
                        if (message != null) {
                            System.out.println("WILL SEND MESSAGE:\n" + message.toString());

                            messageCount = messageCount + 1;
                            delivery.addMessage(message);
                        }

                    } while(message != null);

                    mMixpanel.deliver(delivery);

                    System.out.println("Sent " + messageCount + " messages.");
                    Thread.sleep(MILLIS_TO_WAIT);
                }
            } catch (IOException e) {
                throw new RuntimeException("Can't communicate with Mixpanel.", e);
            } catch (InterruptedException e) {
                System.out.println("Message process interrupted.");
            }
        }

        private final MixpanelAPI mMixpanel;
        private final Queue<JSONObject> mMessageQueue;
    }

    public static void printUsage() {
        System.out.println("USAGE: java com.mixpanel.mixpanelapi.demo.MixpanelAPIDemo distinct_id");
        System.out.println("");
        System.out.println("This is a simple program demonstrating Mixpanel's Java library.");
        System.out.println("It reads lines from standard input and sends them to Mixpanel as events.");
    }

    public void reportToMixpanel() throws IOException {
        MessageBuilder messageBuilder =
                new MessageBuilder("d013495cd2146d70afdc9b1e86846bf2");

        // Create an event
//        JSONObject sentEvent =
//                messageBuilder.event(distinctId, "Sent Message", null);

        // You can send properties along with events
        JSONObject props = new JSONObject();
        props.put("Gender", "Female");
        props.put("Age", 21);

        String distinctId = "767399";
        JSONObject planEvent =
                messageBuilder.event(distinctId, "Registered", props);

        // Gather together a bunch of messages into a single
        // ClientDelivery. This can happen in a separate thread
        // or process from the call to MessageBuilder.event()
        ClientDelivery delivery = new ClientDelivery();
//        delivery.addMessage(sentEvent);
        delivery.addMessage(planEvent);

        // Use an instance of MixpanelAPI to send the messages
        // to Mixpanel's servers.
        MixpanelAPI mixpanel = new MixpanelAPI();
        mixpanel.deliver(delivery);
    }

    /**
     * @param args
     */
    /*
    public static void main(String[] args)
            throws IOException, InterruptedException {
        Queue<JSONObject> messages = new ConcurrentLinkedQueue<JSONObject>();
        DeliveryThread worker = new DeliveryThread(messages);
        MessageBuilder messageBuilder = new MessageBuilder(PROJECT_TOKEN);

        if (args.length != 1) {
            printUsage();
            System.exit(1);
        }

        worker.start();
        String distinctId = args[0];
        BufferedReader inputLines = new BufferedReader(new InputStreamReader(System.in));
        String line = inputLines.readLine();

        // Set the first name of the associated user (to distinct id)
        Map<String, String> namePropsMap = new HashMap<String, String>();
        namePropsMap.put("$first_name", distinctId);
        JSONObject nameProps = new JSONObject(namePropsMap);
        JSONObject nameMessage = messageBuilder.set(distinctId, nameProps);
        messages.add(nameMessage);

        // Charge the user $2.50 for using the program :)
        JSONObject transactionMessage = messageBuilder.trackCharge(distinctId, 2.50, null);
        messages.add(transactionMessage);

        while((line != null) && (line.length() > 0)) {
            System.out.println("SENDING LINE: " + line);
            Map<String, String> propMap = new HashMap<String, String>();
            propMap.put("Line Typed", line.trim());
            JSONObject props = new JSONObject(propMap);
            JSONObject eventMessage = messageBuilder.event(distinctId, "Typed Line", props);
            messages.add(eventMessage);

            Map<String, Long> lineCounter = new HashMap<String, Long>();
            lineCounter.put("Lines Typed", 1L);
            JSONObject incrementMessage = messageBuilder.increment(distinctId, lineCounter);
            messages.add(incrementMessage);

            line = inputLines.readLine();
        }

        while(! messages.isEmpty()) {
            Thread.sleep(1000);
        }

        worker.interrupt();
    }
    */

}