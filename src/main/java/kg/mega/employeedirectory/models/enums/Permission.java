package kg.mega.employeedirectory.models.enums;

public enum Permission {
    SUPER_ADMIN("super:admin"),
    ADMIN_WRITE("admin:write"),
    ADMIN_EDIT("admin:edit"),
    ADMIN_DISABLED("admin:disabled");

    private final String permission;

    Permission(String permission) {
        this.permission=permission;
    }

    public String getPermission(){
        return permission;
    }
}
