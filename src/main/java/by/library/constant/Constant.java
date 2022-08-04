package by.library.constant;

import by.library.model.Role;
import by.library.model.Status;

public final class Constant {

    private Constant() {
    }

    public static final Role ADMIN_ROLE = new Role(1L, "ADMIN");
    public static final Role MANAGER_ROLE = new Role(2L, "MANAGER");
    public static final Role USER_ROLE = new Role(3L, "USER");

    public static final Status ACTIVE_STATUS = new Status(1L, "ACTIVE");
}
