/**
 * Copyright 2012 Google Inc. All Rights Reserved. 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package timeonim;

import com.google.appengine.api.xmpp.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChatServlet extends HttpServlet {

    private static final XMPPService xmppService = XMPPServiceFactory.getXMPPService();

    private static final String help = "Accepted commands: help , <code> 8 8 8 8 8";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Message message = xmppService.parseMessage(req);
        Message reply = new MessageBuilder()
                .withRecipientJids(message.getFromJid())
                .withMessageType(MessageType.NORMAL)
                .withBody(help)
                .build();
        xmppService.sendMessage(reply);
    }
}
