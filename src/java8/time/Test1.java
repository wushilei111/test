package java8.time;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Test1 {
    @Test
    public void simpleDateFormat() throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Callable<Date> callable = ()->{
            return  sdf.parse("20161218");
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(pool.submit(callable));
        }

        for (Future<Date> future:result) {
            System.out.println(future.get());
        }
    }

    @Test
    public void dateTimeFormater() throws ExecutionException, InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;//DateTimeFormater.ofpatterm("yyyyMMdd")自定义格式

        Callable<LocalDate> callable = ()->{
            return LocalDate.parse("2019-03-01",dtf);
        };

        List<Future<LocalDate>> l = new ArrayList<>();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            l.add(pool.submit(callable));
        }
        for (Future<LocalDate> local: l) {
            System.out.println(local.get());
        }
    }

    @Test
    public void testApi(){
        LocalDate ld = LocalDate.now();
        LocalDateTime ldt = LocalDateTime.now();
        //LocalDateTime.of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond)
        LocalDateTime ldt1 = ldt.plusHours(2);//返回给定时间之后两小时之后的时间
        //plusXXX   一定时间啊之后
        //minusXXX  一定时间之前
        LocalTime lt = LocalTime.now();
        System.out.println(ld+"\n"+ldt+"\n"+lt);
    }

    @Test
    public void testInstant(){
        Instant instant = Instant.now();//创建一个可以获取时间戳的时间，以UTC时间为基准
        System.out.println(instant);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));//将时间向后偏移8小时，即北京时间
        System.out.println(offsetDateTime);
        System.out.println(instant.toEpochMilli());//获取毫秒时间戳
        System.out.println(Long.MAX_VALUE/((long)1000*60*60*24*365));
    }

    @Test
    public void testPast() throws InterruptedException {
        /**
         * Duration 计算两个   时间   之间的间隔
         * Period 计算两个  日期   之间的间隔
         *
         */
        Instant i1 = Instant.now();
        Thread.sleep(1000);
        Instant i2 = Instant.now();

        Duration duration = Duration.between(i1,i2);
        System.out.println(duration.toMillis());

        LocalDateTime ldt1 = LocalDateTime.now();
        Thread.sleep(1000);
        LocalDateTime ldt2 = LocalDateTime.now();
        duration = Duration.between(ldt1,ldt2);
        System.out.println(duration.toMillis());

//        LocalDate ld1 = LocalDate.now();   不可用于LocalDate，编译可通过但运行会抛出异常
//        Thread.sleep(1000);
//        LocalDate ld2 = LocalDate.now();
//        duration = Duration.between(ld1,ld2);
//        System.out.println(duration.toMillis());
    }

    @Test
    public void testPast2(){
        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2019,03,02);
        Period p = Period.between(ld1,ld2);//只接受LocalDate类型参数
        System.out.println(p.toString());
    }

    @Test
    public void testTemporalAdjesters(){
        LocalDate localDate = LocalDate.now();
        localDate.with(TemporalAdjusters.firstDayOfMonth());//将日设为当前月的第一天
        //TemporalAdjuster 是一个接口用于设置时间，
        //TemporalAjusters 提供了TemporalAdjuster的各种常用实现
        System.out.println(localDate);
    }

    @Test
    public void dateTimeFormat(){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
        LocalDateTime ldt = LocalDateTime.now();
        String s = ldt.format(dtf);
        String s2 = ldt.format(dtf2);
        System.out.println(ldt);
        System.out.println(s);
        System.out.println(s2);
        LocalDateTime ldt2 = LocalDateTime.parse(s2,dtf2);
        System.out.println(ldt2);
    }

    @Test
    public void uTC(){
        Set<String> strings = ZoneId.getAvailableZoneIds();
        for (String s:strings) {
            System.out.println(s);
        }
    }

    @Test
    public void Utc(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt);
        ZonedDateTime z= ldt.atZone(ZoneId.of("Asia/Aden"));//转换时区，但它只是
        //在时间之后加上指定的时区标记，对显示时间没有任何修改
        //或者说这个方法不能称为转换时区，它只是添加了时区标志
        System.out.println(z);
        //2019-03-01T14:17:06.319
        //2019-03-01T14:17:06.319+03:00[Asia/Aden]


        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Asia/Aden"));
        //这样生成的时间再添加时区格式才是真的Asia/Aden的时间
        ZonedDateTime z2 = ldt2.atZone(ZoneId.of("Asia/Aden"));
        System.out.println(z2);
        ///2019-03-01T14:21:57.675
        //2019-03-01T14:21:57.675+03:00[Asia/Aden]
        //2019-03-01T09:21:57.677+03:00[Asia/Aden]
    }
}
