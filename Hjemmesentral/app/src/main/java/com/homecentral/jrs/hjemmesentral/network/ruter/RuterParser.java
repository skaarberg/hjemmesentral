package com.homecentral.jrs.hjemmesentral.network.ruter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.homecentral.jrs.hjemmesentral.model.ruter.Departure;
import com.homecentral.jrs.hjemmesentral.model.ruter.Line;
import com.homecentral.jrs.hjemmesentral.util.JacksonHelper;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

public class RuterParser {

    public static List<Line> parseBaseData(String response) throws IOException {
        return JacksonHelper.getInstance().readValue(response, new TypeReference<List<Line>>(){});
    }

    public static List<Departure> parseRealtimeData(String response) throws IOException {
        return JacksonHelper.getInstance().readValue(response, new TypeReference<List<Departure>>(){});
    }
}
