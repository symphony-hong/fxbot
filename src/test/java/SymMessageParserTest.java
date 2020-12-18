import model.InboundMessage;
import org.junit.Test;
import utils.SymMessageParser;
import static org.junit.Assert.*;

import java.util.List;

public class SymMessageParserTest {

    @Test
    public void readTree() {
        InboundMessage msg = new InboundMessage();
        msg.setData("");
        List<Long> mentions = SymMessageParser.getMentions(msg);
        assertNotNull(mentions);
    }
}
