package br.com.correios.realize.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonDeserialize(using = TipoMetaEnum.TipoMetaEnumDeserializer.class)
public enum TipoMetaEnum {

    V("Á vista"),
    F("A faturar"),
    P("Prospecção");

    private String descricao;

    TipoMetaEnum(String descricao){
        this.descricao = descricao;
    }

    public String getChave(){
        return this.name();
    }

    public String getDescricao() {
        return descricao;
    }


    public static class TipoMetaEnumDeserializer extends StdDeserializer<TipoMetaEnum> {
        public TipoMetaEnumDeserializer() {
            super(TipoMetaEnum.class);
        }

        @Override
        public TipoMetaEnum deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
            final JsonNode jsonNode = jp.readValueAsTree();
            String key = jsonNode.get("chave").asText();
            String value = jsonNode.get("descricao").asText();

            for (TipoMetaEnum me: TipoMetaEnum.values()) {
                if ( me.getChave().equals(key) && me.getDescricao().equals(value)) {
                    return me;
                }
            }
            throw dc.mappingException("Cannot deserialize TipoMetaEnum from key " + key + " and value " + value);
        }
    }

}