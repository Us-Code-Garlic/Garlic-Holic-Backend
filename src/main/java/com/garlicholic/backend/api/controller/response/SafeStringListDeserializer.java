package com.garlicholic.backend.api.controller.response;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SafeStringListDeserializer extends JsonDeserializer<List<String>> {
    @Override
    public List<String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        if (node.isArray()) {
            List<String> result = new ArrayList<>();
            node.forEach(e -> result.add(e.asText()));
            return result;
        } else if (node.isTextual()) {
            String text = node.asText();
            return text.isBlank() ? Collections.emptyList() : List.of(text);
        }
        return Collections.emptyList();
    }
}
