package com.dtstack.chunjun.connector.mongodb.util;

import com.mongodb.util.JSON;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Bson2JsonUtilsTest {

    public static void main(String[] args) {
        String moneyValueOri = "1.211";
        Instant instant = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();
        String createTimeOri =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                        .withZone(ZoneId.systemDefault())
                        .format(instant);
        System.out.println(createTimeOri);

        Document document = new Document();
        document.append("money", new BigDecimal(moneyValueOri));
        document.append("oid", new ObjectId("124578698574857412589654"));
        document.append("date", new Date());
        document.append("BOLLEAN", true);
        String jsonStr = Bson2JsonUtils.toJson(document);
        System.out.println(jsonStr);
        System.out.println(document.toJson());
        System.out.println(JSON.serialize(document));
        Document document1 = Document.parse(JSON.serialize(document));
        System.out.println(document1);
        String jsonStr2 = Bson2JsonUtils.toJson(document1);
        System.out.println(jsonStr2);
    }
}
