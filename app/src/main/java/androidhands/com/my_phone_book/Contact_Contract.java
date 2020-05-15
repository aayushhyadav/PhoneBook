package androidhands.com.my_phone_book;

public class Contact_Contract {
    //constructor to avoid accidental initialisation of database
    private Contact_Contract(){

    }

    public static class ContactEntry{
        //specifies the database schema

        public static final String TABLE_NAME = "contact_info";
        public static final String NAME = "name";
        public static final String PHONE = "phone";
        public static final String DOB = "dob";
        public static final String EMAIL = "email";
    }
}
