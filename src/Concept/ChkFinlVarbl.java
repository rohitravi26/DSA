package Concept;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.UUID;

public class ChkFinlVarbl {
    private final BaseClass b = new BaseClass(3);

    public static void main(String[] args) {
        //new ChkFinlVarbl().checkFinal();

        //CharSequence text;
        //String DATE_FORMAT = "dd-MM-YYYY hh:mm:ss a";
        String DATE_FORMAT = "MMMM dd, YYYY, hh:mma";
        LocalDateTime now = OffsetDateTime.now().toLocalDateTime();
        String  txnDateTime =
            OffsetDateTime.ofInstant(
                OffsetDateTime.now().toInstant(), ZoneId.of("America/New_York")).format(DateTimeFormatter.ofPattern(DATE_FORMAT));
        String a ="https://merchant.dev.payments.bakkt.com/MerchantPortal/disputes?dispute-id=";
       UUID b = UUID.randomUUID();
        System.out.println(String.format("%s%s",txnDateTime, UUID.randomUUID()));
        String s = String.format("%s%s",a,b);
        System.out.println(s);
    }

    void checkFinal(){
        System.out.println(b);
        //b = new BaseClass(2); this is not allowed
        b.i=5;
        System.out.println(b);
    }
}
