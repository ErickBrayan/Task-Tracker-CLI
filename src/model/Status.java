package model;

public enum Status {


    TODO("todo"),
    IN_PROGRESS("in-progress"),
    DONE("done");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
