public class Address {
    // {house num, street name, apartment num, city, state, zip code}
    private String[] addressData;

    public Address(String houseNum, String streetName, String apartNum, String city, String state, String zipcode) {
        addressData = new String[]{houseNum, streetName, apartNum, city, state, zipcode};
    }

    public Address(Address address) {
        addressData = new String[6];
        for (int i = 0; i < 6; i++) {
            addressData[i] = address.accessData(i);
        }
    }

    public Address(String dataStr) {
        addressData = new String[6];
        String[] dataArr = dataStr.split("=");
        System.arraycopy(dataArr, 0, addressData, 0, 6);
    }

    // data always stored in the same order as seen in line 2
    public String accessData(int index) {
        return addressData[index];
    }

    public void mutateData(int index, String newStr) {
        addressData[index] = newStr;
    }

    public String toString() {
        return addressData[0] + " " + addressData[1] + " " + addressData[2] + ", " + addressData[3] + ", " + addressData[4] + " " + addressData[5];
    }
}
