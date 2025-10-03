package selenium.dropdowns.updated;

import org.openqa.selenium.By;

enum PassengerCategory {
    ADULT("spanAudlt", "hrefIncAdt"),
    CHILD("spanChild", "hrefIncChd"),
    INFANT("spanInfant", "hrefIncInf");

    private final String countId;
    private final String incrementId;

    PassengerCategory(String countId, String incrementId) {
        this.countId = countId;
        this.incrementId = incrementId;
    }

    public By getCountLocator() { return By.id(countId); }
    public By getIncrementLocator() { return By.id(incrementId); }
}