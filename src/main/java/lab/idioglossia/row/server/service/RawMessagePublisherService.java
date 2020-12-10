package lab.idioglossia.row.server.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab.idioglossia.row.server.domain.RowWebsocketSession;
import lab.idioglossia.row.server.domain.protocol.ResponseDto;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;

public class RawMessagePublisherService {
    private final ObjectMapper objectMapper;

    public RawMessagePublisherService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void publish(RowWebsocketSession rowWebsocketSession, Object message) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setBody(message);
        rowWebsocketSession.getSession().sendMessage(new TextMessage(objectMapper.writeValueAsString(responseDto)));
    }

    public void publish(RowWebsocketSession rowWebsocketSession, String message) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        JsonNode jsonNode = objectMapper.valueToTree(message);
        responseDto.setBody(jsonNode);
        rowWebsocketSession.getSession().sendMessage(new TextMessage(objectMapper.writeValueAsString(responseDto)));
    }

}