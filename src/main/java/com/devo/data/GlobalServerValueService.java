package com.devo.data;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class GlobalServerValueService {

    final GlobalServerValueRepository globalServerValueRepository;

    public GlobalServerValueService(GlobalServerValueRepository globalServerValueRepository) {
        this.globalServerValueRepository = globalServerValueRepository;
    }

    private String readValue(String key){
        GlobalServerValue gsv = globalServerValueRepository.findByKey(key);
        return (gsv != null) ? gsv.getValue() : "" ;
    }

    String readString(String key){
        return readValue(key);
    }

    Integer readInt(String key){
        return Integer.valueOf(readValue(key));
    }

    Boolean readBoolean(String key){
        return Boolean.valueOf(readValue(key));
    }

    Date readDate(String key){
        final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
        final String value = readValue(key);
        Date result = null;
        try {
            result = new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

}
