package com.hongdenglv.puick.notification.bark;

/**
 * 铃声
 *
 * @author PeiXy_J
 * @date 2022-4-10 21:03
 */
public enum BellEnum {
    /**
     * 铃声
     */
    ALARM("alarm"),
    ANTICIPATE("anticipate"),
    BELL("bell"),
    BIRDSONG("birdsong"),
    BLOOM("bloom"),
    CALYPSO("calypso"),
    CHIME("chime"),
    CHOO("choo"),
    DESCENT("descent"),
    ELECTRONIC("electronic"),
    FANFARE("fanfare"),
    GLASS("glass"),
    GOTOSLEEP("gotosleep"),
    HEALTHNOTIFICATION("healthnotification"),
    LADDER("ladder"),
    MAILSENT("mailsent"),
    MINUET("minuet"),
    MULTIWAYINVITATION("multiwayinvitation"),
    NEWMAIL("newmail"),
    NEWSFLASH("newsflash"),
    NOIR("noir"),
    PAYMENTSUCCESS("paymentsuccess"),
    SHAKE("shake"),
    SHERWOODFOREST("sherwoodforest"),
    SILENCE("silence"),
    SPELL("spell"),
    SUSPENSE("suspense"),
    TELEGRAPH("telegraph"),
    TIPTOES("tiptoes"),
    TYPEWRITERS("typewriters"),
    UPDATE("update");

    /**
     * 铃声名称
     */
    private String bellName;

    BellEnum(String bellName) {
        this.bellName = bellName;
    }


    public String getBellName() {
        return bellName;
    }
}
