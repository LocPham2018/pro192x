import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Asm01 {
    public static final String AUTHOR = "NGUYEN VAN HUNG";
    public static final String VERSION = "@V1.0.0";

    public static void main(String[] args) {
        displaySoftwareInformation();
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chức năng: ");
        while (input.hasNext()) {
            String number = input.nextLine();
            if (checkInputNumber(number)) {
                int checkedNumber = Integer.parseInt(number);
                switch (checkedNumber) {
                    case 1:
                        // nên tách ra một hàm
                        displayAuthentication();
                        System.out.print("Chọn mã bảo mật: ");
                        while (input.hasNext()) {
                            String inputAuthentication = input.nextLine();
                            if (checkInputNumber(inputAuthentication)) {
                                int checkAuthentication = Integer.parseInt(inputAuthentication);
                                switch (checkAuthentication) {
                                    case 1:
                                        int randomCode = (int)(Math.random() * 900) + 100;
                                        System.out.println("Nhập mã xác thực: " + randomCode);
                                        while (input.hasNext()) {
                                            String verificationCode = input.nextLine();
                                            if (checkVerificationCode(verificationCode, randomCode)) {
                                                // lặp code với đoạn if (checkSixCharacterCode(verificationCode, randomAlphanumericCode)) ở phía dưới
                                                // nên tách đoạn này ra một hàm
                                                System.out.print("Nhập số CCCD: ");
                                                while (input.hasNext()) {
                                                    String cccdNumber = input.nextLine();
                                                    if (checkCccdNumber(cccdNumber)) {
                                                        displayFunction();
                                                        while (input.hasNext()) {
                                                            String functionNumber = input.nextLine();
                                                            if (checkInputFunction(functionNumber)) {
                                                                int inputFunctionNumber = Integer.parseInt(functionNumber);
                                                                switch (inputFunctionNumber) {
                                                                    case 1:
                                                                        System.out.println("Nơi sinh: " + showAddress(cccdNumber));
                                                                        break;
                                                                    case 2:
                                                                        System.out.println(displayYearOfBirthGender(cccdNumber));
                                                                        break;
                                                                    case 3:
                                                                        System.out.println("Số ngẫu nhiên: " + displayRandomNumber(cccdNumber));
                                                                        break;
                                                                    case 0:
                                                                        System.exit(0);
                                                                }
                                                                displayFunction();
                                                            } else {
                                                                displayFunction();
                                                            }
                                                        }
                                                    } else {
                                                        System.out.print("Nhập số CCCD: ");
                                                    }
                                                }
                                            // hết đoạn lặp code
                                            } else {
                                                System.out.println("Nhập mã xác thực: " + randomCode);
                                            }
                                        }
                                    case 0:
                                        String randomAlphanumericCode = getAlphanumeric(6);
                                        System.out.println("Nhập mã xác thực: " + randomAlphanumericCode);
                                        while (input.hasNext()) {
                                            String verificationCode = input.nextLine();
                                            if (checkSixCharacterCode(verificationCode, randomAlphanumericCode)) {
                                                // lặp code với đoạn if (checkVerificationCode(verificationCode, randomCode)) ở phía trên
                                                // nên tách ra một hàm
                                                System.out.print("Nhập số CCCD: ");
                                                while (input.hasNext()) {
                                                    String cccdNumber = input.nextLine();
                                                    if (checkCccdNumber(cccdNumber)) {
                                                        displayFunction();
                                                        while (input.hasNext()) {
                                                            String functionNumber = input.nextLine();
                                                            if (checkInputFunction(functionNumber)) {
                                                                int inputFunctionNumber = Integer.parseInt(functionNumber);
                                                                switch (inputFunctionNumber) {
                                                                    case 1:
                                                                        System.out.println("Nơi sinh: " + showAddress(cccdNumber));
                                                                        break;
                                                                    case 2:
                                                                        System.out.println(displayYearOfBirthGender(cccdNumber));
                                                                        break;
                                                                    case 3:
                                                                        System.out.println("Số ngẫu nhiên: " + displayRandomNumber(cccdNumber));
                                                                        break;
                                                                    case 0:
                                                                        System.exit(0);
                                                                }
                                                                displayFunction();
                                                            } else {
                                                                displayFunction();
                                                            }
                                                        }
                                                    } else {
                                                        System.out.print("Nhập số CCCD: ");
                                                    }
                                                }
                                            // hết đoạn lặp code
                                            }
                                            else {
                                                System.out.println("Nhập mã xác thực: " + randomAlphanumericCode);
                                            }

                                        }
                                }
                            } else {
                                System.out.print("Chọn mã bảo mật: ");
                            }
                        }
                    case 0:
                        break;
                }
            } else {
                System.out.print("Nhập chức năng: ");
            }
        }
    }
    public static boolean checkSixCharacterCode(String string, String code) {
        if (string.equals(code)) {
            return true;
        }
        return false;
    }
    public static String getAlphanumeric(int n) {
        String alphanumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(Math.random() * alphanumericString.length());
            stringBuilder.append(alphanumericString.charAt(index));
        }
        return stringBuilder.toString();
    }
    public static void displaySoftwareInformation()
    {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| " + "NGAN HANG SO" + " | " + AUTHOR + VERSION + "         |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Nhap CCCD                                  |");
        System.out.println("| 0. Thoat                                      |");
        System.out.println("+----------+-------------------------+----------+");
    }
    public static boolean checkInputNumber(String number) {
        int inputNumber;

        try {
            inputNumber = Integer.parseInt(number);
            // có thể đưa vào khối default của lệnh switch(checkNumber)
            if (inputNumber > 1 || inputNumber < 0) {
                System.out.println("Nhập chức năng không đúng. Vui lòng nhập lại!");
                return false;
            }
            return true;
        } catch (NumberFormatException exception) {
            System.out.println("Nhập chức năng không đúng. Vui lòng nhập lại!");
            return false;
        }
    }
    public static boolean checkInputFunction(String number) {
        int inputNumber;

        try {
            inputNumber = Integer.parseInt(number);
            // có thể đưa vào khối default của lệnh switch(inputFunctionNumber)
            if (inputNumber > 3 || inputNumber < 0) {
                System.out.println("Chọn chức năng không đúng. Vui lòng nhập lại!");
                return false;
            }
            return true;
        } catch (NumberFormatException exception) {
            System.out.println("Chọn chức năng không đúng. Vui lòng nhập lại!");
            return false;
        }
    }
    public static boolean checkVerificationCode(String number, int code) {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(number);
            if (inputNumber == code) {
                return true;
            } else {
                System.out.println("Mã xác thực không đúng. Vui lòng nhập lại!");
                return false;
            }
        } catch (NumberFormatException exception) {
            System.out.println("Mã xác thực không đúng. Vui lòng nhập lại!");
            return false;
        }
    }
    public static boolean checkCccdNumber(String number) {
        long inputNumber;
        try {
            inputNumber = Long.parseLong(number);
            String inputString = String.valueOf(inputNumber);
            if (inputString.length() == 11) {
                return true;
            } else {
                // Thiếu chức năng nhập 'No' để thoát
                System.out.println("Số CCCD không hợp lệ. Vui lòng nhập lại!");
                return false;
            }

        } catch (NumberFormatException exception) {
            System.out.println("Số CCCD không hợp lệ. Vui lòng nhập lại!");
            return false;
        }
    }
    public static String showAddress(String number) {
        String firstThreeCharacter = number.substring(0, 3);
        HashMap<Integer, String> province = new HashMap<>();
        HashMap<Integer, String> code = new HashMap<>();
        province.put(1, "Hà Nội");
        province.put(2, "Hà Giang");
        province.put(3, "Cao Bằng");
        province.put(4, "Bắc Kạn");
        province.put(5, "Tuyên Quang");
        province.put(6, "Lào Cai");
        province.put(7, "Điện Biên");
        province.put(8, "Lai Châu");
        province.put(9, "Sơn La");
        province.put(10, "Yên Bái");
        province.put(11, "Hòa Bình");
        province.put(12, "Thái Nguyên");
        province.put(13, "Lạng Sơn");
        province.put(15, "Bắc Giang");
        province.put(14, "Quảng Ninh");
        province.put(16, "Phú Thọ");
        province.put(17, "Vĩnh Phúc");
        province.put(18, "Bắc Ninh");
        province.put(19, "Hải Dương");
        province.put(20, "Hải Phòng");
        province.put(21, "Hưng Yên");
        province.put(22, "Thái Bình");
        province.put(23, "Hà Nam");
        province.put(24, "Nam Định");
        province.put(25, "Ninh Bình");
        province.put(26, "Thanh Hóa");
        province.put(27, "Nghệ An");
        province.put(28, "Hà Tĩnh");
        province.put(29, "Quảng Bình");
        province.put(30, "Quảng Trị");
        province.put(31, "Thừa Thiên Huế");
        province.put(32, "Đà Nẵng");
        province.put(33, "Quảng Nam");
        province.put(34, "Quảng Ngãi");
        province.put(35, "Bình Định");
        province.put(36, "Phú Yên");
        province.put(37, "Khánh Hòa");
        province.put(38, "Ninh Thuận");
        province.put(39, "Bình Thuận");
        province.put(40, "Kon Tum");
        province.put(41, "Gia Lai");
        province.put(42, "ĐắK Lắk");
        province.put(43, "Đắk Nông");
        province.put(44, "Lâm Đồng");
        province.put(45, "Bình Phước");
        province.put(46, "Tây Ninh");
        province.put(47, "Bình Dương");
        province.put(48, "Đồng Nai");
        province.put(49, "Bà Rịa Vũng Tàu");
        province.put(50, "Hồ Chí Minh");
        province.put(51, "Long An");
        province.put(52, "Tiền Giang");
        province.put(53, "Bến Tre");
        province.put(54, "Trà Vinh");
        province.put(55, "Vĩnh Long");
        province.put(56, "Đồng Tháp");
        province.put(57, "An Giang");
        province.put(58, "Kiên Giang");
        province.put(59, "Cần Thơ");
        province.put(60, "Hậu Giang");
        province.put(61, "Sóc Trăng");
        province.put(62, "Bạc Liêu");
        province.put(63, "Cà Mau");
        code.put(1, "001");
        code.put(2, "002");
        code.put(3, "004");
        code.put(4, "006");
        code.put(5, "008");
        code.put(6, "010");
        code.put(7, "011");
        code.put(8, "012");
        code.put(9, "014");
        code.put(10, "015");
        code.put(11, "017");
        code.put(12, "019");
        code.put(13, "020");
        code.put(14, "022");
        code.put(15, "024");
        code.put(16, "025");
        code.put(17, "026");
        code.put(18, "027");
        code.put(19, "030");
        code.put(20, "031");
        code.put(21, "033");
        code.put(22, "034");
        // thiếu key 23;
        code.put(24, "036");
        code.put(25, "037");
        code.put(26, "038");
        code.put(27, "040");
        code.put(28, "042");
        code.put(29, "044");
        code.put(30, "045");
        code.put(31, "046");
        code.put(32, "048");
        code.put(33, "049");
        code.put(34, "051");
        code.put(35, "052");
        code.put(36, "054");
        code.put(37, "056");
        code.put(38, "058");
        code.put(39, "060");
        code.put(40, "062");
        code.put(41, "064");
        code.put(42, "066");
        code.put(43, "067");
        code.put(44, "068");
        code.put(45, "070");
        code.put(46, "072");
        code.put(47, "074");
        code.put(48, "075");
        code.put(49, "077");
        code.put(50, "079");
        code.put(51, "080");
        code.put(52, "082");
        code.put(53, "083");
        code.put(54, "084");
        code.put(55, "086");
        code.put(56, "087");
        code.put(57, "089");
        code.put(58, "091");
        code.put(59, "092");
        code.put(60, "093");
        code.put(61, "094");
        code.put(62, "095");
        code.put(63, "096");
        for (int i = 1; i < code.size(); i++) {
            if (code.get(i).equals(firstThreeCharacter)) {
                return province.get(i);
            }
        }
        return null;
    }
    public static String displayYearOfBirthGender(String number) {
        String firstCharacter = number.substring(3, 4);
        int firstNumber = Integer.parseInt(firstCharacter);
        String nextCharacter = number.substring(4, 6);
        HashMap<Integer, String> century = new HashMap<>();
        HashMap<Integer, String> gender = new HashMap<>();
        gender.put(0, "Nam");
        gender.put(1, "Nữ");
        gender.put(2, "Nam");
        gender.put(3, "Nữ");
        gender.put(4, "Nam");
        gender.put(5, "Nữ");
        gender.put(6, "Nam");
        gender.put(7, "Nữ");
        gender.put(8, "Nam");
        gender.put(9, "Nữ");
        century.put(0, "19");
        century.put(1, "19");
        century.put(2, "20");
        century.put(3, "20");
        century.put(4, "21");
        century.put(5, "21");
        century.put(6, "22");
        century.put(7, "22");
        century.put(8, "23");
        century.put(9, "23");
        for (int i = 0; i < gender.size(); i++) {
            if (firstNumber == i) {
                return "Giới tính: " + gender.get(i) + " | Năm sinh: " + century.get(i) + nextCharacter;
            }
        }
        return null;
    }
    public static String displayRandomNumber(String number) {

        return number.substring(7);
    }
    public static void displayFunction() {
        System.out.println("| 1. Kiểm tra nơi sinh");
        System.out.println("| 2. Kiểm tra năm sinh, giới tính");
        System.out.println("| 3. Kiểm tra số ngẫu nhiên");
        System.out.println("| 0. Thoát");
        System.out.print("Chọn chức năng: ");
    }
    public static void displayAuthentication() {
        System.out.println("| 1. Chọn mã bảo mật 3 ký tự");
        System.out.println("| 0. Chọn mã bảo mật 6 ký tự");

    }
}
