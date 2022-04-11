package schoolmanagement.command;

public enum Target {

    TEACHER("teacher"),
    STUDENT("student"),
    CLASS("class");

    private final String description;

    private Target(String des){
        description = des;
    }

    public static Target getByDescription(String des){
        if(des == null){
            return null;
        }
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
