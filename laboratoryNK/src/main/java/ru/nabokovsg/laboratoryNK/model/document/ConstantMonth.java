package ru.nabokovsg.laboratoryNK.model.document;

import ru.nabokovsg.laboratoryNK.exceptions.BadRequestException;

import java.time.LocalDate;

public class ConstantMonth {

    private final static String JANUARY = "января";
    private final static String FEBRUARY = "февраля";
    private final static String MARCH = "марта";
    private final static String APRIL = "апреля";
    private final static String MAY = "мая";
    private final static String JUNE = "июня";
    private final static String JULY = "июля";
    private final static String AUGUST = "августа";
    private final static String SEPTEMBER = "сентября";
    private final static String OCTOBER = "октября";
    private final static String NOVEMBER = "ноября";
    private final static String DECEMBER = "декабря";


    public String get(LocalDate date) {
        switch (date.getMonth().getValue()) {
            case 1 -> {return JANUARY;}
            case 2 -> {return FEBRUARY;}
            case 3 -> {return MARCH;}
            case 4 -> {return APRIL;}
            case 5 -> {return MAY;}
            case 6 -> {return JUNE;}
            case 7 -> {return JULY;}
            case 8 -> {return AUGUST;}
            case 9 -> {return SEPTEMBER;}
            case 10 -> {return OCTOBER;}
            case 11 -> {return NOVEMBER;}
            case 12 -> {return DECEMBER;}
            default -> throw new BadRequestException(
                                            String.format("Unknown month number=%s", date.getMonth().getValue()));
        }
    }
}