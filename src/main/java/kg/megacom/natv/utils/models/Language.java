package kg.megacom.natv.utils.models;

public enum Language {
    UNKNOWN,
    KG,
    RU,
    UZ,
    ENG;

    public static Language getLang(int langId){
        switch (langId){
            case 1: return KG;
            case 2: return RU;
            case 3: return UZ;
            case 4: return ENG;
            default: return RU;

        }
    }
}
