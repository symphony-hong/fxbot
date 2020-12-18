
import authentication.SymExtensionAppRSAAuth;
import clients.SymBotClient;
import listeners.RoomListener;
import model.AppAuthResponse;
import model.InboundMessage;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.SymMessageParser;

public class RequestReplyBot {
    private static final Logger log = LoggerFactory.getLogger(RequestReplyBot.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        try {

            SymBotClient botClient = SymBotClient.initBotRsa("config.json");
            botClient.getDatafeedEventsService().addIMListener(new IMListenerImpl(botClient));

        } catch (Exception e) {
            log.error("Error", e);
        }
    }
}
