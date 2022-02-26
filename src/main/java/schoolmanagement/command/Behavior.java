package schoolmanagement.command;

public enum Behavior {
    ADD(1),//public static final ADD = new Behavior(1); behaviour of which index equals 1 is an ADD behavior;
    DELETE(2),
    SEARCH(3),
    CHANGE(4),
    LIST_ALL(5);

    private int index;

    private Behavior(int index){
        this.index = index;
    }

    static Behavior getByIndex(int index){
        switch (index){
            case (1):
                return ADD;
            case (2):
                return DELETE;
            case (3):
                return SEARCH;
            case (4):
                return CHANGE;
            case (5):
                return LIST_ALL;
        }
        return null;
    }

}
