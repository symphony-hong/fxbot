import clients.SymBotClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import listeners.IMListener;
import model.InboundMessage;
import model.OutboundMessage;
import model.Stream;

import java.util.List;

public class IMListenerImpl implements IMListener {
    private SymBotClient botClient;

    public IMListenerImpl(SymBotClient botClient) {
        this.botClient = botClient;
    }

    public void onIMMessage(InboundMessage msg) {
        List<Long> mentions = msg.getMentions();
//        OutboundMessage msgOut = new OutboundMessage("Hello " + msg.getUser().getFirstName() + "!");
//        System.out.println("Message: " + msg.getMessageText());
//        System.out.println("Mentions: " + mentions);
        OutboundMessage msgOut = new OutboundMessage("<div data-format=\"PresentationML\" data-version=\"2.0\" class=\"wysiwyg\"><p>/abc&nbsp;abc <span class=\"entity\" data-entity-id=\"0\">@Hong Duong Le</span> </p></div>");
        this.botClient.getMessagesClient().sendMessage(msg.getStream().getStreamId(), msgOut);

    }

    public void onIMCreated(Stream stream) {}
}
