package schoolmanagement.command;

public enum Target {

    TEACHER("teacher"),
    STUDENT("student"),
    CLASS("class");

    private String description;

    private Target(String des){
        description = des;
    }

    static Target getByDescription(String des){
        switch (des.toLowerCase()){
            case"teacher":
                return TEACHER;
            case"student":
                return STUDENT;
            case"class":
                return CLASS;
        }
        return null;
    }
}
