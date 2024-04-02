package com.ferraro.concurrencyexchange;

public enum Currency {

    EUR("EUR", " (€)"),
    USD("USD", " ($)"),
    JPY("JPY", " (¥)"),
    BGN("BGN", " (лв)"),
    CZK("CZK", " (Kč)"),
    DKK("DKK", " (kr)"),
    GBP("GBP", " (£)"),
    HUF("HUF", " (Ft)"),
    PLN("PLN", " (zł)"),
    RON("RON", " (lei)"),
    SEK("SEK", " (kr)"),
    CHF("CHF", " (Fr)"),
    ISK("ISK", " (kr)"),
    NOK("NOK", " (kr)"),
    HRK("HRK", " (kn)"),
    RUB("RUB", " (₽)"),
    TRY("TRY", " (₺)"),
    AUD("AUD", " (A$)"),
    BRL("BRL", " (R$)"),
    CAD("CAD", " (C$)"),
    CNY("CNY", " (¥)"),
    HKD("HKD", " (HK$)"),
    IDR("IDR", " (Rp)"),
    ILS("ILS", " (₪)"),
    INR("INR", " (₹)"),
    KRW("KRW", " (₩)"),
    MXN("MXN", " (Mex$)"),
    MYR("MYR", " (RM)"),
    NZD("NZD", " (NZ$)"),
    PHP("PHP", " (₱)"),
    SGD("SGD", " (S$)"),
    THB("THB", " (฿)"),
    ZAR("ZAR", " (R)");


    private final String code;
    private final String symbol;

    Currency(String code, String symbol) {
        this.code = code;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }
}

