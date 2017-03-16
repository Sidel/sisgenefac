package com.fabrica.sisgenefac.domain;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public interface XJsonItem {
    public JsonObject toJson();
    public void addJson(JsonObjectBuilder builder);
}