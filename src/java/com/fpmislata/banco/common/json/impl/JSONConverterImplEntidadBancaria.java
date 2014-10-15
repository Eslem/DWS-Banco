package com.fpmislata.banco.common.json.impl;

import com.fpmislata.banco.entidades.EntidadBancaria;
import com.fpmislata.banco.common.json.JSONConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JSONConverterImplEntidadBancaria implements JSONConverter {

    @Override
    public String toJSON(Object object) throws RuntimeException {
        EntidadBancaria entidadBancaria = (EntidadBancaria) object;
        return "{\"idEntidadBancaria\": " + entidadBancaria.getIdEntidadBancaria() + ", "
                + "\"nombre\": \"" + entidadBancaria.getNombre() + "\", "
                + "\"codigoEntidad\": \"" + entidadBancaria.getCodigoEntidad() + "\", "
                + "\"fechaCreacion\": \"" + entidadBancaria.getFechaCreacion() + "\"}";
    }

    @Override
    public Object fromJSON(String json, Class className) throws RuntimeException {
        try {
            if (className != EntidadBancaria.class) throw new RuntimeException();
            String[] propiedadesJSON = json.split(", ");
            return new EntidadBancaria(
                    Integer.parseInt(propiedadesJSON[0].split(": ")[1]),
                    propiedadesJSON[1].split(": ")[1].replace("\"", ""),
                    propiedadesJSON[2].split(": ")[1].replace("\"", ""),
                    new SimpleDateFormat("yyyy-MM-dd").parse(propiedadesJSON[3].split(": ")[1].split("}")[0].replace("\"", ""))
            );
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
}
