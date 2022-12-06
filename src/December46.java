import java.util.HashMap;
import java.util.Map;

public class December46 {
    private static Map<String, String> counries = new HashMap<>();
    static {
        counries.put("UA", "Ukraine");
        counries.put("RU", "Russia");
        counries.put("CA", "Canada");
    }
    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String res = "";
            String country = customer.getCountryName();
            for (Map.Entry<String, String> x : counries.entrySet() ) {
                if (x.getValue().equals(country)) res =x.getKey();

            }
            return res;
        }

        @Override
        public String GetCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().split(", ")[1];
        }

        @Override
        public String getContactLastName() {
            return contact.getName().split(", ")[0];
        }

        @Override
        public String getDialString() {
            String phone = "callto://"+ contact.getPhoneNumber().replaceAll("[()-]", "");
            return phone;
        }
    }
}
