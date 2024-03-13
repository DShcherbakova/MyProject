package AppWorker.EnumOrganization;

public enum Status {
    DIRECTOR("Директор"),
    DEPUTY_DIRECTOR("Заместитель директора"),
    SECRETARY("Секретарь"),
    BOOKER("Бухгалтер");

    private final String description;
    Status(String description) {
        this.description = description;
    }
    public String getDescription(){

        return description;
    }

}