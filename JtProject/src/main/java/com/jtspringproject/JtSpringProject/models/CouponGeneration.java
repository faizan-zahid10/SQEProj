// CouponGenerator.java
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CouponGenerator {
    public static List<String> generateCouponCodes(int numberOfCoupons) {
        List<String> coupons = new ArrayList<>();
        int[] discountPercentages = {10, 20, 30, 40, 50}; // Add more percentages if needed

        for (int i = 0; i < numberOfCoupons; i++) {
            int randomIndex = (int) (Math.random() * discountPercentages.length);
            int discountPercentage = discountPercentages[randomIndex];

            String couponCode = generateRandomCouponCode() + "_DISCOUNT_" + discountPercentage;
            coupons.add(couponCode);
        }
        return coupons;
    }

    private static String generateRandomCouponCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
